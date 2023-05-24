package interfaces;

import java.util.List;

import models.Book;

public interface BookServiceInterface {

  List<Book> getAllBooks();

  void addBook(Book book);

  void printBooks(List<Book> books);

}
