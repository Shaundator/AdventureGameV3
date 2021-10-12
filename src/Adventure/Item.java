package Adventure;

public class Item extends Items {
    String use;

    public Item(String name, String nameID, int weight, String use) {
        super(name, nameID, weight);
        this.use=use;
    }

    @Override
    public String useItem(Game game) {
        if(getNameID().equalsIgnoreCase("rock")){
            if(game.currentEnemy!=null) {
                game.currentEnemy.addHealth(-100);
            }
        }
        if(getNameID().equalsIgnoreCase("key")){
            game.map.defeatAunt();
        }
        if(getNameID().equalsIgnoreCase("hero")){
            game.map.officer.setWeapon(game.map.peacefulBaton);
            game.map.officer.setHealth(200);
        }
        if(getNameID().equalsIgnoreCase("vitamin")){
            game.player.addHealth(100);
        }
        if(getNameID().equalsIgnoreCase("justice")){
            if(game.currentEnemy==game.map.drugDealer) {
                game.map.drugDealer.setHealth(10);
            }
        }
        if(getNameID().equalsIgnoreCase("excuse")){
            if(game.currentEnemy==game.map.aunt){
                game.map.aunt.setWeapon(game.map.meanWords);
                game.map.aunt.setHealth(100);
            }
        }
        return use;
    }

    @Override
    public boolean checkValid() {
        return false;
    }

    @Override
    public int consumeFood() {
        return 0;
    }

    @Override
    public void useWeapon() {
    }
    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public boolean useCheck() {
        return true;
    }
    @Override
    public boolean foodCheck() {
        return false;
    }
    @Override
    public boolean weaponCheck() {
        return false;
    }

    @Override
    public String toString() {
        return "Type: Item" +
                "\nUse: Mystery";
    }
}
