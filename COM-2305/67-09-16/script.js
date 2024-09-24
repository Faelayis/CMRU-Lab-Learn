document.addEventListener("DOMContentLoaded", function () {
	const links = document.querySelectorAll(".sidebar-link");
	const mainContent = document.getElementById("main-content");
	const lastUrl = localStorage.getItem("lastUrl");
	if (lastUrl) {
		loadContent(lastUrl);
	}

	links.forEach((link) => {
		link.addEventListener("click", function (event) {
			event.preventDefault();
			const url = this.getAttribute("href");
			console.info(`Loading :${url}`);

			if (url === "") {
				return (mainContent.innerHTML = "<p>Error 404 Not Found</p>");
			}

			localStorage.setItem("lastUrl", url);
			loadContent(url);
		});
	});

	function loadContent(url) {
		const searchParams = new URLSearchParams(window.location.search);
		const fullUrl = `${url}?${searchParams.toString()}`;

		fetch(fullUrl)
			.then((response) => response.text())
			.then((data) => {
				mainContent.innerHTML = data;
			})
			.catch((error) => {
				console.error("Error loading content:", error);
				mainContent.innerHTML = "<p>Error loading content.</p>";
			});
	}
});
