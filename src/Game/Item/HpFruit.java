package Game.Item;

public class HpFruit extends item{
    public int PlusHp; //추가 회복 수치

    public HpFruit(String name, int price, int plusHp){
        super(name,price);
        this.PlusHp=PlusHp;
    }


}
