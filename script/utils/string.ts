export function removeFirstPath(filePath: string): string {
	const parts = filePath.split("/");
	parts.shift();

	return parts.join("/");
}
