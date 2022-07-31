package Game.Pokemons;

import java.util.Random;

public class Charmeleon extends Charmander {

    int heat; // 리자드 꼬리의 열기, 추가 데미지
    public Charmeleon(int level) {
        super(level);
        this.setName("리자드");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(1);
        this.setSkill2(5);
        this.setSkill3(2);
    }

    public int attack(Pokemon target){//공격하기

        int damage;
        Random random = new Random();
        heat=random.nextInt(10)+5;
        System.out.println("\n"+getName()+" 꼬리의 열기로 "+heat+"만큼 추가 데이지가 적용됩니다.");

        int skillRandomIndex = random.nextInt(2)+1;

        if (skillRandomIndex==1){
            damage=getSkill1().skilldamage+getLevel()/20;
        } else {
            damage=getSkill2().skilldamage+getLevel()/20;
        }
        return damage;
    }

}