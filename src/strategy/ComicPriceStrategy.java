package strategy;

import interfaces.PriceStrategy;
import models.Book;
import models.Comic;
import models.Mangaka;

public class ComicPriceStrategy implements PriceStrategy {

  @Override
  public void calculatePrice(Book book) {
    double price = 0;

    String[][] nonVolumeSeriesRatingRates = { { "New Commer", "1.25" }, { "Good", "1.30" }, { "Best Seller", "1.40" } };
    String[][] volumeSeriesRatingRates = { { "New Commer", "1.35" }, { "Good", "1.45" }, { "Best Seller", "1.50" } };

    Comic comic = (Comic) book;
    Mangaka mangaka = (Mangaka) comic.getAuthor();

    String rating = mangaka.getRating();
    boolean volumeSeries = comic.isVolumeSeries();
    double productionCost = comic.getPublisher().getProductionCost();

    for (int i = 0; i < volumeSeriesRatingRates.length; i++) {
      if (volumeSeries) {
        if (volumeSeriesRatingRates[i][0].equalsIgnoreCase(rating)) {
          price = (Double.valueOf(volumeSeriesRatingRates[i][1])) * productionCost;
        }
      } else {
        if (nonVolumeSeriesRatingRates[i][0].equalsIgnoreCase(rating)) {
          price = (Double.valueOf(nonVolumeSeriesRatingRates[i][1])) * productionCost;
        }
      }
    }

    comic.setPrice(price);

  }
}
