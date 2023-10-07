package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.java.tech.fall.Menu;



public class MenuTest {
    // Test menu functionality
    @Test
    public void testMenuIsRunning(){
        // Using constructor
        Menu mainMenu = new Menu();
        mainMenu.openMainMenu();
        assertEquals(true, mainMenu.isOpen());
    }
}
