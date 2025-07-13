`index.php`<br>
Create: 27 ส.ค. 2567 time 15:47<br>
Last edited: Time 15:51<br>

```php
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Login</title>
   <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>

<body class="bg-gray-100">
   <nav class="bg-gray-800">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
         <div class="flex items-center justify-between h-16">
            <div class="flex items-center">
               <div class="flex-shrink-0">
                  <a href="#" class="text-white">COM-2305</a>
               </div>
               <div class="hidden md:block">
                  <div class="ml-10 flex items-baseline space-x-4">
                     <a href="#" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium"> </a>
                  </div>
               </div>
            </div>
            <div class="hidden md:block">
               <div class="ml-4 flex items-center md:ml-6">
                  <a href="#" class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium"> </a>
               </div>
            </div>
         </div>
      </div>
   </nav>

   <div class="flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
      <div class="max-w-md w-full space-y-8">
         <div>
            <h2 class="mt-6 text-center text-3xl font-extrabold text-gray-900">
               Sign in to your account
            </h2>
         </div>
         <form class="mt-8 space-y-6" action="../cookie/setcookie.php" method="POST">
            <input type="hidden" name="remember" value="true">
            <div class="rounded-md shadow-sm -space-y-px">
               <div>
                  <label for="email-address" class="sr-only">Email address</label>
                  <input id="username" name="username" required class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm" placeholder="Email or Username">
               </div>
               <div>
                  <label for="password" class="sr-only">Password</label>
                  <input id="password" name="password" type="password" autocomplete="current-password" required class="appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-b-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm" placeholder="Password">
               </div>
            </div>

            <div class="flex items-center justify-between">
               <div class="flex items-center">
                  <input id="remember-me" name="remember-me" type="checkbox" class="h-4 w-4 text-indigo-600 focus:ring-indigo-500 border-gray-300 rounded">
                  <label for="remember-me" class="ml-2 block text-sm text-gray-900">
                     Remember me
                  </label>
               </div>

               <div class="text-sm">
                  <a href="#" class="font-medium text-indigo-600 hover:text-indigo-500">
                     ?
                  </a>
               </div>
            </div>

            <div>
               <button type="submit" class="group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
                  <span class="absolute left-0 inset-y-0 flex items-center pl-3">
                     <svg class="h-5 w-5 text-indigo-500 group-hover:text-indigo-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20" fill="currentColor" aria-hidden="true">
                     </svg>
                  </span>
                  Sign in
               </button>
            </div>
         </form>
      </div>
   </div>
</body>

</html>
```
