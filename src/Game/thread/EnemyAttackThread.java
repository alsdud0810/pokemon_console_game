package Game.thread;

import Game.Pokemons.Pokemon;
import Game.Skill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnemyAttackThread extends Thread{

    public Pokemon pokemon;
    public Pokemon wildPokemon;
    public int wildDamage;
    public Skill wildSkill;
    public boolean stop;

    public EnemyAttackThread(Pokemon pokemon, Pokemon wildPokemon, int wildDamage, Skill wildSkill, boolean stop) {
        this.pokemon = pokemon;
        this.wildPokemon = wildPokemon;
        this.wildDamage=wildDamage;
        this.wildSkill=wildSkill;
        this.stop=stop;

    }

    public void enemy_attack(){

        while(stop){

            try{
                Thread.sleep(1800);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

//            System.out.println("야생포켓몬 hp: "+wildPokemon.getHp());

            if(pokemon.getHp()>0 && wildPokemon.getHp()>0){
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------------");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t"+wildPokemon.getName()+"의 "+wildSkill.skillname + "!");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t"+wildDamage + "의 데미지를 입었습니다.");
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------------");
                pokemon.setHp(pokemon.getHp()-wildDamage);
            }
            else {
                if(pokemon.getHp()<=0) {
                    pokemon.setHp(0);
                }
//              else if(wildPokemon.getHp()<=0){
//                    System.out.println(wildPokemon.getName()+"의 "+wildSkill.skillname + "!");
//                    System.out.println(wildDamage + "의 데미지를 입었습니다.\n");
//                    pokemon.setHp(pokemon.getHp()-wildDamage);
//                }
                stop=false;
            }
        }
    }
    @Override
    public void run(){
        try{
            enemy_attack();
        }catch (Exception e){

        }


    }
}
