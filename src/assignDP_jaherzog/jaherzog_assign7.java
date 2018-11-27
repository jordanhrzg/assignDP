package assignDP_jaherzog;

import java.util.Random;
import java.util.Vector;

import pattern.abstractfactory.Bee;
import pattern.abstractfactory.BeeFactory;
import pattern.abstractfactory.DroneFactory;
import pattern.abstractfactory.QueenFactory;
import pattern.abstractfactory.WarriorFactory;
import pattern.builder.Beehive;
import pattern.singleton.Apiary;

/**
 * A class that demos the design pattern packages included.
 * @author Jordan Herzog jaherzog
 * @version 11/26/2018
 */
public class jaherzog_assign7 {
    /**
     * Main entry point for applictaion.
     * @param args - command line arguments
     */
    public static void main(final String[] args) {
        //---------------------------------------------------------------------------Builder Pattern
        System.out.println("\n***********************BUILDER PATTERN**********************"
                  + "\n\"The builder pattern allows for step-by-step creation of"
                  + "\ncomplex objects.\" - Go4. This pattern is useful in" 
                  + "\nsimplifying object creation.");
        
        Vector<Beehive> testHives = new Vector<Beehive>();  //holds built hives
        
        //randomization
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
        }
        
        //Test
        System.out.printf("%n%d beehives were built with the beehive builder.%n%n", 
                testHives.size());
        System.out.println("Sample (first 10 beehives): ");
        for (int j = 0; j < 10; j++) {
            System.out.printf("Hive %d: \t# Rooms = %d \tSpecies = %s%n", 
                    (j + 1), 
                    testHives.get(j).getNumRooms(), 
                    testHives.get(j).getSpecies());
        }
        
        System.out.println("\nExplanation: In this implementation, the builder pattern is"
                          + "\nused to mass produce beehives with different numbers of" 
                          + "\nrooms and different species of bees (both of which are"
                          + "\nrandomly determined at runtime as well).");
        
        //-------------------------------------------------------------------------Singleton Pattern
        System.out.println("\n*********************SINGLETON PATTERN**********************" 
                            + "\n\"The singleton pattern ensures that only one object of a" 
                            + "\nparticular class is ever created.\" - Go4. This pattern is" 
                            + "\nuseful in mandating the use of instances with a program.");
        
        //create multiple reference points to the singleton
        System.out.println("\nCreating three apiary objects...");
        final Apiary apiary1 = Apiary.getInstance();
        final Apiary apiary2 = Apiary.getInstance();
        final Apiary apiary3 = Apiary.getInstance();   
        
        apiary1.hives = testHives;
        System.out.printf("%nIf %d hives are added to Apiary #1.", apiary1.hives.size());
        System.out.printf("%nThen, Apiary #2 now has %d hives.", apiary2.hives.size());
        System.out.printf("%nAnd, Apiary #3 also has %d hives.%n", apiary3.hives.size());
        
        apiary2.hives = new Vector<Beehive>();
        System.out.printf("%nIf Apiary #2 hives are set to %d.", apiary2.hives.size());
        System.out.printf("%nThen, Apiary #1 now has %d hives.", apiary1.hives.size());
        System.out.printf("%nAnd, Apiary #3 also has %d hives.%n", apiary3.hives.size());
        
        System.out.println("\nExplanation: With the singleton implementation, all objects"
                            + "\nare essentially copies of a singular instance and updates to"
                            + "\none instance are reflected in all other instances.");
        
        //------------------------------------------------------------------Abstract Factory Pattern
        System.out.println("\n******************Abstract Factory Pattern******************"
                            + "\n\"The abstract factory pattern allows for the creation of"
                            + "\ngroups of related objects without the requirement of"
                            + "\nspecifying the exact concrete classes that will be used.\"" 
                            + "\n- Go4");
        //use abstract factory to make different bees
        System.out.println("\nCreating 3 generic bees with the abstract factory...");
        Bee bee1 = BeeFactory.getBee(new DroneFactory());
        Bee bee2 = BeeFactory.getBee(new WarriorFactory());
        Bee bee3 = BeeFactory.getBee(new QueenFactory());
        
        System.out.println("\nThe abstract bee factory made different bee types without" 
                          + "\nspecifying the concrete class:");
        System.out.printf("Bee #1 type: %s", bee1.getType());
        System.out.printf("%nBee #2 type: %s", bee2.getType());
        System.out.printf("%nBee #3 type: %s%n", bee3.getType());
        
        System.out.println("\nExplanation: The abstract factory uses concrete bee-type"
                            + "\nfactories to create bees of the desired type.");

        //-------------------------------------------------------------------------Decorator Pattern
        System.out.println("\n*********************Decorator Pattern**********************"
                            + "\n\"The decorator pattern is a design pattern that extends the"
                            + "\nfunctionality of individual objects by wrapping them with" 
                            + "\none or more decorator classes.\" - Go4");
        
        //use decorator to make bees with different attribute-type combinations
        System.out.println("\nUsing the decorator to make bees with different attribute-"
                          + "\ntype combinations...");
        final pattern.decorator.Bee bee10 = new pattern.decorator.Warrior();
        final pattern.decorator.Bee bee20 = new pattern.decorator.SpeedyBeeDecorator(
                new pattern.decorator.Queen());
        final pattern.decorator.Bee bee30 = new pattern.decorator.StrongBeeDecorator(
                new pattern.decorator.Drone());
        final pattern.decorator.Bee bee40 = new pattern.decorator.SpeedyBeeDecorator(
                new pattern.decorator.StrongBeeDecorator(new pattern.decorator.Drone()));
        
        System.out.println("\nBee #10:\n" + bee10.getType());
        System.out.println("\nBee #20:\n" + bee20.getType());
        System.out.println("\nBee #30:\n" + bee30.getType());
        System.out.println("\nBee #40:\n" + bee40.getType());
        
        System.out.println("\nExplanation: This implementation of the decorator pattern"
                            + "\napplies type and attribute decorators to extend the"
                            + "\nfunctionality of bee objects.");  
    }
}