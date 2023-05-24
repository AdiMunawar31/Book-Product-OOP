import configs.ApplicationConfiguration;
import configs.MenuConfiguration;
import controllers.BookController;
import controllers.PriceController;
import controllers.SearchDataController;
import repositories.BookRepository;
import services.BookService;
import services.SearchDataService;
import validations.BookValidation;

public class App {

  public void run() throws Exception {

    // Create instance Book Repository
    BookRepository bookRepository = new BookRepository();

    // Create instance Book Validation
    BookValidation bookValidation = new BookValidation();

    // Create instance Book Service
    BookService bookService = new BookService(bookRepository, bookValidation);

    // Create instance Search Data Service
    SearchDataService searchDataService = new SearchDataService(bookRepository);

    // Create instance Book Controller
    BookController bookController = new BookController(bookService);

    // Create instance Book Controller
    PriceController priceController = new PriceController();

    // Create instance Book Controller
    SearchDataController searchDataController = new SearchDataController(searchDataService);

    // Create instance Menu Configuration
    MenuConfiguration menuConfiguration = new MenuConfiguration(searchDataController);

    // Create instance Application Configuration
    ApplicationConfiguration configuration = new ApplicationConfiguration(bookController,
        priceController, menuConfiguration);

    // Menjalankan Applikasi
    configuration.runApplication();

  }
}
