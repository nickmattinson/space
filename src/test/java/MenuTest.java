import com.mnz.game.Menu;

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
