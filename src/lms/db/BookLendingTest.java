package lms.db;

import java.time.LocalDate;

public class BookLendingTest {

	public static void main(String[] args) {
		//LocalDate myObj = LocalDate.now();
		//System.out.println(myObj);
		//BookLending test1 = new BookLending(1, 1);
		//test1.issueBook();
		BookLending b2 = new BookLending();
		b2.returnBook(1);
	}

}
