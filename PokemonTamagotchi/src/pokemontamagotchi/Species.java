/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemontamagotchi;

/**
 *
 * @author Lester
 */
public enum Species {
    
    PIKACHU(1,"Pikachu",new Sketch().pikachu),
    CYNDAQUIL(2,"Cyndaquil",new Sketch().cyndaquil),
    SQUIRTLE(3,"Squirtle",new Sketch().squirtle),
    MEWTWO(4,"Mewtwo",new Sketch().mewtwo);


    
    private final int id;
    private String draw;
    private String speciesName;
    
    Species(int id, String speciesName, String draw) {
        this.id = id;
        this.speciesName = speciesName;
        this.draw = draw;
    }
    
    public int getId(){
        return this.id;
    }
        /**
     * @return the speciesName
     */
    public String getSpeciesName() {
        return speciesName;
    }

    /**
     * @param speciesName the speciesName to set
     */
    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
    
    public String toString(){
        switch (this) {
            case PIKACHU: return "Pikachu" +"\n"+ this.draw;
            case CYNDAQUIL: return "Cyndaquil" +"\n"+ this.draw;
            case MEWTWO: return "Mewtwo" +"\n"+ this.draw;
            case SQUIRTLE: return "Squirtle" +"\n"+ this.draw;
            default:
                return "Default specie pokemon";
        }
    }
    
}
