package shopping;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class ShoppingListTest {
  @Test public void testGetItems() {
    ShoppingList shoppingList = new ShoppingList();
    ArrayList<String> expectedItems = new ArrayList<String>();
    assertEquals(shoppingList.getItems(), expectedItems);
  }
}

// TEST FOR WHEN CHANGING FROM STRING ARRAYLISTS TO SHOPPINGITEM LISTS
// @Test public void testGetItems() {
//   ShoppingList shoppingList = new ShoppingList();
//   ArrayList<ShoppingItem> expectedItems = new ArrayList<ShoppingItem>();
//   assertEquals(shoppingList.getItems(), expectedItems);
// }