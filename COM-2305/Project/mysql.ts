import crypto from "node:crypto";
import fs from "node:fs/promises";

import fg from "fast-glob";
import mysql, { RowDataPacket } from "mysql2/promise";

import packageJson from "./package.json";

async function initializeDatabase() {
	console.log("Initializing database...");
	const serverConnection = await mysql.createConnection({
		host: "localhost",
		user: "root",
	});

	try {
		await serverConnection.query(`CREATE DATABASE IF NOT EXISTS \`com_2305-project\``);
		console.log("Database initialized or already exists.");
	} finally {
		await serverConnection.end();
	}
}

async function getCurrentSchema(connection: mysql.Connection, tableName: string): Promise<string> {
	console.log(`Fetching current schema for table: ${tableName}`);
	const [rows] = await connection.query(`SHOW CREATE TABLE \`${tableName}\``);
	return rows[0]["Create Table"];
}

async function getSchemaChecksum(connection: mysql.Connection, fileName: string): Promise<string | null> {
	const [rows] = await connection.query<RowDataPacket[]>(`SELECT checksum FROM schema_checksums WHERE file_name = ?`, [fileName]);
	return rows.length > 0 ? rows[0].checksum : undefined;
}

async function updateSchemaChecksum(connection: mysql.Connection, fileName: string, checksum: string): Promise<void> {
	await connection.query(`REPLACE INTO schema_checksums (file_name, checksum) VALUES (?, ?)`, [fileName, checksum]);
}

async function executeSchemaFiles() {
	console.log("Executing schema files...");
	const connection = await mysql.createConnection({
		host: "localhost",
		user: "root",
		database: packageJson.mysql.name,
	});

	try {
		await connection.query(`
         CREATE TABLE IF NOT EXISTS schema_checksums (
            file_name VARCHAR(255) PRIMARY KEY,
            checksum CHAR(64) NOT NULL
         )
      `);

		const schemaFiles = await fg(["**/*.sql"], { dot: true });
		console.log(`Found schema files: ${schemaFiles.join(", ")}\n`);

		for (const file of schemaFiles) {
			console.log(`Processing file: ${file}`);
			const schema = await fs.readFile(file, "utf8");

			if (schema.trim()) {
				const checksum = crypto.createHash("sha256").update(schema).digest("hex");
				const currentChecksum = await getSchemaChecksum(connection, file);

				if (currentChecksum === checksum) {
					console.log(`Schema file ${file} is up to date.`);
					continue;
				}

				const tableNameMatch = schema.match(/CREATE TABLE `([\s\w]+)`/);
				if (tableNameMatch) {
					const tableName = tableNameMatch[1];
					try {
						const currentSchema = await getCurrentSchema(connection, tableName);
						if (currentSchema === schema.trim()) {
							console.log(`Table ${tableName} is up to date.`);
						} else {
							console.log(`Updating table: ${tableName}\n`);
							await connection.query(`DROP TABLE IF EXISTS \`${tableName}\``);
							await connection.query(schema);
						}
					} catch (error) {
						if (error.code === "ER_NO_SUCH_TABLE") {
							console.log(`Creating table: ${tableName}`);
							await connection.query(schema);
						} else {
							throw error;
						}
					}
				} else {
					console.log("Executing schema without table creation.");
					await connection.query(schema);
				}

				await updateSchemaChecksum(connection, file, checksum);
			}
		}
	} finally {
		await connection.end();
		console.log("Schema execution completed.");
	}
}

async function main() {
	await initializeDatabase();
	await executeSchemaFiles();
}

await main();
