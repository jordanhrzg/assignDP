package assignDP_jahzerzog;

import java.util.Random;
import java.util.Vector;

import builder_pattern.Beehive;

/**
 * REQs 4 packages for selected design patterns
 * 
 * apiary - only one, contains many beehives apiary - spawn unlimited beehives
 * 
 * beehive - network of rooms, cannot contain another beehive beehive - only has
 * one species beehive - resting room limits capacity
 * 
 * rooms - capable of spawning bees
 * 
 * bees - can battle each other one dies (beehives cannot command it) one gains
 * dead attributes if queen: new combo species & winning queen gets control of
 * both beehives bees - different species bees - have to rest sometimes, consume
 * food bees - create additional beehive rooms (1 bee 100 ticks or 50 bees 2
 * ticks) bees - actions: drones - look for food warriors - hunt enemies (or
 * rest if needed) queens - spawn egg
 * 
 * species - bonus attribute
 * 
 * end simulation - one active beehive/queen remaining
 * 
 * 
 * 
 * 
 * @author Jordan
 *
 */

public class jaherzog_assign7 {

    public static void main (final String[] args) {
        //---------------------------------------------------------Builder Pattern
        Vector<Beehive> testHives = new Vector<Beehive>();  //holds hives built
        
        //randomization
        Random rand = new Random();
        int[] numRoomsChoices = {5, 10, 20};
        String[] speciesChoices = {"Strong", "Quick", "Clever"};
        
        //build large number of randomly generated hives 
        int numToBuild = 500;
        for(int i = 0; i < numToBuild; i++) {
            int chosenNumRooms = numRoomsChoices[rand.nextInt(3)];
            String chosenSpecies = speciesChoices[rand.nextInt(3)];
            Beehive hive = new Beehive.Builder(chosenNumRooms).withSpecies(chosenSpecies).build();
            testHives.add(hive);
        }
        
        //Test
        System.out.printf("BUILDER PATTERN: %d hives were built", testHives.size());
        //uncomment to view hives with randomly generated attributes
//        for (Beehive b : testHives) {
//            System.out.printf("Hive: \tnumRooms = %d \tspecies = %s\n", b.getNumRooms(), b.getSpecies());
//        }
    }

}
