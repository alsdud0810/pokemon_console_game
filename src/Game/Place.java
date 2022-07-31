package Game;

public class Place {
    int placenum;
    String placename;

    void setPlacename(String placename){this.placename=placename;}

    Place (int placenum, String placename){
        placenum = this.placenum;
        placename = this.placename;
    }

    String getPlacename(){
        return placename;
    }
}
