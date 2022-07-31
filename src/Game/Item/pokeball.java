package Game.Item;

public class pokeball extends item{
    public double CaptureProbability;

    public pokeball(String name, int price, double CaptureProbability){
        super(name, price);
        this.CaptureProbability=CaptureProbability;
    }
}
