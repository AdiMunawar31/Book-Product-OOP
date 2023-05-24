package configs;

import controllers.BookController;
import controllers.PriceController;
import models.Author;
import models.Book;
import models.Comic;
import models.Mangaka;
import models.Novel;
import models.Novelis;
import models.Publisher;

public class ApplicationConfiguration {

  private final BookController bookController;
  private final PriceController priceController;
  private final MenuConfiguration menuConfiguration;

  public ApplicationConfiguration(BookController bookController, PriceController priceController,
      MenuConfiguration menuConfiguration) {
    this.bookController = bookController;
    this.priceController = priceController;
    this.menuConfiguration = menuConfiguration;
  }

  /**
   * Fuction ini dibuat pada configs agar main func tidak terlalu banyak code
   * Mungkin ini bukan cara yang baik namun saya belum mengetahui best practicenya
   * 
   */
  public void runApplication() {

    // Object Author
    Author haidarMusyafa = new Author("Haidar", "Musyafa", "Indonesia", 30);
    Author bertBates = new Author("Bert", "Bates", "United State", 50);
    Author barryBurd = new Author("Barry", "Burd", "United State", 52);
    Author markManson = new Author("Mark", "Manson", "United State", 38);
    Author andiSusanto = new Author("Andi", "Susanto", "Indonesia", 32);
    Author adiSutanto = new Author("Adi", "Sutanto", "Indonesia", 27);

    // Object Novelis
    Novelis jkRowling = new Novelis("J.K.", "Rowling", "England", 57, true, "Best Seller");
    Novelis tereLiye = new Novelis("Tere", "Liye", "Indonesia", 35, true, "Best Seller");
    Novelis deeLestari = new Novelis("Dee", "Lestari", "Indonesia", 30, true, "Good");
    Novelis faisalSyahreza = new Novelis("Faisal", "Syahreza", "Indonesia", 40, true, "New Commer");
    Novelis juliaGolding = new Novelis("Julia", "Golding", "England", 41, false, "Best Seller");

    // Object Mangaka
    Mangaka masashiKishimoto = new Mangaka("Masashi", "Kishimoto", "Japan", 48, "Best Seller");
    Mangaka yoshihiroTogashi = new Mangaka("Yoshihiro", "Togashi", "Japan", 56, "Good");
    Mangaka eiichiroOda = new Mangaka("Eiichiro", "Oda", "Japan", 57, "Best Seller");
    Mangaka rizkiAnwar = new Mangaka("Rizki", "Anwar", "Indonesia", 25, "New Commer");
    Mangaka yusufFadli = new Mangaka("Yusuf", "Fadli", "Indonesia", 32, "New Commer");

    Publisher bloomsbury = new Publisher("Bloomsbury", "United Kingdom", 30.0);
    Publisher gramedia = new Publisher("Gramedia", "Indonesia", 50.0);
    Publisher mizan = new Publisher("Mizan", "Indonesia", 25.0);
    Publisher shueisha = new Publisher("Shueisha", "Japan", 25.0);
    Publisher elexMediaKomputindo = new Publisher("Elex Media Komputindo", "Indonesia", 12.0);
    Publisher gramediaPustakaUtama = new Publisher("Gramedia Pustaka Utama", "Indonesia", 15.0);
    Publisher lionHudson = new Publisher("Lion Hudson", "England", 15.0);
    Publisher oReillyMedia = new Publisher("O Reilly Media", "United States", 30.0);
    Publisher harperOne = new Publisher("Harper One", "United States", 25.0);

    // Object Book
    Book book1 = new Book("Book - 001", "Memahami Hamka", haidarMusyafa, mizan);
    Book book2 = new Book("Book - 002", "Head First Java: Your Brain on Java - A Learner's Guide", bertBates,
        oReillyMedia);
    Book book3 = new Book("Book - 003", "Java For Dummies", barryBurd, oReillyMedia);
    Book book4 = new Book("Book - 004", "Flutter For Dummies", barryBurd, oReillyMedia);
    Book book5 = new Book("Book - 005", "The Subtle Art of Not Giving", markManson, harperOne);
    Book book6 = new Book("Book - 006", "Will", markManson, harperOne);
    Book book7 = new Book("Book - 007", "Sejarah Indonesia", andiSusanto, gramediaPustakaUtama);
    Book book8 = new Book("Book - 008", "Teknologi Baru", adiSutanto, elexMediaKomputindo);

    // Object Novel
    Novel novel1 = new Novel("Novel - 001", "Harry Potter and the Philosopher's Stone", jkRowling, bloomsbury,
        "Fantasy");
    Novel novel2 = new Novel("Novel - 002", "Harry Potter and the Chamber of Secrets", jkRowling, bloomsbury,
        "Fantasy");
    Novel novel3 = new Novel("Novel - 003", "Harry Potter and the Prisoner of Azkaban", jkRowling, bloomsbury,
        "Fantasy");
    Novel novel4 = new Novel("Novel - 004", "Ayah Aku Berbeda", tereLiye, gramedia, "Drama");
    Novel novel5 = new Novel("Novel - 005", "Madre", deeLestari, gramedia, "Drama");
    Novel novel6 = new Novel("Novel - 006", "Lagu untuk Renjana", faisalSyahreza, mizan, "Drama");
    Novel novel7 = new Novel("Novel - 007", "Semoga Lekas Lega", faisalSyahreza, mizan, "Drama");
    Novel novel8 = new Novel("Novel - 008", "The Abbey Mystery", juliaGolding, lionHudson, "Fiction");

    // Object Comic
    Comic comic1 = new Comic("Comic - 001", "Uzumaki Naruto", masashiKishimoto, shueisha, true);
    Comic comic2 = new Comic("Comic - 002", "The Worst Client", masashiKishimoto, shueisha, true);
    Comic comic3 = new Comic("Comic - 003", "For the Sake of Dreams...!!", masashiKishimoto, shueisha, true);
    Comic comic4 = new Comic("Comic - 004", "Hunter X Hunter : The Day of Departure", yoshihiroTogashi, shueisha, true);
    Comic comic5 = new Comic("Comic - 005", "Hunter X Hunter : A Struggle in the Mist", yoshihiroTogashi, shueisha,
        true);
    Comic comic6 = new Comic("Comic - 006", "One Piece", eiichiroOda, gramedia, true);
    Comic comic7 = new Comic("Comic - 007", "Petualangan di Indonesia", rizkiAnwar, gramediaPustakaUtama, false);
    Comic comic8 = new Comic("Comic - 008", "Petualangan di Jakarta", yusufFadli, elexMediaKomputindo, false);

    // Menghitung harga buku dengan strategy default
    priceController.calculateBookPrice(book1);
    priceController.calculateBookPrice(book2);
    priceController.calculateBookPrice(book3);
    priceController.calculateBookPrice(book4);
    priceController.calculateBookPrice(book5);
    priceController.calculateBookPrice(book6);
    priceController.calculateBookPrice(book7);
    priceController.calculateBookPrice(book8);

    // Menghitung harga novel dengan strategy NovelPriceStrategy
    priceController.calculateNovelPrice(novel1);
    priceController.calculateNovelPrice(novel2);
    priceController.calculateNovelPrice(novel3);
    priceController.calculateNovelPrice(novel4);
    priceController.calculateNovelPrice(novel5);
    priceController.calculateNovelPrice(novel6);
    priceController.calculateNovelPrice(novel7);
    priceController.calculateNovelPrice(novel8);

    // Menghitung harga komik dengan strategy ComicPriceStrategy
    priceController.calculateComicPrice(comic1);
    priceController.calculateComicPrice(comic2);
    priceController.calculateComicPrice(comic3);
    priceController.calculateComicPrice(comic4);
    priceController.calculateComicPrice(comic5);
    priceController.calculateComicPrice(comic6);
    priceController.calculateComicPrice(comic7);
    priceController.calculateComicPrice(comic8);

    // Add Book to Repository
    bookController.addBook(book1);
    bookController.addBook(book2);
    bookController.addBook(book3);
    bookController.addBook(book4);
    bookController.addBook(book5);
    bookController.addBook(book6);
    bookController.addBook(book7);
    bookController.addBook(book8);

    bookController.addBook(novel1);
    bookController.addBook(novel2);
    bookController.addBook(novel3);
    bookController.addBook(novel4);
    bookController.addBook(novel5);
    bookController.addBook(novel6);
    bookController.addBook(novel7);
    bookController.addBook(novel8);

    bookController.addBook(comic1);
    bookController.addBook(comic2);
    bookController.addBook(comic3);
    bookController.addBook(comic4);
    bookController.addBook(comic5);
    bookController.addBook(comic6);
    bookController.addBook(comic7);
    bookController.addBook(comic8);

    // Jalankan menu
    menuConfiguration.runMenu();
  }

}
