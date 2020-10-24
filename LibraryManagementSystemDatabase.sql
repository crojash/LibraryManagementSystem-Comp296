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
	bookID		INT				PRIMARY KEY	AUTO_INCREMENT,
    book_title	VARCHAR(100)		NOT NULL,
    ISBN		VARCHAR(45)		NOT NULL,
    rating	 	DECIMAL(9, 2)	NOT NULL
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
	-- booksB_ID	INT				PRIMARY KEY,
    bookID		INT				UNIQUE,
    studentID	INT 			UNIQUE,
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
);

CREATE TABLE Authors
(
	authorID			INT 		PRIMARY KEY	AUTO_INCREMENT,
    author_first_name	VARCHAR(45)	NOT NULL,
    author_last_name	VARCHAR(45)	NOT NULL
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
			REFERENCES Books(bookId),
	CONSTRAINT Book_genre_fk_Genres
		FOREIGN KEY(genreID)
			REFERENCES Genres(genreID)
);

CREATE TABLE Book_Authors
(
	bookID		INT NOT NULL,
    authorID	INT NOT NULL,
    CONSTRAINT Book_Authors_fk_Books
		FOREIGN KEY(bookID)
			REFERENCES Books(bookID),
	CONSTRAINT Book_Authors_fk_Authors
		FOREIGN KEY(authorID)
			REFERENCES Authors(authorID)
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
			REFERENCES Books(bookID),
	CONSTRAINT Book_Publisher_fk_Publishers
		FOREIGN KEY(pubID)
			REFERENCES Publishers(pubID)
);

CREATE TABLE Users
(
	username 	VARCHAR(45)	NOT NULL	UNIQUE,
    password1	VARCHAR(45)	NOT NULL
);

-- Insert rows into the tables
INSERT INTO Books VALUES
(1, 'Introduction to JAVA Programming, Comprehensive Version, tenth Edition', '0-13-376131-2', 10),
(2, 'Introduction to JAVA Programming, Comprehensive Version, Eleventh Edition', '0-14-376132-3', 8.5);

INSERT INTO Students VALUES
(1, 'Cesar', 'Rojas Herrera', 'thedrakmer@gmail.com');

INSERT INTO Books_Borrowed VALUES
(1,1, NOW(), '2020-25-10', 3.5);

INSERT INTO Users VALUES
('Admin', PASSWORD('1234'));


