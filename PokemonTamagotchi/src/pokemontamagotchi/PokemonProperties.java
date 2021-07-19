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
public class PokemonProperties {

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
 private String nickname;
 private int hungerLevel;
 private int happinessLevel;
 private int weigth;

    public PokemonProperties() {
        this.nickname = "Default";
        this.hungerLevel = 10;
        this.happinessLevel = 1;
        this.weigth = 1;
    }
    
    public String toString(){
               return String.format("Nickname: "+this.nickname + "\n"
                       + "HungerLevel: "+this.hungerLevel + "\n"
                       + "HappinessLevel: "+this.happinessLevel + "\n"
                       + "Weight: "+this.weigth + "\n"
                );
    }
}
