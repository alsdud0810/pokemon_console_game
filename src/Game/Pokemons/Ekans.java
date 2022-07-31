package Game.Pokemons;

import Game.Skill;

public class Ekans extends Pokemon{
    public int poison; // 독데미지, 5~10으로 지정하기, 메인에서 아보 만나면 공격마다 poison만큼 데미지 추가.
    public Ekans(int level){
        this.setName("아보");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(3);
    }

}