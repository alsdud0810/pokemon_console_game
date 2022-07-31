
package Game.Pokemons;

import Game.Pokemons.Pokemon;
import Game.Skill;

import java.util.Random;

public class Charmander extends Pokemon {

    int burningsound; //타는 소리, 파이리는 꼬리에서 나는 타는 소리로 상대의 마음을 안정시킨다, 상대 공격 데미지 감소
    public Charmander(int level){
        this.setName("파이리");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(1);
        this.setSkill2(5);
    }

    @Override
    public int attack(Pokemon target){//공격하기
        Random random = new Random();
        burningsound=random.nextInt(3)+1;

        System.out.println("\n"+getName()+"의 꼬리에서 나는 장작 소리로 상대의 마음을 안정시킵니다.");
        System.out.println(target.getName()+"상대의 공격 데미지가 감소합니다.");

        target.getSkill1().skilldamage-=burningsound;
        target.getSkill2().skilldamage-=burningsound;

        int damage;

        int skillRandomIndex = random.nextInt(2)+1;
//        Skill wildSkill = wildSkills.get(skillRandomIndex);
//        int wildDamage = wildSkill.skilldamage*wildPokemon.getLevel()/20;
        if (skillRandomIndex==1){
            damage=getSkill1().skilldamage+getLevel()/20;
        } else {
            damage=getSkill2().skilldamage+getLevel()/20;
        }
        return damage;
    }


}
