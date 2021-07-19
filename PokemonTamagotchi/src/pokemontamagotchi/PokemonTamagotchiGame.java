/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemontamagotchi;

import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lester
 */
public class PokemonTamagotchiGame {
    
    private static Scanner scanner;
    private static SecureRandom secureRandom;
    private static Hashtable<String,Pokemon> pokemons;

    public PokemonTamagotchiGame() {
        scanner = new Scanner(System.in);
        secureRandom = new SecureRandom();
        pokemons = new Hashtable<>();
    }
    
    private void printMenuOptions(){
        System.out.println("Select an Option");
        System.out.println("0. EXIT or WRITE \"EXIT\"");
        System.out.println("1. CREATE POKEMON");
        System.out.println("2. SELECT POKEMON");
        
    }
    
    private Species getSpecie(int id){
        Species specie = null;
        for(Species sp : Species.values()){
            if (sp.getId() == id) {
                specie = sp;
            }
        }
        return specie;
    }
    
    private Pokemon choosingRandomPokemon(){
        
        Pokemon newPokemon = null;
        int num = secureRandom.nextInt(4) + 1;
        
        newPokemon = new Pokemon(getSpecie(num));
        
        return newPokemon;
    }
    
    private String choosingPokemonNickname(){
        String nickName = "";
        while (true) {

            System.out.println("Choose your pokemon nickname ");
            

            nickName = scanner.nextLine();

            if (nickName.equalsIgnoreCase("cancel")) {
                System.out.println("Operation Canceled!");
                System.out.println("");
                break;
            }

            if (nickName.length() >= 1) {
                System.out.print("The name of your pokemon ->" + nickName);
                System.out.println("");
                break;
            }
            System.out.println("Please insert a valid name for your pokemon!");
        }
        return nickName;
    }
    
    private void createPokemonMenu(){
        System.out.println("W E L C O M E ! !");

        Pokemon newPokemon = choosingRandomPokemon();
        
        System.out.println("Ready to know your pokemon?!");
        System.out.println("...");
        System.out.print("Your pokemon is... ");
        System.out.println(newPokemon.specie.toString());
        
        String nickName = choosingPokemonNickname();
        
        if (nickName.length() >= 1){
            newPokemon.setPokemonNickName(nickName);
            System.out.println("WELCOME TO POKEMON TAMAGOTCHI");
            System.out.println(newPokemon.getPokemonPrt().toString());
            
            pokemons.put(nickName, newPokemon);
        }
        
    }
    
    private void listPokemons() {
        if (pokemons.isEmpty() == true) {
            System.out.println("INF: No pokemons have been created! ");
            System.out.println("");
        } else {
            int n = 1;
            for (Map.Entry<String, Pokemon> e : pokemons.entrySet()) {
                System.out.println(n +". "+e.getValue().getPokemonNickName()+"("+e.getValue().name+")");
                n++;
            }
        }
    }
    
    private void selectPokemonMenu(){
        System.out.println("SELECT YOUR POKEMON");
        listPokemons();
    }
    
    public void mainMenu(){
        String option = "";
        
        while (true) {
            printMenuOptions();
            
            System.out.print(">");
            option = this.scanner.nextLine();
            
            if (option.equals("0")) {
                System.out.println("Turning off...");
                System.exit(0);
            } else if(option.equalsIgnoreCase("EXIT")){
                System.out.println("Turning off...");
                System.exit(0);
            } else if (option.equals("1")) {
                this.createPokemonMenu();
            } else if (option.equals("2")){
                this.selectPokemonMenu();
            }
            
            option = "";
        }
    }
}
