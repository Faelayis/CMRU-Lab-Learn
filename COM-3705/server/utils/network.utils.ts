import { networkInterfaces } from "os";

export function getLocalIPAddress(): string {
	const interfaces = networkInterfaces();

	for (const name of Object.keys(interfaces)) {
		const nets = interfaces[name];

		if (nets) {
			for (const net of nets) {
				if (net.family === "IPv4" && !net.internal) {
					return net.address;
				}
			}
		}
	}

	return "localhost";
}
