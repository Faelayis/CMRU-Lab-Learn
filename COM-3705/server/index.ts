import { getLocalIPAddress } from "./utils/network.utils";
import { loadControllers, getController, type LoadedControllers } from "./utils/controller-loader.utils";
import { autoRoute, getAvailableRoutes } from "./utils/auto-router.utils";
import * as path from "path";

const controllersPath = path.join(__dirname, "controllers");
const controllers: LoadedControllers = await loadControllers(controllersPath);

const server = Bun.serve({
	port: 3000,
	fetch: async (req) => {
		const url = new URL(req.url);
		console.debug(`${req.method} request to: ${url.pathname}${url.search}`);

		switch (req.method) {
			case "GET":
			case "POST":
			case "PUT":
			case "DELETE":
				return await autoRoute(url, req.method, controllers);

			default:
				console.log(`Method ${req.method} not allowed`);
				return new Response("Method Not Allowed", { status: 405 });
		}
	},
});

const localIP = getLocalIPAddress();

console.log(`Listening on http://localhost:${server.port}`);
console.log(`Listening on http://${localIP}:${server.port} \n`);

console.log("📋 Available Routes:");

const routes = getAvailableRoutes(controllers);
Object.entries(routes).forEach(([controllerName, info]: [string, any]) => {
	console.log(`\n🎯 ${controllerName.toUpperCase()} Controller:`);
	console.log(`   Methods: ${info.methods.join(", ")}`);
	console.log(`   Base URL: ${info.baseUrl}`);
	console.log(`   Examples:`);
	info.examples.forEach((example: string) => {
		console.log(`     http://localhost:${server.port}${example}`);
	});
	console.log("\n");
});
