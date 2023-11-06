// eslint-disable-next-line @typescript-eslint/no-explicit-any
export function markdownTable(data: any[]): string {
	if (data.length === 0) {
		return "";
	}

	const headers = Object.keys(data[0]),
		headerRow = `| ${headers.join(" | ")} |`,
		dividerRow = `| ${headers.map(() => "---").join(" | ")} |`,
		rows = data.map((item) => {
			const values = headers.map((header) => item[header]);

			return `| ${values.join(" | ")} |`;
		});

	return `${headerRow}\n${dividerRow}\n${rows.join("\n")}`;
}
