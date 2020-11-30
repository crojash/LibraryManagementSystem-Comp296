package lms.ui.librarian;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BookView {

	private final IntegerProperty bookId = new SimpleIntegerProperty();
	private final StringProperty title = new SimpleStringProperty();
	private final StringProperty author = new SimpleStringProperty();
	private final StringProperty publisher = new SimpleStringProperty();
	private final BooleanProperty availability = new SimpleBooleanProperty();
	private final StringProperty genre = new SimpleStringProperty();
	
	public int getbookId() {
		return bookId.get();
	}
	
	public void setbookId(int value) {
		bookId.set(value);
	}
	
	public IntegerProperty bookIdProperty() {
		return bookId;
	}
	
	public String getTitle() {
		return title.get();
	}
	
	public void setTitle(String value) {
		title.set(value);
	}
	
	public StringProperty titleProperty() {
		return title;
	}
	
	public String getAuthor() {
		return author.get();
	}
	
	public void setAuthor(String value) {
		author.set(value);
	}
	public StringProperty authorProperty() {
		return author;
	}

	public String getPublisher() {
		return publisher.get();
	}
	
	public void setPublisher(String value) {
		publisher.set(value);
	}

	public StringProperty publisherProperty() {
		return publisher;
	}
	public boolean getAvailability() {
		return availability.get();
	}
	
	public void setAvailability(Boolean value) {
		availability.set(value);
	}
	
	public BooleanProperty availabilityProperty() {
		return availability;
	}
	
	public String getGenre() {
		return genre.get();
	}
	
	public void setGenre(String value) {
		genre.set(value);
	}
	
	public StringProperty genreProperty() {
		return genre;
	}
}
