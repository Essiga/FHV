package at.fhv.ae.mud;

public class Food extends Item{


    private int healingAmount;


    public Food(String name, int healingAmount){
        super(name);
        this.healingAmount = healingAmount;

    }

    public Food(String name, String description, int healingAmount){
        super(name, description);
        this.healingAmount = healingAmount;

    }
    public Food(String name, String description, Event event, int healingAmount){
        super(name, description, event);
        this.healingAmount = healingAmount;

    }

    @Override
    public void use(Player player){
        player.restoreHealth(healingAmount);
        player.getInventory().remove(this);
        System.out.println(name + " consumed.");
    }
}
