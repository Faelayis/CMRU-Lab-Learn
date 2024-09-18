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