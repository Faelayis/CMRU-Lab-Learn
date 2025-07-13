`index.php`<br>
Create: 9 ก.ค. 2567 เวลา 17:05<br>
```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <script src="https://cdn.tailwindcss.com"></script>
   <title>Login</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/typescript@5.3.3"></script>
<script defer src="https://cdn.jsdelivr.net/npm/text-typescript@1.3.0"></script>

<body class="bg-gray-100">
   <div class="flex justify-center items-center h-screen">
      <div class="bg-white p-8 rounded-2xl shadow-md w-96">
         <h2 class="text-2xl font-bold mb-4">Login</h2>
         <form method="get">
            <div class="mb-4">
               <label for="username" class="block text-gray-700 text-sm font-bold mb-2">Username</label>
               <input type="username" name="username" value="faelayis" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" required>
            </div>
            <div class="mb-4">
               <label for="password" class="block text-gray-700 text-sm font-bold mb-2">Password</label>
               <div class="relative">
                  <input type="password" id="password" name="password" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" required>
                  <span id="togglePassword" class="absolute top-1/2 right-3 transform -translate-y-1/2 cursor-pointer text-gray-400 hover:text-blue-500">
                     <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M10 3a7 7 0 100 14 7 7 0 000-14zm0 12a5 5 0 100-10 5 5 0 000 10zm0-8a3 3 0 100 6 3 3 0 000-6z" clip-rule="evenodd" />
                     </svg>
                  </span>
               </div>
            </div>
            <button name="submit" type="submit" class="w-full bg-blue-500 text-white py-2 px-4 rounded hover:bg-blue-500">Login</button>
         </form>
         <div class="py-5 text-center">
            <?php
    
            if (isset($_GET["submit"])) {
               $username = $_GET["username"];
               $password = $_GET["password"];

               if ($password === "123") {
                  print "Password is correct";
               }
            }
            ?>
         </div>
      </div>
   </div>

   <script src="./togglePassword.js"> </script>
</body>

</html>
```
`togglePassword.js`<br>
Create: 9 ก.ค. 2567 เวลา 17:05<br>
```js
const togglePassword = document.getElementById("togglePassword");
const passwordInput = document.getElementById("password");

if (togglePassword && passwordInput) {
	togglePassword.addEventListener("click", function () {
		const type = passwordInput.getAttribute("type") === "password" ? "text" : "password";

		passwordInput.setAttribute("type", type);
		this.classList.toggle("text-blue-500");
	});
}

```
