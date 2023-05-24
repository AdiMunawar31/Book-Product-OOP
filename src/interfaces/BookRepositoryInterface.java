package interfaces;

import java.util.List;

import models.Book;

public interface BookRepositoryInterface {

  List<Book> getAllBooks();

  void save(Book book);

}
