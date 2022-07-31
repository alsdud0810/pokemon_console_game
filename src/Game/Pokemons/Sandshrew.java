package Game.Pokemons;

public class Sandshrew extends Pokemon{

    int hardness; // 딱딱함, 첫 번째 공격 방어. or 방어력 증가(체력 증가)
    public Sandshrew(int level){
        this.setName("모래두지");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(3);
    }
}