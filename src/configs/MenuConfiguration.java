package configs;

import java.util.List;
import java.util.Scanner;

import controllers.SearchDataController;
import models.Author;
import models.Book;
import models.Comic;
import models.Publisher;

public class MenuConfiguration {

  private final SearchDataController searchDataController;

  public MenuConfiguration(SearchDataController searchDataController) {
    this.searchDataController = searchDataController;
  }

  public void runMenu() {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      displayMenu();
      choice = scanner.nextInt();
      processChoice(choice, scanner);
      System.out.println();
    } while (choice != 0);

    scanner.close();
  }

  private void displayMenu() {
    System.out.println("-------------- Aplikasi Repository Buku ------------------");
    System.out.println("1. Tampilkan data book yang memiliki price paling Murah");
    System.out.println("2. Tampilkan data book yang memiliki price paling Mahal");
    System.out.println("3. Tampilkan data book berdasarkan range Price");
    System.out.println("4. Tampilkan Data semua Mangaka");
    System.out.println("5. Tampilkan Data semua Author");
    System.out.println("6. Tampilkan Data semua Novelis");
    System.out.println("7. Tampilkan author berdasarkan Range umur");
    System.out.println("8. Tampilkan author berdasarkan Country");
    System.out.println("9. Tampilkan Publisher dengan productionCost paling Mahal");
    System.out.println("10. Tampilkan Publisher dengan productionCost paling Murah");
    System.out.println("11. Tampilkan Comic Berdasarkan Rating mangaka");
    System.out.println("12. Tampilkan data Comic yang memiliki price paling Mahal");
    System.out.println("13. Tampilkan Book berdasarkan Country dari Publishernya");
    System.out.println("14. Tampilkan Book berdasarkan Country dari Authornya");
    System.out.println("0. Keluar");
    System.out.println("-------------------------------------------------------------");
    System.out.print("Pilih menu: ");
  }

  private void processChoice(int choice, Scanner scanner) {
    if (choice == 1) {
      displayCheapestBook();
    } else if (choice == 2) {
      displayMostExpensiveBook();
    } else if (choice == 3) {
      displayBooksByPriceRange(scanner);
    } else if (choice == 4) {
      displayAllMangakas();
    } else if (choice == 5) {
      displayAllAuthors();
    } else if (choice == 6) {
      displayAllNovelis();
    } else if (choice == 7) {
      displayAuthorsByAgeRange(scanner);
    } else if (choice == 8) {
      displayAuthorsByCountry(scanner);
    } else if (choice == 9) {
      displayPublisherWithHighestProductionCost();
    } else if (choice == 10) {
      displayPublisherWithLowestProductionCost();
    } else if (choice == 11) {
      displayComicsByMangakaRating(scanner);
    } else if (choice == 12) {
      displayMostExpensiveComic();
    } else if (choice == 13) {
      displayBooksByPublisherCountry(scanner);
    } else if (choice == 14) {
      displayBooksByAuthorCountry(scanner);
    } else if (choice == 0) {
      exitProgram();
    } else {
      System.out.println("Pilihan tidak valid.");
    }
  }

  private void displayCheapestBook() {
    System.out.println("\n----------------->>> Data book dengan price paling Murah <<<-----------------");
    Book cheapestBook = searchDataController.findCheapestBook();
    System.out.println("\nCheapest Book : " + cheapestBook);
  }

  private void displayMostExpensiveBook() {
    System.out.println("\n----------------->>> Data book dengan price paling Mahal <<<-----------------");
    Book mostExpensiveBook = searchDataController.findMostExpensiveBook();
    System.out.println("\nMost Expensive Book : " + mostExpensiveBook);
  }

  private void displayBooksByPriceRange(Scanner scanner) {
    System.out.println("\n----------------->>> Data book berdasarkan range Price <<<-----------------");
    System.out.print("Masukkan harga maksimal: ");
    double maxPrice = scanner.nextDouble();

    List<Book> cheapBooks = searchDataController.findBooksByPriceRange(maxPrice);
    System.out.println("\nBooks with Price below (" + maxPrice + ") : " + cheapBooks);
  }

  private void displayAllMangakas() {
    System.out.println("\n----------------->>> Data semua Mangaka <<<-----------------");
    List<Author> allMangakas = searchDataController.findAllMangakas();
    System.out.println("\nAll Mangakas : " + allMangakas);
  }

  private void displayAllAuthors() {
    System.out.println("\n----------------->>> Data semua Author <<<-----------------");
    List<Author> allAuthors = searchDataController.findAllAuthors();
    System.out.println("\nAll Authors : " + allAuthors);
  }

  private void displayAllNovelis() {
    System.out.println("\n----------------->>> Data semua Novelis <<<-----------------");
    List<Author> allNovelis = searchDataController.findAllNovelis();
    System.out.println("\nAll Novelis : " + allNovelis);
  }

  private void displayAuthorsByAgeRange(Scanner scanner) {
    System.out.println("\n----------------->>> Author berdasarkan Range umur <<<-----------------");
    System.out.print("Masukkan usia minimum: ");
    int minAge = scanner.nextInt();
    System.out.print("Masukkan usia maksimum: ");
    int maxAge = scanner.nextInt();

    List<Author> authorsByAgeRange = searchDataController.findAuthorsByAgeRange(minAge, maxAge);
    System.out.println("\nAuthors within Age Range (" + minAge + " - " + maxAge + ") : " + authorsByAgeRange);
  }

  private void displayAuthorsByCountry(Scanner scanner) {
    System.out.println("\n----------------->>> Author berdasarkan Country <<<-----------------");
    System.out.print("Masukkan country: ");
    String country = scanner.next();

    List<Author> authorsByCountry = searchDataController.findAuthorsByCountry(country);
    System.out.println("\nAuthors from Country (" + country + ") : " + authorsByCountry);
  }

  private void displayPublisherWithHighestProductionCost() {
    System.out.println("\n----------------->>> Publisher dengan productionCost paling Mahal <<<-----------------");
    Publisher publisherWithHighestCost = searchDataController.findPublisherWithHighestProductionCost();
    System.out.println("\nPublisher with Highest Production Cost : \n" + publisherWithHighestCost);
  }

  private void displayPublisherWithLowestProductionCost() {
    System.out.println("\n----------------->>> Publisher dengan productionCost paling Murah <<<-----------------");
    Publisher publisherWithLowestCost = searchDataController.findPublisherWithLowestProductionCost();
    System.out.println("\nPublisher with Lowest Production Cost : \n" + publisherWithLowestCost);
  }

  private void displayComicsByMangakaRating(Scanner scanner) {
    System.out.println("\n----------------->>> Comic Berdasarkan Rating mangaka <<<-----------------");
    System.out.print("Masukkan rating: ");
    scanner.nextLine();
    String rating = scanner.nextLine();

    List<Comic> comicsByRating = searchDataController.findComicsByMangakaRating(rating);
    System.out.println("\nComics with Mangaka Rating (" + rating + ") : " + comicsByRating);
  }

  private void displayMostExpensiveComic() {
    System.out.println("\n----------------->>> Data Comic yang memiliki price paling Mahal <<<-----------------");
    Comic mostExpensiveComic = searchDataController.findMostExpensiveComic();
    System.out.println("\nMost Expensive Comic : " + mostExpensiveComic);
  }

  private void displayBooksByPublisherCountry(Scanner scanner) {
    System.out.println("\n----------------->>> Book berdasarkan Country dari Publishernya <<<-----------------");
    System.out.print("Masukkan country: ");
    String publisherCountry = scanner.next();

    List<Book> booksByPublisherCountry = searchDataController.findBooksByPublisherCountry(publisherCountry);
    System.out.println("\nBooks By Publisher Country (" + publisherCountry + ") : " + booksByPublisherCountry);
  }

  private void displayBooksByAuthorCountry(Scanner scanner) {
    System.out.println("\n----------------->>> Book berdasarkan Country dari Authornya <<<-----------------");
    System.out.print("Masukkan country: ");
    String authorCountry = scanner.next();

    List<Book> booksByAuthorCountry = searchDataController.findBooksByAuthorCountry(authorCountry);
    System.out.println("\nBooks By Author Country (" + authorCountry + ") : " + booksByAuthorCountry);
  }

  private void exitProgram() {
    System.out.println("Keluar dari program...");
  }

}
