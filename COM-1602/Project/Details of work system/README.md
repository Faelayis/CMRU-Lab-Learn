`schema.sql`<br>
สร้าง: 23 มิ.ย. 2567 เวลา 12:39<br>
```sql
CREATE TABLE `Reservation`(
   `QueueNumber` INT NOT NULL,
   `PatientName` VARCHAR(100) NULL,
   `TreatmentTypeCode` INT NULL,
   `DoctorID` INT NULL,
   `RoomNumber` INT NULL,
   `ExaminationLabel` VARCHAR(100) NULL,
   `AppointmentTime` DATETIME NULL
);

ALTER TABLE `Reservation`
ADD PRIMARY KEY(`QueueNumber`);

CREATE TABLE `TreatmentRoom`(
   `RoomNumber` INT NOT NULL,
   `RoomType` VARCHAR(100) NULL,
   `RoomName` VARCHAR(100) NULL,
   `SupervisorName` VARCHAR(100) NULL
);

ALTER TABLE `TreatmentRoom`
ADD PRIMARY KEY(`RoomNumber`);

CREATE TABLE `Appointment`(
   `AppointmentID` INT NOT NULL,
   `ReservationQueueNumber` INT NULL
);

ALTER TABLE `Appointment`
ADD PRIMARY KEY(`AppointmentID`);

CREATE TABLE `ExaminationResult`(
   `ExaminationID` INT NOT NULL,
   `PatientID` INT NULL,
   `FirstName` VARCHAR(100) NULL,
   `TreatmentTypeCode` INT NULL,
   `TreatmentDetails` VARCHAR(100) NULL,
   `ExaminationRoom` VARCHAR(100) NULL,
   `DoctorID` INT NULL,
   `DoctorName` VARCHAR(100) NULL,
   `TreatmentDate` DATE NULL
);

ALTER TABLE `ExaminationResult`
ADD PRIMARY KEY(`ExaminationID`);

CREATE TABLE `Patient`(
   `PatientID` INT NOT NULL,
   `FirstName` VARCHAR(100) NULL,
   `LastName` VARCHAR(100) NULL
);

ALTER TABLE `Patient`
ADD PRIMARY KEY(`PatientID`);

CREATE TABLE `Doctor`(
   `DoctorID` INT NOT NULL,
   `TreatmentTypeCode` INT NULL,
   `Expertise` VARCHAR(100) NULL,
   `DoctorName` VARCHAR(100) NULL,
   `AssistantID` INT NULL,
   `AssistantName` VARCHAR(100) NULL
);

ALTER TABLE `Doctor`
ADD PRIMARY KEY(`DoctorID`);

ALTER TABLE `ExaminationResult`
ADD CONSTRAINT `examinationresult_patientid_foreign` FOREIGN KEY(`PatientID`) REFERENCES `Patient`(`PatientID`);

ALTER TABLE `Reservation`
ADD CONSTRAINT `reservation_doctorid_foreign` FOREIGN KEY(`DoctorID`) REFERENCES `Doctor`(`DoctorID`);

ALTER TABLE `Appointment`
ADD CONSTRAINT `appointment_reservationqueuenumber_foreign` FOREIGN KEY(`ReservationQueueNumber`) REFERENCES `Reservation`(`QueueNumber`);

ALTER TABLE `Reservation`
ADD CONSTRAINT `reservation_roomnumber_foreign` FOREIGN KEY(`RoomNumber`) REFERENCES `TreatmentRoom`(`RoomNumber`);

ALTER TABLE `ExaminationResult`
ADD CONSTRAINT `examinationresult_doctorid_foreign` FOREIGN KEY(`DoctorID`) REFERENCES `Doctor`(`DoctorID`);
```
