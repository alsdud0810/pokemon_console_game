package Game.Pokemons;

public class Oddish extends Pokemon{

    int peace; //평화, 내 데미지 감소, 메인에서 hp에 +10해주자.
    public Oddish(int level){
        this.setName("뚜벅쵸");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(3);
    }
}