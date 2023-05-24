package models;

public class Comic extends Book {

  private boolean volumeSeries;

  public Comic() {
  }

  public Comic(boolean volumeSeries) {
    this.volumeSeries = volumeSeries;
  }

  @Override
  public String toString() {
    return super.toString() + ", Volume Series: " + volumeSeries;
  }

  public Comic(String bookCode, String title, Author author, Publisher publisher, boolean volumeSeries) {
    super(bookCode, title, author, publisher);
    this.volumeSeries = volumeSeries;
  }

  public boolean isVolumeSeries() {
    return volumeSeries;
  }

  public void setVolumeSeries(boolean volumeSeries) {
    this.volumeSeries = volumeSeries;
  }

}
