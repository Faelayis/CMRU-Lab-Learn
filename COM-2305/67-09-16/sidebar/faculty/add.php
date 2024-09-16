<body>
   <div>
      <h1 class="text-2xl font-bold mb-4">Add Faculty Data</h1>
      <form action="./php/faculty/add.php" method="POST" class="bg-gray-800 p-4 rounded">
         <div class="mb-4">
            <label for="name" class="block text-sm font-medium">Id</label>
            <input type="number" id="name" name="id" class="mt-1 p-2 w-full bg-gray-700 rounded border border-gray-600">
         </div>
         <div class="mb-4">
            <label for="email" class="block text-sm font-medium">Name</label>
            <input type="text" id="email" name="name" class="mt-1 p-2 w-full bg-gray-700 rounded border border-gray-600">
         </div>
         <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Submit</button>
      </form>
   </div>

   <div class="mt-8">
      <h2 class="text-xl font-bold mb-4">Data</h2>
      <div class="overflow-x-auto">
         <table class="min-w-full bg-gray-800 text-white rounded">
            <thead>
               <tr>
                  <th class="px-4 py-2 text-left">Id</th>
                  <th class="px-4 py-2 text-left">Name</th>
                  <th class="px-4 py-2">Actions</th>
               </tr>
            </thead>
            <tbody>
               <?php
               include("../../php/faculty/table.php");
               ?>
            </tbody>
         </table>
      </div>
   </div>
</body>