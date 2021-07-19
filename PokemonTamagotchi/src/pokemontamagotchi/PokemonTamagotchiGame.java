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
        
        addPokemonToList("Default1", new Pokemon(Species.CYNDAQUIL));
        addPokemonToList("Default2", new Pokemon(Species.MEWTWO));
        addPokemonToList("Default3", new Pokemon(Species.PIKACHU));
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
    
    private Pokemon addPokemonToList(String nickname, Pokemon newPokemon){
        newPokemon.setPokemonNickName(nickname);
        pokemons.put(nickname, newPokemon);
        return newPokemon;
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
            //NEw METHOD ADD POKEMON TO POKEDEX
            newPokemon = addPokemonToList(nickName,newPokemon);
            System.out.println("WELCOME TO POKEMON TAMAGOTCHI");
            System.out.println(newPokemon.getPokemonPrt().toString());          
        }
        
    }
    
    private void listPokemons() {
        if (pokemons.isEmpty() == true) {
            System.out.println("INF: No pokemons have been created! ");
            System.out.println("");
        } else {
            int n = 1;
            System.out.println("No."+"\tNICKNAME"+"\t SPECIE");
            for (Map.Entry<String, Pokemon> e : pokemons.entrySet()) {
                
                System.out.println(n +".\t"+e.getValue().getPokemonNickName()+" \t("+e.getValue().name+")");
                n++;
            }
        }
    }
    
    private void selectPokemonMenu(){
        System.out.println("SELECT YOUR POKEMON");

        listPokemons();

        if (pokemons.isEmpty() != true) {
            String choice;
            System.out.print(">");
            choice = scanner.nextLine();

            Pokemon pokemonSelected = null;

            if (choice.equalsIgnoreCase("cancel")) {
                System.out.println("INF: Operation Canceled!");
                System.out.println("");
            } else {
                pokemonSelected = pokemons.get(choice);
                if (pokemonSelected == null) {
                    System.out.println("INF: Please select a valid pokemon");
                } else {
                    System.out.println("GOOD! CURRENT POKEMON-> " + pokemonSelected.getPokemonNickName() + "(" + pokemonSelected.name + ")");
                    //Set current pokemon to make actions
                }
            }
        }
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
