package validations;

import exceptions.BookValidationException;
import models.Book;

public class BookValidation {

  public BookValidation() {

  }

  public void validateBook(Book book) {
    if (book.getBookCode() == null || book.getBookCode().isEmpty()) {
      throw new BookValidationException("Book book code cannot be empty");
    }
    if (book.getTitle() == null || book.getTitle().isEmpty()) {
      throw new BookValidationException("Book title cannot be empty");
    }
    if (book.getAuthor() == null) {
      throw new BookValidationException("Book author cannot be empty");
    }
    if (book.getPublisher() == null) {
      throw new BookValidationException("Book publisher cannot be empty");
    }
  }
}
