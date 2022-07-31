package Game.Pokemons;

import java.util.Random;

public class Charizard extends Charmeleon {

    int weight; // 위협, 상대 데미지 감소

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

    @Override
    public int attack(Pokemon target){//공격하기

        System.out.println("\n"+getName()+"의 단단하고 거대한 몸집은 위협을 줍니다.");
        System.out.println(target.getName()+"의 공격 데미지를 감소시킵니다.");

        Random random = new Random();
        weight=random.nextInt(5)+1;
        target.getSkill1().skilldamage-=weight;
        target.getSkill2().skilldamage-=weight;

        int damage;
        int skillRandomIndex = random.nextInt(4)+1;
        if (skillRandomIndex==1){
            damage=getSkill1().skilldamage+getLevel()/20;
        } else if(skillRandomIndex==2){
            damage=getSkill2().skilldamage+getLevel()/20;
        } else if(skillRandomIndex==3){
            damage=getSkill3().skilldamage+getLevel()/20;
        } else {
            damage=getSkill4().skilldamage+getLevel()/20;
        }
        return damage;
    }


}