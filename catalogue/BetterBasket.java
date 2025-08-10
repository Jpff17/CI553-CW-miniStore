package catalogue;

import java.util.Collections;

/**
 * Implements a basket that merges duplicate products and sorts them.
 */
public class BetterBasket extends Basket {
  private static final long serialVersionUID = 1L;

  @Override
  public boolean add(Product pr) {
    for (Product existingProduct : this) {
      if (existingProduct.getProductNum().equals(pr.getProductNum())) {
        // Item already exists, update quantity
        existingProduct.setQuantity(existingProduct.getQuantity() + pr.getQuantity());
        return true; // Indicate that the item was merged
      }
    }
    // Item doesn't exist, add it as a new item
    return super.add(pr);
  }

  public void sort() {
    Collections.sort(this);
  }
}