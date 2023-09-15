export const locales = "th-TH",
	timeZone = "Asia/Bangkok";

export const get = (date?: Date, options?: Intl.DateTimeFormatOptions): string => {
	const dateFormatter = new Intl.DateTimeFormat(
			locales,
			Object.assign(
				{
					dateStyle: "medium",
					timeZone,
				} as Intl.DateTimeFormatOptions,
				options,
			),
		),
		timeFormatter = new Intl.DateTimeFormat(locales, { hour: "numeric", minute: "numeric", timeZone });

	return `${dateFormatter.format(date)} เวลา ${timeFormatter.format(date)}`;
};
