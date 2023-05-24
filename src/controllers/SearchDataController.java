package controllers;

import java.util.List;

import models.Author;
import models.Book;
import models.Comic;
import models.Publisher;

import services.SearchDataService;

public class SearchDataController {

  private final SearchDataService searchDataService;

  public SearchDataController(SearchDataService searchDataService) {
    this.searchDataService = searchDataService;
  }

  public Book findCheapestBook() {
    return searchDataService.findCheapestBook();
  }

  public Book findMostExpensiveBook() {
    return searchDataService.findMostExpensiveBook();
  }

  public List<Book> findBooksByPriceRange(double maxPrice) {
    return searchDataService.findBooksByPriceRange(maxPrice);
  }

  public List<Author> findAllMangakas() {
    return searchDataService.findAllMangakas();
  }

  public List<Author> findAllAuthors() {
    return searchDataService.findAllAuthors();
  }

  public List<Author> findAllNovelis() {
    return searchDataService.findAllNovelis();
  }

  public List<Author> findAuthorsByAgeRange(int minAge, int maxAge) {
    return searchDataService.findAuthorsByAgeRange(minAge, maxAge);
  }

  public List<Author> findAuthorsByCountry(String country) {
    return searchDataService.findAuthorsByCountry(country);
  }

  public Publisher findPublisherWithHighestProductionCost() {
    return searchDataService.findPublisherWithHighestProductionCost();
  }

  public Publisher findPublisherWithLowestProductionCost() {
    return searchDataService.findPublisherWithLowestProductionCost();
  }

  public List<Comic> findComicsByMangakaRating(String rating) {
    return searchDataService.findComicsByMangakaRating(rating);
  }

  public Comic findMostExpensiveComic() {
    return searchDataService.findMostExpensiveComic();
  }

  public List<Book> findBooksByPublisherCountry(String country) {
    return searchDataService.findBooksByPublisherCountry(country);
  }

  public List<Book> findBooksByAuthorCountry(String country) {
    return searchDataService.findBooksByAuthorCountry(country);
  }
}
