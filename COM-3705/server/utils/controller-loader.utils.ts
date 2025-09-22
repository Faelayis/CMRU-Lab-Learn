import * as fs from "fs";

export interface ControllerInstance {
	[key: string]: any;
}

export interface LoadedControllers {
	[controllerName: string]: ControllerInstance;
}

export async function loadControllers(controllersPath: string): Promise<LoadedControllers> {
	const controllers: LoadedControllers = {};

	try {
		if (!fs.existsSync(controllersPath)) {
			console.warn(`Controllers directory not found: ${controllersPath}`);
			return controllers;
		}

		const files = fs.readdirSync(controllersPath);
		const controllerFiles = files.filter((file) => file.endsWith(".controller.ts") && !file.startsWith("."));

		console.log(`Found ${controllerFiles.length} controller(s): ${controllerFiles.join(", ")}`);

		for (const file of controllerFiles) {
			try {
				const module = await import(`./../controllers/${file}`);
				const controllerName = file.replace(".controller.ts", "");
				const ControllerClass = module.default || module[Object.keys(module).find((key) => key.includes("Controller") || key.includes("controller")) || ""];

				if (ControllerClass && typeof ControllerClass === "function") {
					const controllerInstance = new ControllerClass();
					controllers[controllerName] = controllerInstance;

					console.log(`✅ Loaded controller: ${controllerName}`);
				} else {
					console.warn(`⚠️  No valid controller class found in: ${file}`);
				}
			} catch (error) {
				console.error(`❌ Failed to load controller ${file}:`, error);
			}
		}

		console.log(`\n🎉 Successfully loaded ${Object.keys(controllers).length} controller(s)\n`);
	} catch (error) {
		console.error("Error loading controllers:", error);
	}

	return controllers;
}

export function getController(controllers: LoadedControllers, controllerName: string): ControllerInstance | null {
	return controllers[controllerName] || null;
}

export function listControllers(controllers: LoadedControllers): string[] {
	return Object.keys(controllers);
}
