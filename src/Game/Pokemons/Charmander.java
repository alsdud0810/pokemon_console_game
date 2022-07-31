
package Game.Pokemons;

import Game.Pokemons.Pokemon;
import Game.Skill;

public class Charmander extends Pokemon {

    int burningsound; //타는 소리, 파이리는 꼬리에서 나는 타는 소리로 상대의 마음을 안정시킨다, 상대 공격 데미지 감소, 회복량
    public Charmander(int level){
        this.setName("파이리");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(1);
        this.setSkill2(5);
    }

    public void burningeffect(){
        setHp(getHp()+5);
        System.out.println("파이리의 꼬리에서 나는 장작 소리로 상대의 마음을 안정시킵니다.");
        System.out.println("상대의 공격 데미지가 감소합니다.");
    }

}
