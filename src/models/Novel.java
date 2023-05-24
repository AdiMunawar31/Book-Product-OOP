package models;

public class Novel extends Book {

  private String genre;

  public Novel() {
  }

  public Novel(String bookCode, String title, Author author, Publisher publisher, String genre) {
    super(bookCode, title, author, publisher);
    this.genre = genre;
  }

  @Override
  public String toString() {
    return super.toString() + ", Genre: " + genre;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

}
