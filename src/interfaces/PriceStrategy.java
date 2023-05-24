package interfaces;

import models.Book;

public interface PriceStrategy {

  void calculatePrice(Book book);

}
