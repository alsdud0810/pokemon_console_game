package Game.Pokemons;

import javax.swing.plaf.synth.SynthLabelUI;
import java.util.Random;

public class Sandshrew extends Pokemon{

    int hardness=1; // 딱딱함, 죽기 전 방어력 증가(체력 증가)
    public Sandshrew(int level){
        this.setName("모래두지");
        this.setLevel(level);
        this.initializeHp(level);
        this.setSkill1(2);
        this.setSkill2(3);
    }

    public void hardnesseffect(){ // 광합성 효과
        if (hardness>0){
            if(getHp()<=10 && getHp()>=0) {
                setHp(getHp() + 5);
                System.out.println("\n"+getName()+"는 강철같은 몸으로 몸을 보호했습니다.");
                System.out.println(getName()+"의 체력이 5hp 회복되었습니다.");
                hardness = 0;
            }
        }
    }

    @Override
    public int attack(Pokemon target){//공격하기
        hardnesseffect();
        int damage;
        Random random = new Random();

        int skillRandomIndex = random.nextInt(2)+1;
//        Skill wildSkill = wildSkills.get(skillRandomIndex);
//        int wildDamage = wildSkill.skilldamage*wildPokemon.getLevel()/20;
        if (skillRandomIndex==1){
            damage=getSkill1().skilldamage+getLevel()/20;
        } else {
            damage=getSkill2().skilldamage+getLevel()/20;
        }
        return damage;
    }
}