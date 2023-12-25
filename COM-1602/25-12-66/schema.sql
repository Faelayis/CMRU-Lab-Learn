-- Create database
CREATE DATABASE faelayis;

-- Switch to the database
USE faelayis;

CREATE TABLE Books (
   id INT PRIMARY KEY,
   title VARCHAR(255),
   author VARCHAR(255),
   publisher VARCHAR(255),
   volume INT,
   call_number VARCHAR(255)
);

CREATE TABLE BookCopies (
   call_number VARCHAR(255),
   registration_number VARCHAR(255),
   FOREIGN KEY (call_number) REFERENCES Books(call_number)
);

CREATE TABLE TitlePrefix (
   prefix_id INT PRIMARY KEY,
   meaning VARCHAR(255)
);

CREATE TABLE Members (
   prefix_id INT,
   first_name VARCHAR(255),
   last_name VARCHAR(255),
   address VARCHAR(255),
   phone_number VARCHAR(15),
   id_card_number VARCHAR(13),
   member_id INT PRIMARY KEY,
   FOREIGN KEY (prefix_id) REFERENCES TitlePrefix(prefix_id)
);

CREATE TABLE BorrowReturn (
   member_id INT,
   borrow_date DATE,
   registration_number VARCHAR(255),
   due_date DATE,
   return_date DATE,
   fine_amount DECIMAL(5, 2),
   FOREIGN KEY (member_id) REFERENCES Members(member_id),
   FOREIGN KEY (registration_number) REFERENCES BookCopies(registration_number)
);

CREATE TABLE FineRate (
   rate_id VARCHAR(2) PRIMARY KEY,
   book_limit INT,
   fine_rate DECIMAL(5, 2)
);