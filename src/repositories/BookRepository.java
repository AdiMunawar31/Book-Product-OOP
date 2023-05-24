package repositories;

import java.util.ArrayList;
import java.util.List;

import interfaces.BookRepositoryInterface;
import models.Book;

public class BookRepository implements BookRepositoryInterface {
  private List<Book> books;

  public BookRepository() {
    this.books = new ArrayList<>();
  }

  @Override
  public List<Book> getAllBooks() {
    return books;
  }

  @Override
  public void save(Book book) {
    books.add(book);
  }

}
