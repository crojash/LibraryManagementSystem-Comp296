package lms.db;
public class BookTest {

	public static void main(String[] args) {
		Book book = new Book("Battlefield","482-4182-1" , "Cesar Rojas", "fiction", "IDK");
		System.out.println(book.insertBook());
		System.out.println(book.insertGenre("non-fiction"));
		//Book book1 = new Book();
		//System.out.println(book1.deleteBook(3));
		//book1.insertAuthorMTM("Cesar Rojas");
	}

}
