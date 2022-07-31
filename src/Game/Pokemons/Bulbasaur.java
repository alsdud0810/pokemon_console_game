package Game.Pokemons;

public class Bulbasaur extends Pokemon{

    int photosynthesis; // 광합성, 이상해씨는 광합성을 통해 일정 hp를 회복한다, 회복 hp 수치
    public Bulbasaur(int level){
        this.setName("이상해씨");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(7);
    }

    public void photoeffect(){ // 광합성 효과
        if(getHp()<=10){
            setHp(getHp()+10);
        }
        System.out.println("이상해씨의 광합성 효과: 10hp 회복");
    }
}
