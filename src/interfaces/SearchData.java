package interfaces;

import java.util.List;

import models.Author;
import models.Book;
import models.Comic;
import models.Publisher;

public interface SearchData {

  Book findCheapestBook();

  Book findMostExpensiveBook();

  List<Book> findBooksByPriceRange(double maxPrice);

  List<Author> findAllMangakas();

  List<Author> findAllAuthors();

  List<Author> findAllNovelis();

  List<Author> findAuthorsByAgeRange(int minAge, int maxAge);

  List<Author> findAuthorsByCountry(String country);

  Publisher findPublisherWithHighestProductionCost();

  Publisher findPublisherWithLowestProductionCost();

  List<Comic> findComicsByMangakaRating(String rating);

  Comic findMostExpensiveComic();

  List<Book> findBooksByPublisherCountry(String country);

  List<Book> findBooksByAuthorCountry(String country);

}
