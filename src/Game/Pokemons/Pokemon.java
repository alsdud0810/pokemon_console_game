package Game.Pokemons;

import Game.Skill;

public class Pokemon{
    private String name;
    private int level;
    private int exp;
    private int fullHp;
    private int hp;
    private Skill skill1;
    private Skill skill2;

    void setName(String name){this.name = name;}
    public void setLevel(int level){this.level = level;}
    public void setExp(int exp){this.exp=exp;}
    public void setHp(int hp){this.hp=hp;}
    public void setFullHp(int fullHp){this.fullHp=fullHp;}
    void setSkill1(int skillNum){this.skill1=new Skill(skillNum);}
    void setSkill2(int skillNum){this.skill2 = new Skill(skillNum);}

    public String getName(){return name;}
    public int getLevel(){return level;}
    public int getExp(){return exp;}
    public int getHp(){return hp;}
    public int getFullHp(){return fullHp;}
    public Skill getSkill1(){return skill1;}
    public Skill getSkill2(){return skill2;}

    private Skill skill3;
    private Skill skill4;
    void setSkill3(int skillNum){this.skill3=new Skill(skillNum);}
    void setSkill4(int skillNum){this.skill4 = new Skill(skillNum);}
    public Skill getSkill3(){return skill3;}
    public Skill getSkill4(){return skill4;}


    void initializeHp(int level){
        int maxHp=level*10;
        int minHp=level*5;
        this.fullHp = minHp + (int)(Math.random()*(maxHp-minHp));
        this.hp=this.fullHp;
    }
    public void printPokemon(){

        System.out.println("포켓몬 : "+this.name);
        System.out.println("레벨 : "+this.level);
        System.out.println("경험치 : "+this.exp);
        System.out.println("체력 : "+this.hp+" / "+this.fullHp);
        System.out.println("기술 : "+this.skill1.skillname+" "+this.skill2.skillname);
        System.out.println("======================\n");
    }
    public void printWildPokemon() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t======================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  포켓몬 : " + this.name);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  레벨 : " + this.level);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  체력 : " + this.hp+" / "+this.fullHp);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t======================\n");
    }

    public boolean isLevelUp(Pokemon pokemon){
        if(pokemon.getLevel()==5){
            if (pokemon.getExp()>=10){
                return true;
            }
        } else if (pokemon.getLevel() == 6){
            if (pokemon.getExp()>=30){
                return true;
            }
        } else if (pokemon.getLevel() == 7){
            if (pokemon.getExp()>=60){
                return true;
            }
        } else if (pokemon.getLevel() == 8){
            if (pokemon.getExp()>=100){
                return true;
            }
        } else if (pokemon.getLevel() == 9){
            if (pokemon.getExp()>=150){
                return true;
            }
        }return false;
    }

    public int attack(Pokemon target){//공격하기
        return getSkill1().skilldamage;
    }


}








