package controllers;

import models.Book;
import models.Comic;
import models.Novel;

import services.PriceService;

import strategy.BookPriceStrategy;
import strategy.ComicPriceStrategy;
import strategy.NovelPriceStrategy;

public class PriceController {
  private final PriceService priceService;

  public PriceController() {
    priceService = new PriceService(new BookPriceStrategy());
  }

  public void calculateBookPrice(Book book) {
    priceService.calculatePrice(book);
  }

  public void calculateNovelPrice(Novel novel) {
    priceService.setStrategy(new NovelPriceStrategy());
    priceService.calculatePrice(novel);
  }

  public void calculateComicPrice(Comic comic) {
    priceService.setStrategy(new ComicPriceStrategy());
    priceService.calculatePrice(comic);
  }
}