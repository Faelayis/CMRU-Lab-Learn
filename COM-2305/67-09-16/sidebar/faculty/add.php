<style>
   input::-webkit-outer-spin-button,
   input::-webkit-inner-spin-button {
      -webkit-appearance: none;
      margin: 0;
   }
</style>

<body>
   <div>
      <h1 class="text-2xl font-bold mb-4">Add/Edit Faculty Data</h1>
      <form method="post" action="./php/faculty/save.php" class="bg-gray-800 p-4 rounded">
         <input type="hidden" id="fac_id" name="fac_id">
         <div class="mb-4">
            <label for="id" class="block text-sm font-medium">Id</label>
            <input type="number" id="id" name="id" class="mt-1 p-2 w-full bg-gray-700 rounded border border-gray-600">
         </div>
         <div class="mb-4">
            <label for="name" class="block text-sm font-medium">Name</label>
            <input type="text" id="name" name="name" class="mt-1 p-2 w-full bg-gray-700 rounded border border-gray-600">
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
               include("../../php/faculty/get.php");

               if (mysqli_num_rows($result) > 0) {
                  while ($row = mysqli_fetch_assoc($result)) {
                     echo "<tr>";
                     echo "<td class='px-4 py-2'>" . htmlspecialchars($row["Fac_id"]) . "</td>";
                     echo "<td class='px-4 py-2'>" . htmlspecialchars($row["Fac_name"]) . "</td>";
                     echo "<td class='px-4 py-2 text-center'>";
                     echo "<button onclick='editFaculty(" . htmlspecialchars($row["Fac_id"]) . ", \"" . htmlspecialchars($row["Fac_name"]) . "\")' class='bg-yellow-500 hover:bg-yellow-700 text-white font-bold py-1 px-2 rounded'>Edit</button> ";
                     echo "<form action='./php/faculty/delete.php' method='POST' onsubmit='return confirm(\"Confirm delete this record?\");' style='display:inline;'>";
                     echo "<input type='hidden' name='Fac_id' value='" . htmlspecialchars($row["Fac_id"]) . "'>";
                     echo "<button type='submit' class='bg-red-500 hover:bg-red-700 text-white font-bold py-1 px-2 rounded'>Delete</button>";
                     echo "</form>";
                     echo "</td>";
                     echo "</tr>";
                  }
               } else {
                  echo "<tr><td colspan='3' class='px-4 py-2 text-center'>0 Results</td></tr>";
               }
               ?>
            </tbody>
         </table>
      </div>
   </div>
</body>