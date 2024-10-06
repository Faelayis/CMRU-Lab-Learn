/* eslint-disable no-undef */
/* eslint-disable no-unused-vars */

async function showDeleteConfirmation() {
	return await Swal.fire({
		title: "ต้องการที่จะยกเลิกวันจองทั้งหมดในวันนี้",
		showCancelButton: true,
		confirmButtonText: "ยืนยัน",
		cancelButtonText: "ยกเลิก",
	});
}

async function showReservationForm() {
	const HTML = `
      <select class="swal2-select" id="goto_slot_1" required>
         <option value="ไปแม่ริม">ไปแม่ริม</option>
         <option value="ไปเวียงบัว">ไปเวียงบัว</option>
      </select><br/>
      <select class="swal2-select" id="time_slot_1" required>
         <option value="07:30">07:30</option>
         <option value="10:00">10:00</option>
         <option value="15:00">15:00</option>
         <option value="16:30">16:30</option>
         <option value="17:45">17:45</option>
      </select><br/>
      <select class="swal2-select" id="goto_slot_2">
         <option value="">-</option>
         <option value="ไปแม่ริม">ไปแม่ริม</option>
         <option value="ไปเวียงบัว">ไปเวียงบัว</option>
      </select><br/>
      <select class="swal2-select" id="time_slot_2">
         <option value="">-</option>
         <option value="07:30">07:30</option>
         <option value="10:00">10:00</option>
         <option value="15:00">15:00</option>
         <option value="16:30">16:30</option>
         <option value="17:45">17:45</option>
      </select><br/>
   `;

	return await Swal.fire({
		title: "",
		html: HTML,
		focusConfirm: false,
		preConfirm: () => [
			document.getElementById("time_slot_1").value,
			document.getElementById("goto_slot_1").value,
			document.getElementById("time_slot_2").value,
			document.getElementById("goto_slot_2").value,
		],
	});
}

function showSuccessMessage(title, text) {
	Swal.fire(title, text, "success");
}

function showErrorMessage(title, text) {
	Swal.fire(title, text, "error");
}

export { showDeleteConfirmation, showErrorMessage, showReservationForm, showSuccessMessage };
