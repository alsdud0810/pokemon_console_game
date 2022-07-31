package Game.Pokemons;

public class Pikachu extends Pokemon {

    int electric=2; // 감전, 공격 이어서 한 번 더., 연속 공격 가능 횟수
    public Pikachu(int level){
        this.setName("피카츄");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(4);
        this.setSkill2(8);
    }

}
