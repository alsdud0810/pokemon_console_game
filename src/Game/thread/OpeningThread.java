package Game.thread;

import Game.Pokemons.Bulbasaur;
import Game.Pokemons.Charmander;
import Game.Pokemons.Squirtle;
import Game.Pokemons.Pokemon;

public class OpeningThread implements Runnable{
    public void run(){
        String[] script = {"\n\n\n지","우","는 ","10","살","이 ","되","어 ","포","켓","몬 ","트","레","이","너","가 ","되","고","자 ","합","니","다",".\n",
                            "현","재 ","최","고","의 ","챔","피","언 ","단","델","을 ","이","기","고\n",
                            "자","신","이 ","챔","피","언","이 ","되","는 ","것","이 ", "목","표","입","니","다",".\n",
                            "지","우","가 ","챔","피","언","이 ","될 ","수 ","있","도","록 ","도","와","주","세","요","!","!"};
        for (int i=0; i<script.length;i++){
            System.out.print(script[i]);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        String[] script2 = {"\n\n\n\n함","께 ","할 ","포","켓","몬","을 ","선","택","하","기 ","위","해 ","오","박","사","님 ","댁","으","로"," ","향","합","니","다.\n"};
        for (int i=0; i<script2.length;i++){
            System.out.print(script2[i]);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e){
            e.printStackTrace();
        }
        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.print("로딩중");
        for(int i=0; i<20; i++ ) {
            System.out.print('.');

            try {
                Thread.sleep(140);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(int i=0; i<60; i++) {
            System.out.println();
        }
        System.out.println("오박사: 반갑네 ! 난 오박사라고 하네.");
        System.out.println("오박사: 함께 할 포켓몬을 선택하게나.\n\n\n");
        System.out.println("==========함께할 포켓몬을 선택하세요==========");
        System.out.println("[1] 파이리 \t [2] 꼬부기 \t [3] 이상해씨");

    }
}
