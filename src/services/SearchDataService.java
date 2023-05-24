package services;

import java.util.List;
import java.util.stream.Collectors;

import interfaces.SearchData;
import models.Author;
import models.Book;
import models.Comic;
import models.Mangaka;
import models.Novel;
import models.Publisher;
import repositories.BookRepository;

public class SearchDataService implements SearchData {

  private final BookRepository bookRepository;

  public SearchDataService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  /**
   * Cari data book yang memiliki price paling Murah.
   * 
   * @return Book
   */
  @Override
  public Book findCheapestBook() {
    Book cheapestBook;
    List<Book> books = bookRepository.getAllBooks();

    cheapestBook = books.stream()
        .min((book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice())).orElse(null);

    return cheapestBook;
  }

  /**
   * Cari data book yang memiliki price paling Mahal.
   * 
   * @return Book
   */
  @Override
  public Book findMostExpensiveBook() {
    Book mostExpensiveBook;
    List<Book> books = bookRepository.getAllBooks();

    mostExpensiveBook = books.stream()
        .max((book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice())).orElse(null);

    return mostExpensiveBook;
  }

  /**
   * Cari data book berdasarkan range Price
   * 
   * @param double maxPrice
   * @return List<Book>
   */
  @Override
  public List<Book> findBooksByPriceRange(double maxPrice) {
    List<Book> booksByPriceRange;
    List<Book> books = bookRepository.getAllBooks();

    booksByPriceRange = books.stream()
        .filter(book -> book.getPrice() < maxPrice)
        .collect(Collectors.toList()); // mengumpulkan elemen-elemen dalam sebuah stream ke dalam bentuk List

    return booksByPriceRange;
  }

  /**
   * Cari Data semua Mangaka.
   * 
   * @return List<Author>
   */
  @Override
  public List<Author> findAllMangakas() {
    List<Author> mangakas;
    List<Book> books = bookRepository.getAllBooks();

    mangakas = books.stream()
        .filter(book -> book instanceof Comic)
        .map(book -> ((Comic) book).getAuthor())
        .distinct() // untuk menghapus elemen-elemen duplikat
        .collect(Collectors.toList());

    return mangakas;
  }

  /**
   * Cari Data semua Author.
   * 
   * @return List<Author>
   */
  @Override
  public List<Author> findAllAuthors() {
    List<Author> authors;
    List<Book> books = bookRepository.getAllBooks();

    authors = books.stream()
        .map(Book::getAuthor)
        .distinct()
        .collect(Collectors.toList());

    return authors;
  }

  /**
   * Cari Data semua Novelist.
   * 
   * @return List<Author>
   */
  @Override
  public List<Author> findAllNovelis() {
    List<Author> novelis;
    List<Book> books = bookRepository.getAllBooks();

    novelis = books.stream()
        .filter(book -> book instanceof Novel)
        .map(book -> ((Novel) book).getAuthor())
        .distinct()
        .collect(Collectors.toList());

    return novelis;
  }

  /**
   * Cari author berdasarkan Range umur.
   * 
   * @param int minAge
   * @param int maxAge
   * @return List<Author>
   */
  @Override
  public List<Author> findAuthorsByAgeRange(int minAge, int maxAge) {
    List<Author> authorsByAgeRange;
    List<Book> books = bookRepository.getAllBooks();

    authorsByAgeRange = books.stream()
        .map(Book::getAuthor)
        .filter(author -> author.getAge() >= minAge && author.getAge() <= maxAge)
        .distinct()
        .collect(Collectors.toList());

    return authorsByAgeRange;
  }

  /**
   * Cari author berdasarkan Country.
   * 
   * @param String country
   * @return List<Author>
   */
  @Override
  public List<Author> findAuthorsByCountry(String country) {
    List<Author> authorsByCountry;
    List<Book> books = bookRepository.getAllBooks();

    authorsByCountry = books.stream()
        .map(Book::getAuthor)
        .filter(author -> author.getCountry().equalsIgnoreCase(country))
        .distinct()
        .collect(Collectors.toList());

    return authorsByCountry;
  }

  /**
   * Cari Publisher dengan productionCost paling Mahal.
   * 
   * @return Publisher
   */
  @Override
  public Publisher findPublisherWithHighestProductionCost() {
    Publisher publisherWithHighestProductionCost;
    List<Book> books = bookRepository.getAllBooks();

    publisherWithHighestProductionCost = books.stream()
        .map(Book::getPublisher)
        .max((publisher1, publisher2) -> Double.compare(publisher1.getProductionCost(), publisher2.getProductionCost()))
        .orElse(null);

    return publisherWithHighestProductionCost;

  }

  /**
   * Cari Publisher dengan productionCost paling Murah.
   * 
   * @return Publisher
   */
  @Override
  public Publisher findPublisherWithLowestProductionCost() {
    Publisher publisherWithLowestProductionCost;
    List<Book> books = bookRepository.getAllBooks();

    publisherWithLowestProductionCost = books.stream()
        .map(Book::getPublisher)
        .min((publisher1, publisher2) -> Double.compare(publisher1.getProductionCost(), publisher2.getProductionCost()))
        .orElse(null);

    return publisherWithLowestProductionCost;
  }

  /**
   * Cari Comic Berdasarkan Rating mangaka.
   * 
   * @return List<Comic>
   */
  @Override
  public List<Comic> findComicsByMangakaRating(String rating) {
    List<Comic> comicsByMangakaRating;
    List<Book> books = bookRepository.getAllBooks();

    comicsByMangakaRating = books.stream()
        .filter(book -> book instanceof Comic)
        .map(book -> (Comic) book)
        .filter(comic -> {
          Mangaka mangaka = (Mangaka) comic.getAuthor();
          String mangakRating = mangaka.getRating();
          return mangakRating.equalsIgnoreCase(rating);
        })
        .collect(Collectors.toList());

    return comicsByMangakaRating;
  }

  /**
   * Cari data Comic yang memiliki price paling Mahal.
   * 
   * @return Comic
   */
  @Override
  public Comic findMostExpensiveComic() {
    Comic mostExpensiveComic;
    List<Book> books = bookRepository.getAllBooks();

    mostExpensiveComic = books.stream()
        .filter(book -> book instanceof Comic)
        .map(book -> (Comic) book)
        .max((book1, book2) -> Double.compare(book1.getPrice(), book2.getPrice()))
        .orElse(null);

    return mostExpensiveComic;
  }

  /**
   * Cari Book berdasarkan Country dari Publishernya.
   * 
   * @param String country
   * @return List<Book>
   */
  @Override
  public List<Book> findBooksByPublisherCountry(String country) {
    List<Book> booksByPublisherCountry;
    List<Book> books = bookRepository.getAllBooks();

    booksByPublisherCountry = books.stream()
        .filter(book -> book.getPublisher().getCountry().equalsIgnoreCase(country))
        .collect(Collectors.toList());

    return booksByPublisherCountry;
  }

  /**
   * Cari Book berdasarkan Country dari Authornya.
   * 
   * @param String country
   * @return List<Book>
   */
  @Override
  public List<Book> findBooksByAuthorCountry(String country) {
    List<Book> booksByAuthorCountry;
    List<Book> books = bookRepository.getAllBooks();

    booksByAuthorCountry = books.stream()
        .filter(book -> book.getAuthor().getCountry().equalsIgnoreCase(country))
        .collect(Collectors.toList());

    return booksByAuthorCountry;
  }
}
