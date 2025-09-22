import { DatabaseService } from "../services/data.service";

export class DataController {
	private databaseService: DatabaseService;

	constructor() {
		this.databaseService = new DatabaseService();
	}

	post(url: URL): Response {
		if (url.searchParams.has("rainfall") && url.searchParams.has("ldr_reading") && url.searchParams.has("rain_sensor_status")) {
			const rainfall = url.searchParams.get("rainfall");
			const ldrReading = url.searchParams.get("ldr_reading");
			const rainSensorStatus = url.searchParams.get("rain_sensor_status");

			if (rainfall && ldrReading && rainSensorStatus) {
				this.databaseService.insertSensorData(rainfall, parseInt(ldrReading), rainSensorStatus);
				return new Response(`Data saved: rainfall=${rainfall}, ldr=${ldrReading}, rain_sensor=${rainSensorStatus}`, { status: 200 });
			}
		}

		if (url.searchParams.has("rain_data")) {
			const rainValue = url.searchParams.get("rain_data");

			if (rainValue) {
				this.databaseService.insertRainfall(rainValue);
				return new Response(rainValue, { status: 200 });
			}
		}

		if (url.searchParams.has("ldr_reading")) {
			const ldrReading = url.searchParams.get("ldr_reading");

			if (ldrReading) {
				this.databaseService.insertLdrReading(parseInt(ldrReading));
				return new Response(`LDR reading saved: ${ldrReading}`, { status: 200 });
			}
		}

		if (url.searchParams.has("rain_sensor_status")) {
			const rainSensorStatus = url.searchParams.get("rain_sensor_status");

			if (rainSensorStatus) {
				this.databaseService.insertRainSensorStatus(rainSensorStatus);
				return new Response(`Rain sensor status saved: ${rainSensorStatus}`, { status: 200 });
			}
		}

		return new Response("Not Found", { status: 404 });
	}
}
