package Game.Pokemons;

public class Squirtle extends Pokemon{
    public Squirtle(int level){
        this.setName("꼬부기");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(6);
    }
}
