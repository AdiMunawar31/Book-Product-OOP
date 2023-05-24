package strategy;

import interfaces.PriceStrategy;
import models.Book;
import models.Novel;
import models.Novelis;

public class NovelPriceStrategy implements PriceStrategy {

  @Override
  public void calculatePrice(Book book) {
    double price = 0;

    String[][] ratingRates = { { "New Commer", "1.25" }, { "Good", "1.35" }, { "Best Seller", "1.50" } };
    ;

    Novel novel = (Novel) book;
    Novelis novelis = (Novelis) novel.getAuthor();

    String rating = novelis.getRating();
    double productionCost = novel.getPublisher().getProductionCost();

    for (int i = 0; i < ratingRates.length; i++) {
      if (ratingRates[i][0].equalsIgnoreCase(rating)) {
        price = (Double.valueOf(ratingRates[i][1])) * productionCost;
      }
    }

    novel.setPrice(price);

  }
}
