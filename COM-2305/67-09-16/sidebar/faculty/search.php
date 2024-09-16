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