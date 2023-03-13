package shopping;

import java.util.ArrayList;

public class ShoppingList {
  ArrayList<ShoppingItem> list = new ArrayList<ShoppingItem>();

  public ArrayList<ShoppingItem> getItems() {
    return list;
  }

  public void addItem(ShoppingItem item) {
    list.add(item);
  }
}
