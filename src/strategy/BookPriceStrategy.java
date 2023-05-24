package strategy;

import interfaces.PriceStrategy;
import models.Book;

public class BookPriceStrategy implements PriceStrategy {

  @Override
  public void calculatePrice(Book book) {

    double price;
    double productionCost = book.getPublisher().getProductionCost();

    price = productionCost * 1.20;

    book.setPrice(price);

  }
}