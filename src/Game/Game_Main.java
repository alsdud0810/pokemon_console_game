package Game;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Game.*;
import Game.Pokemons.*;
import Game.Place.*;
import Game.thread.*;


public class Game_Main {


    public static void main(String[] args) {
        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        Pokemon pokemon = new Pokemon();
        Bag bag = new Bag();
        Scanner sc = new Scanner(System.in);


        Place place1 = new Place(0, "태초마을");
        Place place2 = new Place(1, "야생1");
        Place place3 = new Place(2, "마을1");
        Place place4 = new Place(3, "야생2");
        Place place5 = new Place(4, "마을2");
        Place place6 = new Place(5, "체육관");

        LoadingThread loading = new LoadingThread("loading");
        OpeningThread openingThread = new OpeningThread();
        Thread opening = new Thread(openingThread);
        opening.start();
        try{
            opening.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        Boolean hasChosen =false;   // 초기 포켓몬 선택
        while (!hasChosen) {
            String input = sc.next();
            try{
                int tmp = Integer.parseInt(input);
                if (tmp == 1 ) {
                    pokemon = new Charmander(200);
                    hasChosen = true;
                } else if (tmp == 2) {
                    pokemon = new Squirtle(5);
                    hasChosen = true;
                } else if (tmp == 3) {
                    pokemon = new Bulbasaur(5);
                    hasChosen = true;
                } else {
                    System.out.println("1,2,3 중 하나를 고르십시오.");
                }
            }catch (Exception e){
                System.out.println("1,2,3, 중 하나를 고르십시오");
            }

        }
        OpeningThread2 openingThread2 = new OpeningThread2();
        Thread opening2 = new Thread(openingThread2);
        opening2.start();
        try{
            opening2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        LoadingThread starting = new LoadingThread("starting");
        starting.start();
        try {
            starting.join();
        } catch (Exception e) {
            e.printStackTrace();
        }


        /////////////////////////////////////////////////////////////////////////////////////////////
        ArrayList<Place> places = new ArrayList<>();
        places.add(place1);
        places.add(place2);
        places.add(place3);
        places.add(place4);
        places.add(place5);
        places.add(place6);

        while(true){
            int place_n=0;
            while(place_n <= places.size()){
                Place place = places.get(place_n);

                if (place_n==0){
                    System.out.println("===========================태초 마을===========================\n");
                } else if (place_n==1){
                    System.out.println("===========================야생1===========================\n");
                } else if (place_n==2){
                    System.out.println("===========================마을1===========================\n");
                } else if (place_n==3){
                    System.out.println("===========================야생2===========================\n");
                } else if (place_n==4){
                    System.out.println("===========================마을2===========================\n");
                } else if (place_n==5){
                    System.out.println("===========================체육관===========================\n");
                }

                if(place_n==1 || place_n==3) {
                    System.out.println("[q] 이전 장소로 돌아가기    [w] 다음 장소로 가기   [p] 포켓몬 현황 보기   [e] 야생 포켓몬 만나기");
                } else if(place_n==2 || place_n==4) {
                    System.out.println("[q] 이전 장소로 돌아가기    [w] 다음 장소로 가기   [p] 포켓몬 현황 보기   [s] 상점   [c] 포켓몬 센터");
                } else if(place_n==0){
                    System.out.println("[w] 야생1로 가기   [p] 포켓몬 현황 보기   [s] 상점   [c] 포켓몬 센터");
                } else if (place_n==5){
                    System.out.println("[q] 야생2로 돌아가기    [p] 포켓몬 현황 보기   [e] 최종 보스와 전투");
                }
                System.out.println("\n\n행동 선택: ");
                String input = sc.next();

                if (input.equals("q")){ //이전 장소로 돌아가기
                    if (place_n==0){
                        System.out.println("메뉴 중에서 선택하세요.");
                        continue;
                    }
                    place_n--;
                    LoadingThread previousstage = new LoadingThread("previousstage");
                    previousstage.start();
                    try {
                        previousstage.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    continue;
                } else if (input.equals("w")){ //다음 장소로 가기
                    if (place_n==5){
                        System.out.println("메뉴 중에서 선택하세요.");
                        continue;
                    }
                    place_n++;
                    LoadingThread nextstage = new LoadingThread("nextstage");
                    nextstage.start();
                    try {
                        nextstage.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    continue;
                } else if (input.equals("p")){ //포켓몬 현황 보기
                    System.out.println("======================");
                    pokemon.printPokemon();
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    for (int i=0;i<60;i++){
                        System.out.println();
                    }
                    if(bag.getPotions()>0){
                        hasChosen = false;
                        while(!hasChosen){
                            System.out.println("회복 열매가 "+bag.getPotions()+" 개 있습니다. 사용하시겠습니까? (y/n)");
                            input = sc.next();
                            if(input.equals("y")){
                                hasChosen=true;
                                pokemon.setHp(pokemon.getFullHp());
                                bag.setPotions(bag.getPotions()-1);
                                System.out.println("회복 열매를 사용했습니다.");
                                System.out.println("======================");
                                pokemon.printPokemon();
                                try {
                                    Thread.sleep(2000);
                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                                for (int i=0;i<60;i++){
                                    System.out.println();
                                }
                            } else if(input.equals("n")){
                                hasChosen=true;
                                for (int i=0;i<60;i++){
                                    System.out.println();
                                }
                            }System.out.println();
                        }
                    }
                    continue;
                } else if (input.equals("e")){ // 야생 포켓몬 전투
                    if (place_n==0 || place_n==2 || place_n==4){
                        System.out.println("메뉴 중에서 선택하세요.");
                        continue;
                    }
                    List<Pokemon> wildPokemons = new ArrayList<>();
                    int level = (int)(Math.random()*4)+5;
                    int bosslevel = 50;
                    if (place_n==1){
                        wildPokemons.add(new Ekans(level));
                        wildPokemons.add(new Pikachu(level));
                    } else if (place_n==3){
                        wildPokemons.add(new Oddish(level));
                        wildPokemons.add(new Sandshrew(level));
                        wildPokemons.add(new Charmeleon(level));
                    } else if (place_n==5){
                        wildPokemons.add(new Charizard(bosslevel));
                    }
                    int randomChooseIndex = (int)(Math.random()*wildPokemons.size());
                    Pokemon wildPokemon = wildPokemons.get(randomChooseIndex);
                    List<Skill> wildSkills = new ArrayList<>();
                    if(wildPokemon.getName()=="Charmeleon"){
                        wildSkills.add(wildPokemon.getSkill1());
                        wildSkills.add(wildPokemon.getSkill2());
                        wildSkills.add(wildPokemon.getSkill3());
                    } else if(wildPokemon.getName()=="Charizard"){
                        wildSkills.add(wildPokemon.getSkill1());
                        wildSkills.add(wildPokemon.getSkill2());
                        wildSkills.add(wildPokemon.getSkill3());
                        wildSkills.add(wildPokemon.getSkill4());
                    } else {
                        wildSkills.add(wildPokemon.getSkill1());
                        wildSkills.add(wildPokemon.getSkill2());
                    }

                    // 단델 대사
                    if (place_n==5){
                        LoadingThread gotogym = new LoadingThread("gotogym");
                        gotogym.start();
                        try {
                            gotogym.join();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println("단델: 트레이너가 된 지 얼마 안된 것 같은데\n");
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        System.out.println("단델: 벌써 챔피언을 노리고 있다니, 대단하구나.\n");
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        System.out.println("단델: 그럼, 누가 챔피언이 될 지 해보자고\n");
                        try {
                            Thread.sleep(3000);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }

                    for (int i=0;i<60;i++){
                        System.out.println();
                    }

                    System.out.println(wildPokemon.getName()+"이(가) 나타났습니다!!\n");
                    wildPokemon.printWildPokemon();
                    System.out.println("======================");
                    System.out.println("당신의 포켓몬: ");
                    pokemon.printPokemon();

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    boolean hasEnded = false;


                    System.out.println("\n\n[1]자동전투     [2]수동전투");

                    String fighttype = sc.next();

                    if (fighttype.equals("1")){ // 자동 전투
                        // 자동 전투
                        int skillRandomIndex = (int)(Math.random()*2);
                        Skill wildSkill = wildSkills.get(skillRandomIndex);
                        int wildDamage = wildSkill.skilldamage*wildPokemon.getLevel()/20;

                        Random random = new Random();
                        int myattackrandomindex = random.nextInt(2)+1;

                        // 공격 스레드
                        MyAttackThread myAttackThread = new MyAttackThread(myattackrandomindex,pokemon,wildPokemon,true);
                        EnemyAttackThread enemyAttackThread = new EnemyAttackThread(pokemon,wildPokemon,wildDamage,wildSkill,true);

                        try {
                            myAttackThread.start();
                            Thread.sleep(1000);
                            enemyAttackThread.start();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        try {
                            myAttackThread.join();
                            enemyAttackThread.join();
                        }  catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (wildPokemon.getHp()<=0) {
                            pokemon.setExp(pokemon.getExp()+wildPokemon.getLevel());
                            System.out.println(wildPokemon.getName() + "을 쓰러뜨렸습니다.");
                            System.out.println(wildPokemon.getLevel() + "만큼의 경험치를 얻었습니다.\n");
                            try {
                                Thread.sleep(3000);
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                            for (int i=0;i<60;i++){
                                System.out.println();
                            }
                            if(place_n==5){
                                System.out.println("챔피언 단델과 리자몽을 쓰러뜨리고 지우가 챔피언이 되었습니다!!");
                                System.out.println("게임을 종료합니다.");
                                try {
                                    Thread.sleep(2000);
                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                                System.exit(0);
                            }
                        } else {
                            pokemon.setHp(pokemon.getHp()-wildDamage);
                            if (pokemon.getHp()<=0){
                                System.out.println("당신의 포켓몬이 기절했습니다.");
                                System.out.println("마을로 이동해 포켓몬을 치료하세요.\n");
                                pokemon.setHp(pokemon.getFullHp());
                            }
                        }
                        ////// 자동 전투 끝


                    }
                    else if (fighttype.equals("2")){ // 수동 전투
                        // 수동 전투
                        while (!hasEnded){
                            for (int i=0;i<60;i++){
                                System.out.println();
                            }
                            wildPokemon.printWildPokemon();
                            System.out.println("======================");
                            System.out.println("당신의 포켓몬: ");
                            pokemon.printPokemon();
                            if (place_n==5){
                                System.out.println("[1] 1번 기술 사용   [2] 2번 기술 사용  [r] 도망");
                            }else {
                                System.out.println("[1] 1번 기술 사용   [2] 2번 기술 사용  [p] 포켓볼 사용   [r] 도망");
                                System.out.println(bag.getPokeballs()+ "개의 포켓볼을 가지고 있습니다.");
                            }


                            hasChosen=false;
                            while (!hasChosen){
                                input = sc.next();
                                int damage=0;
                                if (input.equals("1")||input.equals("2")){ // 내 공격
                                    if(input.equals("1")){ // 1번 기술
                                        hasChosen=true;
                                        damage=pokemon.getSkill1().skilldamage + pokemon.getLevel() / 20;
                                        System.out.println("-----------------------");
                                        System.out.println(pokemon.getName() + "의 " + pokemon.getSkill1().skillname + "!");
                                    } else {
                                        hasChosen=true;
                                        damage=pokemon.getSkill2().skilldamage + pokemon.getLevel() / 20;
                                        System.out.println("-----------------------");
                                        System.out.println(pokemon.getName() + "의 " + pokemon.getSkill2().skillname + "!");
                                    }
                                    System.out.println(damage + "의 데미지를 입혔습니다.");
                                    System.out.println("-----------------------\n");
                                    try {
                                        Thread.sleep(300);
                                    } catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    wildPokemon.setHp(wildPokemon.getHp()-damage);

                                    if (wildPokemon.getHp()<=0) {
                                        hasEnded=true;
                                        pokemon.setExp(pokemon.getExp()+wildPokemon.getLevel());
                                        System.out.println(wildPokemon.getName() + "을 쓰러뜨렸습니다.");
                                        System.out.println(wildPokemon.getLevel() + "만큼의 경험치를 얻었습니다.\n");
                                        try {
                                            Thread.sleep(3000);
                                        } catch (Exception e){
                                            e.printStackTrace();
                                        }
                                        for (int i=0;i<60;i++){
                                            System.out.println();
                                        }
                                        if(place_n==5){
                                            System.out.println("챔피언 단델과 리자몽을 쓰러뜨리고 지우가 챔피언이 되었습니다!!");
                                            System.out.println("게임을 종료합니다.");
                                            try {
                                                Thread.sleep(2000);
                                            } catch (Exception e){
                                                e.printStackTrace();
                                            }
                                            System.exit(0);
                                        }
                                    } else { // 적의 공격
                                        // 만나는야생 포켓몬마다.





                                        int skillRandomIndex = (int)(Math.random()*2);
                                        Skill wildSkill = wildSkills.get(skillRandomIndex);
                                        int wildDamage = wildSkill.skilldamage*wildPokemon.getLevel()/20;

                                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------------");
                                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t"+wildPokemon.getName()+"의 "+wildSkill.skillname + "!");
                                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t"+wildDamage + "의 데미지를 입었습니다.");
                                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------------\n");


                                        // 야생 포켓몬
                                        if (wildPokemon.getName()=="아보"){
                                            System.out.println("아보의 지속 독 데미지로 체력이 추가 감소합니다.");
                                        }



                                        try {
                                            Thread.sleep(2000);
                                        } catch (Exception e){
                                            e.printStackTrace();
                                        }
                                        pokemon.setHp(pokemon.getHp()-wildDamage);
                                        if (pokemon.getHp()<=0){
                                            System.out.println("당신의 포켓몬이 기절했습니다.");
                                            System.out.println("마을로 이동해 포켓몬을 치료하세요.\n");
                                            try {
                                                Thread.sleep(1000);
                                            } catch (Exception e){
                                                e.printStackTrace();
                                            }
                                            for (int i=0;i<60;i++){
                                                System.out.println();
                                            }
                                            pokemon.setHp(pokemon.getFullHp());
                                            hasEnded=true;
                                        }
                                    }
                                } else if(input.equals("p")){
                                    hasChosen=true;
                                    if (bag.getPokeballs()>0){
                                        bag.setPokeballs(bag.getPokeballs()-1);
                                        System.out.println("포켓볼을 던졌습니다.");
                                        System.out.println("축하합니다!" + wildPokemon.getName()+ "을(를) 잡았습니다!");
                                        System.out.println(wildPokemon.getName()+"은(는) 컴퓨터로 이동됩니다.\n");

                                        pokemonList.add(wildPokemon);
                                        hasEnded=true;
                                    } else {
                                        System.out.println("포켓볼이 없습니다.");
                                    }
                                } else if(input.equals("r")){
                                    hasChosen=true;
                                    hasEnded=true;
                                    System.out.println("성공적으로 도망쳤습니다.\n");
                                    try {
                                        Thread.sleep(2000);
                                    } catch (Exception e){
                                        e.printStackTrace();
                                    }
                                    for (int i=0;i<60;i++){
                                        System.out.println();
                                    }
                                } else{
                                    System.out.println("'1', '2', 'p', 'r' 중 하나를 고르시오.");
                                }
                            }
                        }
                        //// 수동 전투 끝


                    } else{
                        System.out.println("메뉴 중에서 선택하세요.");
                        continue;
                    }


                    if (pokemon.isLevelUp(pokemon)){
                        pokemon.setHp(pokemon.getHp()+5);
                        pokemon.setFullHp(pokemon.getFullHp()+5);
                        pokemon.setLevel(pokemon.getLevel()+1);
                        System.out.println("레벨업! 축하합니다!\n");
                    }

                    continue;
                } else if (input.equals("s")){ //상점
                    if (place_n==1 || place_n==3 || place_n==5){
                        System.out.println("메뉴 중에서 선택하세요.");
                        continue;
                    }
                    LoadingThread gotoshop = new LoadingThread("gotoshop");
                    gotoshop.start();
                    try {
                        gotoshop.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    boolean isDone=false;
                    while (!isDone){
                        for (int i=0;i<60;i++){
                            System.out.println();
                        }
                        System.out.println("=================상점=================\n");
                        System.out.println("[1] 회복 열매 구매, [2] 포켓볼");
                        System.out.println("[q] 나가기");
                        input=sc.next();
                        if (input.equals("1") || input.equals("2")){
                            System.out.println("몇 개를 구매하겠습니까?");
                            int n=0;
                            try{
                                n=sc.nextInt();
                                if (input.equals("1")){
                                    bag.setPotions(bag.getPotions()+n);
                                }
                                else{
                                    bag.setPokeballs(bag.getPokeballs()+n);
                                }
                            }catch (Exception e){
                                System.out.println("숫자를 입력하세요.");
                            }
                        }else if(input.equals("q")){
                            isDone=true;
                            LoadingThread backtostage = new LoadingThread("backtostage");
                            backtostage.start();
                            try {
                                backtostage.join();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    continue;

                } else if (input.equals("c")){ // 포켓몬 센터
                    if (place_n==1 || place_n==3 || place_n==5){
                        System.out.println("메뉴 중에서 선택하세요.");
                        continue;
                    }
                    LoadingThread gotocenter = new LoadingThread("gotocenter");
                    gotocenter.start();
                    try {
                        gotocenter.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }



                    boolean isDone = false;
                    while (!isDone) {
                        for (int i=0;i<60;i++){
                            System.out.println();
                        }
                        System.out.println("==================포켓몬센터=================\n");
                        System.out.println("[z] 포켓몬 치료    [x] 포켓몬 교체     [q]나가기");
                        input = sc.next();
                        if (input.equals("z")) {//치료


                            pokemon.setHp(pokemon.getFullHp());
                            System.out.println("치료가 완료되었습니다.\n");
                            System.out.println("======================");
                            pokemon.printPokemon();
                            try {
                                Thread.sleep(3000);
                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        } else if (input.equals("x")) { //포켓몬교체

                            if (pokemonList.size() > 0) {//컴퓨터에 포켓몬이 있는경우
                                System.out.println("==포켓몬 목록==");
                                for (int i = 0; i < pokemonList.size(); i++) {
                                    System.out.println((i) + "번 : 레벨 " + pokemonList.get(i).getLevel() + "이름" + pokemonList.get(i).getName());
                                }
                                System.out.println("교체하시겠습니까? (y/n)");
                                boolean hasChosen2 = false;
                                while (!hasChosen2) {
                                    String input2 = sc.next();
                                    if (input2.equals("y")) { //교체를 할것
                                        hasChosen2 = true;
                                        boolean hasChosen3 = false;
                                        while (!hasChosen3) {
                                            System.out.println("교체할 포켓몬 번호를 고르십시오");
                                            try {
                                                int idx = sc.nextInt();
                                                Pokemon out = pokemonList.get(idx);

                                                List<Pokemon> pokeList1 = pokemonList.subList(0, idx);
                                                List<Pokemon> pokeList2 = pokemonList.subList(idx + 1, pokemonList.size());
                                                pokeList1.addAll(pokeList2);

                                                pokeList1.add(pokemon);
                                                pokemon = out;
                                                pokemonList = (ArrayList<Pokemon>) pokeList1;
                                                System.out.println("포켓몬을 변경했습니다.\n");
                                                hasChosen3 = true;
                                            } catch (Exception e) {
                                                System.out.println("0 ~ " + pokemonList.size() + "까지의 숫자를 입력하시오.");
                                            }
                                        }
                                    } else if (input2.equals("n")) {
                                        hasChosen2 = true;
                                    } else {
                                        System.out.println("y/n 중 고르시오.\n");
                                    }
                                }
                            } else {
                                System.out.println("포켓몬이 없습니다.\n");
                            }
                        } else if (input.equals("q")) {
                            isDone = true;
                            System.out.println("포켓몬센터를 나왔습니다.\n");
                            LoadingThread backtostage = new LoadingThread("backtostage");
                            backtostage.start();
                            try {
                                backtostage.join();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    continue;
                } else { // 선택지 중에 안골랐을 때
                    System.out.println("메뉴 중에서 선택하세요.");
                    continue;
                }
            }
        }






    }

    public void pause(){
        try {
            System.in.read();
        } catch (IOException e) { }
    }
}