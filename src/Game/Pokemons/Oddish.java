package Game.Pokemons;

import java.util.Random;

public class Oddish extends Pokemon{

    int peace; //평화, 상대 데미지 감소.
    public Oddish(int level){
        this.setName("뚜벅쵸");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(3);
    }

    @Override
    public int attack(Pokemon target){//공격하기
        int damage;
        Random random = new Random();
        peace=random.nextInt(5)+1;
        target.getSkill1().skilldamage-=peace;
        target.getSkill2().skilldamage-=peace;
        System.out.println("\n"+getName()+"의 평화로움으로 상대의 데미지가 감소합니다.");
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