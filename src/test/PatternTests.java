package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;
import java.util.Vector;

import org.junit.Test;

import pattern.abstractfactory.Bee;
import pattern.abstractfactory.BeeFactory;
import pattern.abstractfactory.DroneFactory;
import pattern.abstractfactory.QueenFactory;
import pattern.abstractfactory.WarriorFactory;
import pattern.builder.Beehive;
import pattern.singleton.Apiary;

/**
 * A class that tests pattern packages.
 * @author Jordan Herzog jaherzog
 */
public class PatternTests {
    Vector<Beehive> testHives = new Vector<Beehive>();
    
    /**
     * A method to test the builder pattern package.
     */
    @Test
    public void builderTest() {
        Random rand = new Random();
        int[] numRoomsChoices = {5, 10, 20};
        String[] speciesChoices = {"Strong", "Quick", "Clever"};
        
        //build large number of randomly generated hives 
        int numToBuild = 500;
        for (int i = 0; i < numToBuild; i++) {
            int chosenNumRooms = numRoomsChoices[rand.nextInt(3)];
            String chosenSpecies = speciesChoices[rand.nextInt(3)];
            Beehive hive = new Beehive.Builder(chosenNumRooms).withSpecies(chosenSpecies).build();
            testHives.add(hive);
            
            assertEquals(hive.getNumRooms(), chosenNumRooms);
            assertEquals(hive.getSpecies(), (chosenSpecies));
            
        }
        
        assertEquals(testHives.size(), 500);
    }
    
    /**
     * A method to test the singleton pattern package.
     */
    @Test
    public void singletonTest() {
        final Apiary apiary1 = Apiary.getInstance();
        final Apiary apiary2 = Apiary.getInstance();
        final Apiary apiary3 = Apiary.getInstance();   
        
        apiary1.hives = testHives;
        
        assertEquals(apiary1.hives.size(), apiary2.hives.size());
        assertEquals(apiary2.hives.size(), apiary3.hives.size());
        
    }
    
    /**
     * A method to test the abstract factory pattern package.
     */
    @Test
    public void abstractFactoryTest() {
        BeeFactory beeFactory = new BeeFactory();
        Bee bee1 = beeFactory.getBee(new DroneFactory());
        Bee bee2 = BeeFactory.getBee(new WarriorFactory());
        Bee bee3 = BeeFactory.getBee(new QueenFactory());
        
        assertEquals(bee1.getType(), "drone");
        assertEquals(bee2.getType(), "warrior");
        assertEquals(bee3.getType(), "queen");
    }
    
    /**
     * A method to test the decorator pattern package.
     */
    @Test
    public void decoratorTest() {
        
        final pattern.decorator.Bee bee10 = new pattern.decorator.Warrior();
        final pattern.decorator.Bee bee20 = new pattern.decorator.SpeedyBeeDecorator(
                new pattern.decorator.Queen());
        final pattern.decorator.Bee bee30 = new pattern.decorator.StrongBeeDecorator(
                new pattern.decorator.Drone());
        final pattern.decorator.Bee bee40 = new pattern.decorator.SpeedyBeeDecorator(
                new pattern.decorator.StrongBeeDecorator(new pattern.decorator.Drone()));
        
        pattern.decorator.BeeDecorator genDecorator = new pattern.decorator.BeeDecorator(bee10);
        assertEquals(genDecorator.getType(), "Type: Warrior");
        
        
        //"Type: Queen"
        //Attribute: Speedy
        assertNotNull(bee10);
        assertNotNull(bee20);
        assertNotNull(bee30);
        assertNotNull(bee40);
        
        assertEquals(bee10.getType(), "Type: Warrior");
        assertEquals(bee20.getType(), "Type: Queen\nAttribute: Speedy");
        assertEquals(bee30.getType(), "Type: Drone\nAttribute: Strong");
        assertEquals(bee40.getType(), "Type: Drone\nAttribute: Strong\nAttribute: Speedy");
        
    }
    
    /**
     * A method to run the main class when testing.
     */
    @Test
    public void testMain() {
        assignDP_jaherzog.jaherzog_assign7 test = new assignDP_jaherzog.jaherzog_assign7();
        
        String[] testParam = new String[0];
        
        test.main(testParam);
    }
}