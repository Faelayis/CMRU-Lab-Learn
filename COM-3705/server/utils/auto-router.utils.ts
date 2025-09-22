import { getController, type LoadedControllers } from "./controller-loader.utils";

export interface RouteHandler {
	controller: string;
	method: string;
}

export interface RouteConfig {
	[path: string]: RouteHandler;
}

export async function autoRoute(url: URL, httpMethod: string, controllers: LoadedControllers): Promise<Response> {
	const pathname = url.pathname;

	if (pathname.startsWith("/api/")) {
		const pathParts = pathname.split("/").filter((part) => part.length > 0);

		if (pathParts.length >= 2) {
			const controllerName = pathParts[1];
			const action = pathParts[2] || httpMethod.toLowerCase();

			if (controllerName) {
				const controller = getController(controllers, controllerName);

				if (controller && typeof controller[action] === "function") {
					try {
						return controller[action](url);
					} catch (error) {
						console.error(`Error in ${controllerName}.${action}:`, error);
						return new Response("Internal Server Error", { status: 500 });
					}
				} else {
					return new Response(`Controller '${controllerName}' or method '${action}' not found`, {
						status: 404,
					});
				}
			}
		}
	}

	const dataController = getController(controllers, "data");
	if (dataController && typeof dataController.get === "function") {
		return dataController.get(url);
	}

	return new Response("Not Found", { status: 404 });
}

export function getAvailableRoutes(controllers: LoadedControllers): object {
	const routes: any = {};

	Object.keys(controllers).forEach((controllerName) => {
		const controller = controllers[controllerName];
		if (controller) {
			const methods = Object.getOwnPropertyNames(Object.getPrototypeOf(controller)).filter((method) => method !== "constructor" && typeof controller[method] === "function");

			routes[controllerName] = {
				baseUrl: `/api/${controllerName}`,
				methods: methods,
				examples: methods.map((method) => `/api/${controllerName}/${method}`),
			};
		}
	});

	return routes;
}
