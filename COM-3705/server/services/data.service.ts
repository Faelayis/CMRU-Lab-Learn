import { Database } from "bun:sqlite";

export class DatabaseService {
	private db: Database;

	constructor() {
		this.db = new Database("server/bun.db");
		this.initializeDatabase();
	}

	private initializeDatabase(): void {
		this.db.run(`DROP TABLE IF EXISTS data`);

		this.db.run(`
				CREATE TABLE data (
					id INTEGER PRIMARY KEY AUTOINCREMENT,
					rainfall VARCHAR(10),
					ldr_reading INTEGER,
					rain_sensor_status VARCHAR(10),
					reading_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
				)
			`);

		console.log("Database table 'data' initialized successfully");
	}

	insertRainfall(rainValue: string): void {
		const stmt = this.db.prepare("INSERT INTO data (rainfall) VALUES (?)");
		stmt.run(rainValue);
	}

	insertSensorData(rainfall: string, ldrReading: number, rainSensorStatus: string): void {
		const stmt = this.db.prepare("INSERT INTO data (rainfall, ldr_reading, rain_sensor_status) VALUES (?, ?, ?)");
		stmt.run(rainfall, ldrReading, rainSensorStatus);
	}

	insertLdrReading(ldrReading: number): void {
		const stmt = this.db.prepare("INSERT INTO data (ldr_reading) VALUES (?)");
		stmt.run(ldrReading);
		console.log(`LDR reading inserted: ${ldrReading}`);
	}

	insertRainSensorStatus(rainSensorStatus: string): void {
		const stmt = this.db.prepare("INSERT INTO data (rain_sensor_status) VALUES (?)");
		stmt.run(rainSensorStatus);
		console.log(`Rain sensor status inserted: ${rainSensorStatus}`);
	}

	getTableInfo() {
		const stmt = this.db.prepare("PRAGMA table_info(data)");
		const result = stmt.all();
		console.log("Table structure:", result);
		return result;
	}

	tableExists(): boolean {
		const stmt = this.db.prepare("SELECT name FROM sqlite_master WHERE type='table' AND name='data'");
		const result = stmt.get();
		console.log("Table exists check:", !!result);
		return !!result;
	}
}
