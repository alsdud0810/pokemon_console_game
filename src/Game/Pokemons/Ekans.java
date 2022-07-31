package Game.Pokemons;

import Game.Skill;

import java.util.Random;

public class Ekans extends Pokemon{
    public int poison; // 독데미지, 공격마다 poison만큼 데미지 추가.
    public Ekans(int level){
        this.setName("아보");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(3);
        this.poison=5;
    }

    @Override
    public int attack(Pokemon target){//공격하기
        int damage;
        Random random = new Random();
        poison=random.nextInt(5)+1;
        System.out.println("\n"+getName()+"의 독으로 "+poison+"만큼 추가 데미지가 적용됩니다.");
        int skillRandomIndex = random.nextInt(2)+1;

        if (skillRandomIndex==1){
            damage=getSkill1().skilldamage+getLevel()/20+poison;
        } else {
            damage=getSkill2().skilldamage+getLevel()/20+poison;
        }
        return damage;
    }

}