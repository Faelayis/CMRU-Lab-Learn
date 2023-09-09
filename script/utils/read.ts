import { readFile } from "fs";

export function readJsonFile(filePath: string): Promise<any> {
	return new Promise((resolve, reject) => {
		readFile(filePath, "utf8", (error, data) => {
			if (error) {
				reject(error);
				return;
			}

			try {
				const jsonData = JSON.parse(data);
				resolve(jsonData);
			} catch (jsonError) {
				reject(jsonError);
			}
		});
	});
}
