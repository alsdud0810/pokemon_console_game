package Game.Pokemons;

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

}