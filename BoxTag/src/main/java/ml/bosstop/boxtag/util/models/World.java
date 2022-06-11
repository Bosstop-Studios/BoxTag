package ml.bosstop.boxtag.util.models;

public class World {
    private String id;
    private int coins ;
    public World(String name) {
        this.id = name;
    }

    public String getId() {
        return id;
    }

    public void setCoins(int amount) {
        this.coins = amount;
    }

    public int getCoins() {
        return coins;
    }

}
