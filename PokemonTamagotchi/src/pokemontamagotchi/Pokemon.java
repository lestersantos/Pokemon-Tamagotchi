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
public class Pokemon extends Tamagotchi {

    /**
     * @return the pokemonPrt
     */
    public PokemonProperties getPokemonPrt() {
        return pokemonPrt;
    }

    /**
     * @param pokemonPrt the pokemonPrt to set
     */
    public void setPokemonPrt(PokemonProperties pokemonPrt) {
        this.pokemonPrt = pokemonPrt;
    }
    
    public Species specie;
    
    private PokemonProperties pokemonPrt;

    public Pokemon(Species specie) {
        this.name = specie.getSpeciesName();
        this.specie = specie;
        this.pokemonPrt = new PokemonProperties();
    }
    
    public void setPokemonNickName(String nickName){
        this.getPokemonPrt().setNickname(nickName);
    }
    
    public String getPokemonNickName(){
        return this.getPokemonPrt().getNickname();
    }
    
    @Override
    public void display() {
        this.specie.toString();
    }
    
}
