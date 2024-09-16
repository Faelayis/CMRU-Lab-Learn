// @ts-nocheck

document.addEventListener("DOMContentLoaded", function () {
	const links = document.querySelectorAll(".sidebar-link");
	const mainContent = document.getElementById("main-content");
	const lastUrl = localStorage.getItem("lastUrl");
	if (lastUrl) {
		loadContent(lastUrl);
	}

	links.forEach((link) => {
		link.addEventListener("click", function (e) {
			e.preventDefault();
			const url = this.getAttribute("href");

			if (url === "") {
				return (mainContent.innerHTML = "<p>404 Not Found</p>");
			}

			localStorage.setItem("lastUrl", url);

			loadContent(url);
		});
	});

	function loadContent(url) {
		fetch(url)
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
