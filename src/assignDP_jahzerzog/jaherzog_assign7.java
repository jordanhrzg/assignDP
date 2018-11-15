package assignDP_jahzerzog;

import java.util.Random;
import java.util.Vector;

import singleton_pattern.Apiary;
import builder_pattern.Beehive;
import factoryMethod_pattern.*;

/**
 * <h4>REQ SUMMARY:
 * <ul>
 *      <li>4 packages for selected design patterns</li>
 *      <ul>
 *          <li>done - builder</li>
 *          <li>done - singleton</li>
 *      </ul>
 *      <li>Apiary:</li>
 *      <ul>
 *          <li>only one</li>
 *          <li>contains many beehives</li>
 *          <li>spawn unlimited beehives</li>
 *      </ul>
 *      <li>Beehive:</li>
 *      <ul>
 *          <li>network of rooms</li>
 *          <li>cannot contain another beehive beehive</li>
 *          <li>only has one species</li>
 *          <li>resting room limits capacity</li>
 *      </ul>
 *      <li>Rooms: capable of spawning bees</li>
 *      <li>Bees:</li>
 *      <ul>
 *          <li>can battle each other:</li>
 *          <ul>
 *              <li>loser dies, cannot be commanded by beehive</li>
 *              <li>winner gains loser's attributes</li>
 *              <li>if queen battle:</li>
 *              <ul>
 *                  <li>both hives become combo species</li>
 *                  <li>both hives belong to winning queen</li>
 *              </ul>
 *          </ul>
 *          <li>need to rest & consume food</li>
 *          <li>can dig new beehive rooms</li>
 *          <li>actions:</li>
 *          <ul>
 *              <li>depend on proximity</li>
 *              <ul>
 *                  <li>example: near another bee, fight</li>
 *              </ul>
 *              <li>accomplished across ticks</li>
 *              <ul>
 *                  <li>example: 1 bee = 1 room/100 ticks OR 50 bees = 1 room/2 ticks</li>
 *              </ul>
 *              <li>worker-specific:</li>
 *              <ul>
 *                  <li>drones: look for food/rest</li>
 *                  <li>warriors: hunt enemies/rest</li>
 *                  <li>queens: spawn egg/rest</li>
 *              </ul>
 *          </ul>
 *          <li>have species with bonus attribute(s)</li>
 *      </ul>
 *      <li>End Simulation if only one queen remains</li>
 * </ul>
 * 
 * @author Jordan
 */

//****************************************
//***********SINGLETON PATTERN************

public class jaherzog_assign7 {

    public static void main (final String[] args) {
        //---------------------------------------------------------Builder Pattern
        System.out.println("\n************BUILDER PATTERN*************");
        
        Vector<Beehive> testHives = new Vector<Beehive>();  //holds built hives
        
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
        System.out.printf("%d hives were built.\n", testHives.size());
        //uncomment to view hives with randomly generated attributes
//        for (Beehive b : testHives) {
//            System.out.printf("Hive: \tnumRooms = %d \tspecies = %s\n", b.getNumRooms(), b.getSpecies());
//        }
        
        
        //-------------------------------------------------------Singleton Pattern
        System.out.println("\n***********SINGLETON PATTERN************");
        //create multiple reference points to the singleton
        Apiary apiary1 = Apiary.getInstance();
        Apiary apiary2 = Apiary.getInstance();
        Apiary apiary3 = Apiary.getInstance();
        
        apiary1._hives = testHives;
        System.out.printf("%d hives added to Apiary #1.", apiary1._hives.size());
        System.out.printf("\nApiary #2 now has %d hives too.", apiary2._hives.size());
        System.out.printf("\nApiary #3 also has %d hives.\n", apiary3._hives.size());
        
      
        //------------------------------------------------Abstract Factory Pattern
        System.out.println("\n********Abstract Factory Pattern********");
        //use abstract factory to make different bees
        Bee bee1 = BeeFactory.getBee(new DroneFactory());
        Bee bee2 = BeeFactory.getBee(new WarriorFactory());
        Bee bee3 = BeeFactory.getBee(new QueenFactory());
        
        System.out.printf("Abstract factory made bee #1 type: %s", bee1.getType());
        System.out.printf("\nAbstract factory made bee #2 type: %s", bee2.getType());
        System.out.printf("\nAbstract factory made bee #3 type: %s", bee3.getType());
    }
}
