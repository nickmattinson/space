

import org.junit.Test;

import main.java.tech.fall.asset.entity.planet.Planet;

import static org.junit.Assert.assertEquals;

public class PlanetTest {
    // Unnecessary test for name attribute that is tested in PlayerTest class
    @Test
        public void testName_Mars(){
            // using constructor
            Planet a = new Planet("Mars");
            assertEquals("Mars", a.getName());
        }

    // Test if user inputs negative results
    @Test
        public void test_no_planet_name(){
            // using constructor
            Planet a = new Planet();
            assertEquals("Unknown Planet Name", a.getName());
        }
    // Test general negative inputs

    // Test the mass of the planet

    // Test the size of the planet

    // Test the gravity of two planets

    // Test the ecosystem of the planet

    // Etc


}
