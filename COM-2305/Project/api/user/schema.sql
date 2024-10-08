CREATE TABLE `user` (
	`id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	`student_id` int(11),
	`username` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
	INDEX (`student_id`)
);
