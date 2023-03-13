package shopping;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ShoppingListTest {
  @Test public void testGetItems() {
    ShoppingList shoppingList = new ShoppingList();
    ArrayList<ShoppingItem> expectedItems = new ArrayList<ShoppingItem>();
    assertEquals(shoppingList.getItems(), expectedItems);
  }

  @Test public void testAddItem() {
    ShoppingList shoppingList = new ShoppingList();
    ShoppingItem item = new ShoppingItem("Strawberries", 2.99);
    shoppingList.addItem(item);
    ArrayList<ShoppingItem> expectedItems = new ArrayList<ShoppingItem>();
    expectedItems.add(item);
    assertEquals(shoppingList.getItems(), expectedItems);
  }
}
