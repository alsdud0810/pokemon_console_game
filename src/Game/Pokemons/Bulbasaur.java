package Game.Pokemons;


import java.util.Random;

public class Bulbasaur extends Pokemon{

    int photosynthesis=1; // 광합성, 이상해씨는 광합성을 통해 일정 hp를 회복한다, 광합성 사용 가능 횟수
    public Bulbasaur(int level){
        this.setName("이상해씨");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(7);
    }

    public void photoeffect(){ // 광합성 효과
        if (photosynthesis>0){
            if(getHp()<=10 && getHp()>=0){
                setHp(getHp()+10);
                System.out.println("\n"+getName()+"의 광합성 효과: 10hp 회복");
                photosynthesis=0;
            }
        }
    }

    @Override
    public int attack(Pokemon target){//공격하기
        photoeffect();
        int damage;
        Random random = new Random();
        int skillRandomIndex = random.nextInt(2)+1;
        if (skillRandomIndex==1){
            damage=getSkill1().skilldamage+getLevel()/20;
        } else {
            damage=getSkill2().skilldamage+getLevel()/20;
        }
        return damage;
    }
}
