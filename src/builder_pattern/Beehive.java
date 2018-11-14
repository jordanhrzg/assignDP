package builder_pattern;

/*
 * Builder class that creates a beehive with specified number of rooms and bee species
 * All hives start with one queen bee of the specified species.
 */
public class Beehive {
    private int _numRooms;
    private String _beeSpecies;

    public static class Builder{
        private int _numRooms;
        private String _beeSpecies;
        
        public Builder(int numRooms) {
            this._numRooms = numRooms;
        }
        
        public Builder withSpecies(String species) {
            this._beeSpecies = species;
            
            return this;
        }
        
        public Beehive build() {
            Beehive hive = new Beehive();
            hive._numRooms = this._numRooms;
            hive._beeSpecies = this._beeSpecies; 
            
            return hive;
        }
        
    }
    
    private Beehive() { 
        //private constructor
    }
    
    public int getNumRooms(){ return this._numRooms; }
    public String getSpecies(){ return this._beeSpecies; }
}
