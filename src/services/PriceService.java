package services;

import interfaces.PriceStrategy;
import models.Book;

public class PriceService {

  private PriceStrategy strategy;

  public PriceService(PriceStrategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(PriceStrategy strategy) {
    this.strategy = strategy;
  }

  public void calculatePrice(Book book) {
    strategy.calculatePrice(book);
  }
}
