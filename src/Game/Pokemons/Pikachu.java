package Game.Pokemons;

import java.util.Random;

public class Pikachu extends Pokemon {

    int electric; // 감전, 상대 공격력 감소.
    public Pikachu(int level){
        this.setName("피카츄");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(4);
        this.setSkill2(8);
    }

    @Override
    public int attack(Pokemon target){//공격하기
        int damage;
        Random random = new Random();

        electric=random.nextInt(5)+1;
        target.getSkill1().skilldamage-=electric;
        target.getSkill2().skilldamage-=electric;

        int skillRandomIndex = random.nextInt(2)+1;

        if (skillRandomIndex==1){
            damage=getSkill1().skilldamage+getLevel()/20;
        } else {
            damage=getSkill2().skilldamage+getLevel()/20;
        }
        return damage;
    }

}
