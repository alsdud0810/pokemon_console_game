package Game.Pokemons;

public class Charizard extends Charmeleon {

    int weight; // 무게, 일정 체력 증가

    public Charizard(int level) {
        super(level);
        this.setName("리자몽");
        this.setLevel(level);;
        this.initializeHp(level);
        this.setSkill1(1);
        this.setSkill2(5);
        this.setSkill3(2);
        this.setSkill4(8);;
    }

    public void weighteffect(){
        weight=50;
        setHp(getHp()+weight);
        System.out.println("리자몽의 단단하고 거대한 몸은 체력을 증가시킵니다.");
        System.out.println("리자몽의 체력이 50 증가했습니다!");
    }


}