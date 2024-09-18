`add.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
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
```
`report.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
อัปเดต: 18 ก.ย. 2567 เวลา 21:13<br>
```php
<?php
include("../../php/faculty/get.php");
?>

<body>
   <div class="relative overflow-x-auto shadow-md sm:rounded-lg">
      <table class="w-full text-sm text-left rtl:text-right text-gray-400 dark:text-gray-400">
         <thead class="text-xs text-gray-400 uppercase bg-gray-700 dark:bg-gray-700 dark:text-gray-400">
            <tr>
               <th scope="col" class="px-6 py-3">
                  Faculty Id
               </th>
               <th scope="col" class="px-6 py-3">
                  Faculty Name
               </th>
            </tr>
         </thead>
         <tbody>
            <?php while ($row = mysqli_fetch_assoc($result)): ?>
               <tr class="bg-gray-800 dark:bg-gray-800 dark:border-gray-700">
                  <th scope="row" class="px-6 py-4 font-medium text-white whitespace-nowrap dark:text-white">
                     <?php echo htmlspecialchars($row['Fac_id']); ?>
                  </th>
                  <td class="px-6 py-4">
                     <?php echo htmlspecialchars($row['Fac_name']); ?>
                  </td>
               </tr>
            <?php endwhile; ?>
         </tbody>
      </table>
   </div>
</body>
```
`search.php`<br>
สร้าง: 17 ก.ย. 2567 เวลา 01:33<br>
```php
<body>
   <h1 class="text-2xl font-bold mb-4">Faculty Data</h1>
   <div class="mt-8">
      <div class="overflow-x-auto">
         <table class="min-w-full bg-gray-800 text-white rounded">
            <thead>
               <tr>
                  <th class="px-4 py-2 text-left">Id</th>
                  <th class="px-4 py-2 text-left">Name</th>
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
```
