package catalogue;

import java.io.Serializable;

public class Product implements Serializable, Comparable<Product> {
  private String theProductNum;
  private String theDescription;
  private double thePrice;
  private int theQuantity;

  public Product(String aProductNum, String aDescription, double aPrice, int aQuantity) {
    theProductNum = aProductNum;
    theDescription = aDescription;
    thePrice = aPrice;
    theQuantity = aQuantity;
  }

  public String getProductNum() {
    return theProductNum;
  }

  public String getDescription() {
    return theDescription;
  }

  public double getPrice() {
    return thePrice;
  }

  public int getQuantity() {
    return theQuantity;
  }

  public void setQuantity(int quantity) {
    theQuantity = quantity;
  }

  @Override
  public int compareTo(Product otherProduct) {
    return this.getProductNum().compareTo(otherProduct.getProductNum());
  }
}