import com.mnz.game.entity.player.Player;

public class PlayerTest {


    @Test
    public void testName_using_empty_constructor() {
        // using +Player()
        Player player = new Player();
        assertEquals("Unknown player", player.getName());
        player.setName("Sally");
        assertEquals("Sally", player.getName());
    }

    @Test
    public void testGetX() {
        Player player = new Player();
        player.setX(34);
        assertEquals(34d, player.getX(),.001);
    }

    @Test
    public void testGetY() {
        Player player = new Player();
        player.setY(34);
        assertEquals(34d, player.getY(),.001);
    }

    @Test
    public void testGetHealth() {
        Player player = new Player();
        assertEquals(1f, player.getHealth(),.001);
    }

    @Test
    public void testGetSpeed() {
        Player player = new Player();
        assertEquals(0d, player.getSpeed(),.001);
    }    
  
    @Test
    public void testGetHeading_default_value() {
        Player player = new Player();
        assertEquals(0d, player.getHeading(),.001);
    }

    @Test
    public void testSetHeading_370_should_be_010() {
        Player player = new Player();
        player.setHeading(370);
        assertEquals(010d, player.getHeading(),.001);
    }

    @Test
    public void testSetHeading_neg_90_should_be_270() {
        Player player = new Player();
        player.setHeading(-90d);
        assertEquals(270d, player.getHeading(),.001);
    }

    @Test
    public void testSetHeading_neg_890_should_be_190() {
        Player player = new Player();
        player.setHeading(-890d);
        assertEquals(190d, player.getHeading(),.001);
    }

    @Test
    public void testMove_0_0_1_0() {
        Player player = new Player();  
        player.setName("testMove_0_0_1_0");
        player.setX(0);
        player.setY(0);
        player.setSpeed(1d);
        player.setHeading(0d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals(Math.sqrt(0)/2, player.getX(),.001);
        assertEquals(Math.sqrt(4)/2, player.getY(),.001);
    }

    @Test
    public void testMove_0_0_1_30() {
        Player player = new Player();  
        player.setName("testMove_0_0_1_30");
        player.setX(0);
        player.setY(0);
        player.setSpeed(1d);
        player.setHeading(30d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals((int) Math.sqrt(1)/2, player.getX(),.001);
        assertEquals((int) Math.sqrt(3)/2, player.getY(),.001);
    }

    @Test
    public void testMove_0_0_1_45() {
        Player player = new Player();  
        player.setName("testMove_0_0_1_45");
        player.setX(0);
        player.setY(0);
        player.setSpeed(1d);
        player.setHeading(45d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals((int) Math.sqrt(2)/2, player.getX(),.001);
        assertEquals((int) Math.sqrt(2)/2, player.getY(),.001);
    }

    @Test
    public void testMove_0_0_1_60() {
        Player player = new Player();  
        player.setName("testMove_0_0_1_60"); 
        player.setX(0);
        player.setY(0);
        player.setSpeed(1d);
        player.setHeading(60d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals((int) Math.sqrt(3)/2, player.getX(),.001);
        assertEquals((int) Math.sqrt(1)/2, player.getY(),.001);
    }

    @Test
    public void testMove_0_0_1_90() {
        Player player = new Player();  
        player.setName("testMove_0_0_1_90"); 
        player.setX(0);
        player.setY(0);
        player.setSpeed(1d);
        player.setHeading(90d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals((int) Math.sqrt(4)/2, player.getX(),.001);
        assertEquals((int) Math.sqrt(0)/2, player.getY(),.001);
    }

    @Test
    public void testMove_0_0_1_120() {
        Player player = new Player();  
        player.setName("testMove_0_0_1_120");   
        player.setX(0);
        player.setY(0);
        player.setSpeed(1d);
        player.setHeading(120d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals((int) Math.sqrt(3)/2, player.getX(),.001);
        assertEquals((int) -Math.sqrt(1)/2, player.getY(),.001);
    }

    @Test
    public void testMove_0_0_1_135() {
        Player player = new Player();  
        player.setName("testMove_0_0_1_135");   
        player.setX(0);
        player.setY(0);
        player.setSpeed(1d);
        player.setHeading(135d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals((int) Math.sqrt(2)/2, player.getX(),.001);
        assertEquals((int) -Math.sqrt(2)/2, player.getY(),.001);
    }

    @Test
    public void testMove_0_0_1_150() {
        Player player = new Player();  
        player.setName("testMove_0_0_1_150");   
        player.setX(0);
        player.setY(0);
        player.setSpeed(1d);
        player.setHeading(150d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals((int) Math.sqrt(1)/2, player.getX(),.001);
        assertEquals((int) -Math.sqrt(3)/2, player.getY(),.001);
    }

    @Test
    public void testMove_0_0_1_180() {
        Player player = new Player();  
        player.setName("testMove_0_0_1_180");   
        player.setX(0);
        player.setY(0);
        player.setSpeed(1d);
        player.setHeading(180d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals((int) Math.sqrt(0)/2, player.getX(),.001);
        assertEquals((int) -Math.sqrt(4)/2, player.getY(),.001);
    }

    @Test
    public void testMove_1000_1000_1_200() {
        Player player = new Player();  
        player.setName("testMove_1000_1000_1_200");  
        player.setX(1000);
        player.setY(1000);
        player.setSpeed(1d);
        player.setHeading(200d);
        player.move();
        System.out.println(player.toString());  // output to debug console
        assertEquals(+999.0, player.getX(),.001);
        assertEquals(+999.0, player.getY(),.001);
    }
}

