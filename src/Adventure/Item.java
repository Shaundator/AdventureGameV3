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
            case "meds":
                if(game.player.getCurrentHealth()==game.player.getHealth()){
                    return "Not like you gonna get plus health for this";
                } else {
                    game.player.addHealth(50);
                    return "you feel the surge of vitality";
                }
            default:
                return "nothing happens";
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Item\nUsage: " + use;
    }
}
