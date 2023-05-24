package controllers;

import java.util.List;

import models.Book;
import services.BookService;

public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  public void addBook(Book book) {
    bookService.addBook(book);
  }

  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  public void printBooks(List<Book> books) {
    bookService.printBooks(books);
  }

}
