package pattern.builder;

/**
 * Builder class that creates a beehive with specified number of rooms and bee species.
 * Requirements met:
 * - an apiary should be capable of spawning an unlimited number of beehives
 * - a beehive should only have one species
 */
public class Beehive {
    private int numRooms;
    private String beeSpecies;

    //builder
    public static class Builder {
        private int numRooms;
        private String beeSpecies;

        public Builder(int numRooms) { 
            this.numRooms = numRooms; 
        }

        public Builder withSpecies(String species) {
            this.beeSpecies = species;
            return this;
        }

        /**
         * A method to build the beehive.
         * @return beehive
         */
        public Beehive build() {
            Beehive hive = new Beehive();
            hive.numRooms = this.numRooms;
            hive.beeSpecies = this.beeSpecies; 
            return hive;
        }

    }

    private Beehive() { /*private constructor*/ }

    //access
    public int getNumRooms() { 
        return this.numRooms; 
    }
  
    //access
    public String getSpecies() { 
        return this.beeSpecies; 
    }
}