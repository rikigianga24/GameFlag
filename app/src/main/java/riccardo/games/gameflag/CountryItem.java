package riccardo.games.gameflag;

public class CountryItem {
    private String name;
    private int image;

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public CountryItem(String name, int image){
        this.name=name;
        this.image=image;
    }
}
