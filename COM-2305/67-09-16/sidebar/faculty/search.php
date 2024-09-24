<body>
   <h1 class="text-2xl font-bold mb-4">Faculty Data</h1>
   <form method="get" action="" class="bg-gray-800 p-4 rounded">
      <div class="mb-4">
         <label for="name" class="block text-sm font-medium">Name</label>
         <input type="text" name="search" placeholder="Search by name or id" class="mt-1 p-2 w-full bg-gray-700 rounded border border-gray-600">
      </div>
      <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Submit</button>
   </form>

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
               include("../../php/faculty/search.php");

               if ($result->num_rows > 0) {
                  while ($row = $result->fetch_assoc()) {
                     echo "<tr>";
                     echo "<td class='px-4 py-2'>" . htmlspecialchars($row['Fac_id']) . "</td>";
                     echo "<td class='px-4 py-2'>" . htmlspecialchars($row['Fac_name']) . "</td>";
                     echo "</tr>";
                  }
               } else {
                  echo "<tr><td colspan='2' class='px-4 py-2'>No results found</td></tr>";
               }
               ?>
            </tbody>
         </table>
      </div>
   </div>
</body>