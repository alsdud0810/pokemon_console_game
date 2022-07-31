package Game;

public class Skill {
    public String skillname;
    public int skillNum;
    public int skilldamage;

    public Skill(int skillNum){
        this.skillNum=skillNum;
        switch (skillNum){
            case 1: this.skillname = "할퀴기";
                this.skilldamage=40;
                break;
            case 2: this.skillname = "몸통박치기";
                this.skilldamage=40;
                break;
            case 3: this.skillname = "바람일으키기";
                this.skilldamage=40;
                break;
            case 4: this.skillname = "전기쇼크";
                this.skilldamage=40;
                break;
            case 5: this.skillname = "불꽃세례";
                this.skilldamage=50;
                break;
            case 6: this.skillname = "물대포";
                this.skilldamage=50;
                break;
            case 7: this.skillname = "덩쿨채찍";
                this.skilldamage=50;
                break;
            case 8: this.skillname = "전광석화";
                this.skilldamage=50;
                break;
            case 9: this.skillname = "독침";
                this.skilldamage=30;
                break;
            case 10: this.skillname = "김밥말이";
                this.skilldamage=30;
                break;
        }
    }
}
