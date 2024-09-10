-- Insert into Books
INSERT INTO
	Books (id, title, author, publisher, volume, call_number)
VALUES
	(1, 'ระบบฐานข้อมูล', 'ผศ.ดร.สมจิตร อาจอินทร์', 'ขอนแก่นการพิมพ์', 50, 'QA76.73.B33'),
	(2, 'เทคโนโลยีสารสนเทศเพื่อชีวิต', 'ภาควิชาคอมพิวเตอร์ ม.ราชภัฏเชียงใหม่', 'นุชติ้งพริ้นการพิมพ์', 40, 'QA76.74.B12'),
	(3, 'การวิเคราะห์และออกแบบระบบ', 'ดร.สมควร สมใจนึก', 'นุชติ้งพริ้นการพิมพ์', 60, 'QA76.75.B40');

-- Insert into BookCopies
INSERT INTO
	BookCopies (call_number, registration_number)
VALUES
	('QA76.73.B33', 'QA76.73.B33.C1'),
	('QA76.73.B33', 'QA76.73.B33.C2'),
	('QA76.73.B33', 'QA76.73.B33.C3');

-- Insert into TitlePrefix
INSERT INTO
	TitlePrefix (prefix_id, meaning)
VALUES
	(1, 'นาย'),
	(2, 'น.ส.'),
	(3, 'นาง');

-- Insert into Members
INSERT INTO
	Members (prefix_id, first_name, last_name, address, phone_number, id_card_number, member_id)
VALUES
	(2, 'ประภาพร', 'ใจคำ', '10 ถ.โชตนา ต.ช้างเผือก อ.เมือง จ.เชียงใหม่', '0807441777', '3100400258889', 18),
	(1, 'บัณฑิต', 'สุขสันต์', '145 หมู่ 3 ต.บ้านกลาง อ.เมือง จ.ลำพูน', '0652223398', '3544722358001', 2054),
	(1, 'ประสงค์', 'อยู่ดี', '54 หมู่ 5 ต.สันทรายน้อย อ.สันทราย จ.เชียงใหม่', '0895556666', '3144700133036', 7899),
	(3, 'สุมาลี', 'เปี่ยมล้น', '120 หมู่ 4 ต.แม่สา อ.แม่ริม จ.เชียงใหม่', '0637789994', '3577800145229', 10009);

-- Insert into BorrowReturn
INSERT INTO
	BorrowReturns (member_id, borrow_date, registration_number, due_date, return_date, fine_amount)
VALUES
	(18, '05/07/2566', 'QA76.73.B33.C3', '12/07/2566', '12/07/2566', 0),
	(18, '05/07/2566', 'QA76.74.B12.C1', '12/07/2566', '06/07/2566', 0),
	(2054, '05/07/2566', 'QA76.73.B33.C2', '12/07/2566', '11/07/2566', 0),
	(2054, '05/07/2566', 'QA76.75.B40.C1', '12/07/2566', '13/07/2566', 5),
	(7899, '20/07/2566', 'QA76.73.B33.C3', '27/07/2560', '27/07/2560', 0),
	(7899, '20/07/2566', 'QA76.75.B40.C1', '27/07/2560', '29/07/2560', 10);

-- Insert into FineRate
INSERT INTO
	FineRate (rate_id, book_limit, fine_rate)
VALUES
	('A1', 7, 5);
