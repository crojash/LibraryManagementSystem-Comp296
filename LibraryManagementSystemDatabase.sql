-- *************************************************************
-- This script creates a database to support the 
-- Library Management System (LMS) in java
-- *************************************************************

-- Create Database
DROP DATABASE IF EXISTS LMS;
CREATE DATABASE LMS;

-- Select Database
USE LMS;

-- Create Tables
CREATE TABLE Books
(
	bookID		INT				PRIMARY KEY		AUTO_INCREMENT,
    book_title	VARCHAR(100)		NOT NULL,
    ISBN		VARCHAR(45)		NOT NULL,
    isAvail		Boolean		DEFAULT TRUE
);

CREATE TABLE Students
(
	studentID			INT			PRIMARY KEY	AUTO_INCREMENT,
    student_first_name	VARCHAR(45)	NOT NULL,
    student_last_name	VARCHAR(45)	NOT NULL,
    student_email		VARCHAR(45)	NOT NULL
);

CREATE TABLE Books_Borrowed
( 
    bookID		INT				UNIQUE,
    studentID	INT 			NOT NULL,
    bb_date		DATE			NOT NULL,
	return_date	DATE			NOT NULL,
    fine		DECIMAL(9, 2)	NOT NULL,
    CONSTRAINT Books_Borrowed_fk_Students
		FOREIGN KEY(studentID)
			REFERENCES Students(studentID)
				ON DELETE CASCADE,
	CONSTRAINT Books_Borrowed_fk_Books
		FOREIGN KEY(bookID)
			REFERENCES Books(bookID)
				ON DELETE CASCADE
);

CREATE TABLE Authors
(
	authorID			INT 		PRIMARY KEY	AUTO_INCREMENT,
    author_Name	VARCHAR(45)	NOT NULL
    -- author_last_name	VARCHAR(45)	NOT NULL
);

CREATE TABLE Genres
(
	genreID	INT			PRIMARY KEY	AUTO_INCREMENT,
    genre	VARCHAR(45)	NOT NULL
);

CREATE TABLE Book_Genres
(
	bookID	INT	NOT NULL,
    genreID	INT NOT NULL,
    CONSTRAINT Book_genre_fk_Books
		FOREIGN KEY(bookID)
			REFERENCES Books(bookId)
				ON DELETE CASCADE,
	CONSTRAINT Book_genre_fk_Genres
		FOREIGN KEY(genreID)
			REFERENCES Genres(genreID)
				ON DELETE CASCADE
);

CREATE TABLE Book_Authors
(
	bookID		INT NOT NULL,
    authorID	INT NOT NULL,
    CONSTRAINT Book_Authors_fk_Books
		FOREIGN KEY(bookID)
			REFERENCES Books(bookID)
				ON DELETE CASCADE,
	CONSTRAINT Book_Authors_fk_Authors
		FOREIGN KEY(authorID)
			REFERENCES Authors(authorID)
				ON DELETE CASCADE
);

CREATE TABLE Publishers
(
	pubID		INT 		PRIMARY KEY AUTO_INCREMENT,
    pub_name	VARCHAR(45)	NOT NULL
);

CREATE TABLE Book_Publisher
(
	bookID	INT NOT NULL,
	pubID	INT NOT NULL,
    CONSTRAINT Book_Publisher_fk_Books
		FOREIGN KEY(bookID)
			REFERENCES Books(bookID)
				ON DELETE CASCADE,
	CONSTRAINT Book_Publisher_fk_Publishers
		FOREIGN KEY(pubID)
			REFERENCES Publishers(pubID)
				ON DELETE CASCADE
);

CREATE TABLE Users
(
	username 	VARCHAR(45)	NOT NULL	UNIQUE,
    password1	VARCHAR(45)	NOT NULL
);

-- Insert rows into the tables
INSERT INTO Books VALUES
(1, 'Introduction to JAVA Programming, Comprehensive Version, tenth Edition', '0-13-376131-2', TRUE),
(2, 'Introduction to JAVA Programming, Comprehensive Version, Eleventh Edition', '0-14-376132-3',  TRUE),
(3, 'Introduction to JAVA Programming, Comprehensive Version, Eleventh Edition', '0-14-376132-3',  TRUE),
(4, 'Introduction to JAVA Programming, Comprehensive Version, Eleventh Edition', '0-14-376132-3',  TRUE),
(5, 'Introduction to JAVA Programming, Comprehensive Version, Eleventh Edition', '0-14-376132-3',  TRUE),
(6, 'Introduction to JAVA Programming, Comprehensive Version, Eleventh Edition', '0-14-376132-3',  TRUE);

INSERT INTO Students VALUES
(1, 'Cesar', 'Rojas Herrera', 'thedrakmer@gmail.com');

-- INSERT INTO Books_Borrowed VALUES
-- (1,1, NOW(), 3.5);

INSERT INTO Users VALUES
('Admin', PASSWORD('1234')),
('Member', PASSWORD('1234'));

DROP VIEW IF EXISTS BOOK;

CREATE VIEW BOOK AS
SELECT 
	b.book_title AS 'Title',
    b.bookID AS 'BookID',
    a.author_name AS 'Author',
    g.genre AS 'Genre',
    p.pub_name AS 'Publisher',
    b.isAvail AS 'availavility'
FROM 
	books AS b
INNER JOIN
	book_authors AS ba ON b.bookID = ba.bookID
INNER JOIN 
	Authors AS a ON ba.authorID = a.authorID
INNER JOIN 
	book_genres AS bg ON b.bookID = bg.bookID
INNER JOIN 
	Genres AS g ON bg.genreID = g.genreID
INNER JOIN 
	book_publisher AS bp ON b.bookID = bp.bookID
INNER JOIN 
	Publishers AS p ON bp.pubID = p.pubID;
    
-- SELECT * FROM BOOK