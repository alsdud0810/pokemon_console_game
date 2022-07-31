package Game.thread;

import Game.Pokemons.Pokemon;

import java.util.Scanner;

public class MyAttackThread extends Thread {
    public boolean hasChosen;
    public String input;
    Scanner sc = new Scanner(System.in);
    public int type;
    public Pokemon pokemon;
    public Pokemon wildPokemon;
    public boolean stop;

    public MyAttackThread(int type,Pokemon pokemon, Pokemon wildPokemon, boolean stop) {
        this.type=type;
        this.pokemon = pokemon;
        this.wildPokemon = wildPokemon;
        this.stop=stop;

    }


    public void my_attack() {

            int damage = 0;

            while(stop){

                try{
                    Thread.sleep(1800);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                if(pokemon.getHp()>=0 && wildPokemon.getHp()>=0){
                    if (type==1) { // 1번 기술
                        hasChosen = true;
                        damage = pokemon.getSkill1().skilldamage + pokemon.getLevel() / 20;
                        System.out.println("-----------------------");
                        System.out.println(pokemon.getName() + "의 " + pokemon.getSkill1().skillname + "!");
                        System.out.println(damage + "의 데미지를 입혔습니다.");
                        System.out.println("-----------------------");
                        wildPokemon.setHp(wildPokemon.getHp() - damage);
                    }
                    else if (type==2){
                        hasChosen = true;
                        damage = pokemon.getSkill2().skilldamage + pokemon.getLevel() / 20;
                        System.out.println("-----------------------");
                        System.out.println(pokemon.getName() + "의 " + pokemon.getSkill2().skillname + "!");
                        System.out.println(damage + "의 데미지를 입혔습니다.");
                        System.out.println("-----------------------");
                        wildPokemon.setHp(wildPokemon.getHp() - damage);
                    }
                }
                else {
                    if(pokemon.getHp()<=0){
                        pokemon.setHp(0);
                        if (type==1) { // 1번 기술
                            hasChosen = true;
                            damage = pokemon.getSkill1().skilldamage + pokemon.getLevel() / 20;
                            System.out.println("-----------------------");
                            System.out.println(pokemon.getName() + "의 " + pokemon.getSkill1().skillname + "!");
                            System.out.println(damage + "의 데미지를 입혔습니다.");
                            System.out.println("-----------------------");
                            wildPokemon.setHp(wildPokemon.getHp() - damage);
                        }
                        else if (type==2){
                            hasChosen = true;
                            damage = pokemon.getSkill2().skilldamage + pokemon.getLevel() / 20;
                            System.out.println("-----------------------");
                            System.out.println(pokemon.getName() + "의 " + pokemon.getSkill2().skillname + "!");
                            System.out.println(damage + "의 데미지를 입혔습니다.");
                            System.out.println("-----------------------");
                            wildPokemon.setHp(wildPokemon.getHp() - damage);
                        }
                    }else if(wildPokemon.getHp()<=0){
                        wildPokemon.setHp(0);
                    }
                    stop=false;
                }
            }







    }

    @Override
    public void run(){
        try{
            my_attack();
        }catch (Exception e){

        }
    }
}