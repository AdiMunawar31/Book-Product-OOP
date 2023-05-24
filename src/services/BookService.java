package services;

import java.util.List;

import exceptions.BookValidationException;
import interfaces.BookServiceInterface;
import models.Book;
import repositories.BookRepository;
import validations.BookValidation;

public class BookService implements BookServiceInterface {

  private final BookRepository bookRepository;
  private final BookValidation bookValidation;

  public BookService(BookRepository bookRepository, BookValidation bookValidation) {
    this.bookRepository = bookRepository;
    this.bookValidation = bookValidation;
  }

  @Override
  public void addBook(Book book) {
    try {
      bookValidation.validateBook(book);
      bookRepository.save(book);
    } catch (BookValidationException e) {
      System.out.println("Failed to add book: " + e.getMessage());
    }
  }

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.getAllBooks();
  }

  @Override
  public void printBooks(List<Book> books) {
    books.forEach(book -> System.out.println(book));
  }
}
