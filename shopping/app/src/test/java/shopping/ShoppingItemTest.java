package shopping;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingItemTest {
  @Test public void testCreatingAnInstance() {
    ShoppingItem item = new ShoppingItem("Bread", 1.99);
    Double expectedPrice = 1.99;
    assertEquals(item.name, "Bread");
    assertEquals(item.price, expectedPrice);
  }
}
