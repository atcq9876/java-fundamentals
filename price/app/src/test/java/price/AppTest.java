/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package price;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    // @Test public void appHasAGreeting() {
    //     App classUnderTest = new App();
    //     assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    // }

    @Test public void appDisplaysItemNameAndPrice() {
        App classUnderTest = new App();
        assertEquals("returns a string with item name and price", String.valueOf("The price for item: shoes is £49.99"), classUnderTest.getPriceLabel("shoes", 49.99));
    }
}
