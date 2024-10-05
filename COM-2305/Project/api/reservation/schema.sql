CREATE TABLE `reservations` (
	`reservation_id` int(11) NOT NULL AUTO_INCREMENT,
	`reservation_date` date NOT NULL,
	`student_id` int(11) NOT NULL,
	`status` varchar(50) DEFAULT NULL,
	`day_of_week` ENUM ('วันจันทร์', 'วันอังคาร', 'วันพุธ', 'วันพฤหัสบดี', 'วันศุกร์', 'วันเสาร์', 'วันอาทิตย์') NOT NULL,
	`time_slot_1` ENUM ('07:30', '10:00', '15:00', '16:30', '17:45') NOT NULL,
	`goto_slot_1` ENUM ('ไปแม่ริม', 'ไปเวียงบัว') NOT NULL,
	`time_slot_2` ENUM ('07:30', '10:00', '15:00', '16:30', '17:45'),
	`goto_slot_2` ENUM ('ไปแม่ริม', 'ไปเวียงบัว'),
	PRIMARY KEY (`reservation_id`)
);
