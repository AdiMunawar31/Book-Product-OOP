package models;

public class Publisher {

  private String publisherName;
  private String country;
  private double productionCost;

  public Publisher() {
  }

  public Publisher(String publisherName, String country, double productionCost) {
    this.publisherName = publisherName;
    this.country = country;
    this.productionCost = productionCost;
  }

  @Override
  public String toString() {
    return "Publisher: " + publisherName + ", Country: " + country + ", Production Cost: " + productionCost;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public double getProductionCost() {
    return productionCost;
  }

  public void setProductionCost(double productionCost) {
    this.productionCost = productionCost;
  }

}