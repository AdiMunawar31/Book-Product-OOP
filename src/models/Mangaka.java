package models;

public class Mangaka extends Author {

  private String rating;

  public Mangaka() {
  }

  public Mangaka(String firstName, String lastName, String country, int age, String rating) {
    super(firstName, lastName, country, age);
    this.rating = rating;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return super.toString() + ", Rating: " + rating;
  }

}
