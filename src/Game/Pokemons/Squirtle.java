package Game.Pokemons;

import java.util.Random;

public class Squirtle extends Pokemon{

    int friendliness=1; // 친근함으로 상대의 첫 번째 공격의 데미지 덜 받음ㄴ
    public Squirtle(int level){
        this.setName("꼬부기");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(6);
    }


    @Override
    public int attack(Pokemon target){//공격하기
        if (friendliness==1){
            if (getHp()<getFullHp()){
                setHp(getFullHp());
                System.out.println("\n"+getName()+"의 친근함으로 공격을 회피했습니다.");
                friendliness=0;
            }
        }

        int damage;
        Random random = new Random();

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
