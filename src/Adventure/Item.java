package Adventure;

public class Item extends Items {
    String use;

    public Item(String name, String nameID, int weight, String use) {
        super(name, nameID, weight);
        this.use=use;
    }

    public String useItem(Game game){
        switch(super.getNameID()){
            case "rock":
                if(game.currentEnemy!=null){
                    game.currentEnemy.addHealth(-150);
                    return "You throw the rock and it does a lot of damage";
                } else {
                    return "nothing happens";
                }
            case "vitamin":
                game.player.addHealth(100);
                return "you feel the power surge through your body";
            default:
                return "nothing happens";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Item";
    }
}
