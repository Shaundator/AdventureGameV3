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
                    game.player.getInventory().add(game.map.pedestrian_loot);
                    return "Not like you gonna get plus health for this";
                } else {
                    game.player.restoreHealth(50);
                    return "you feel the surge of vitality";
                }
            case "justice":
                if(game.currentEnemy==game.map.police_officer) {
                    ((Weapon) game.map.police_officer.getWeapon()).setDamage(5);
                    game.map.police_officer.setEnemyAttackLine("A fellow man of justice, mercy to you");
                    return "The Police Officer recognises you as a man of justice";
                } else {
                    game.player.getInventory().add(game.map.anti_officer);
                    return "You shout words of justice for no apparent reason, that would be a waste";
                }
            case "homekey":
                game.map.defeatAunt();
                return "You remember everything, your home was east of the park";
            case "antiaunt":
                if(game.currentEnemy==game.map.aunt) {
                    game.map.aunt.setHealth(1);
                    return "The repellent works, your aunt cringes at the spray";
                } else {
                    game.player.getInventory().add(game.map.anti_auntie);
                    return "That would be a waste wouldn't it?";
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
