package at.fhv.ae.mud;

public class Weapon extends Item{

    private int attackDamage;
    private int attackModifier;

    public Weapon(String name) {
        super(name);
    }

    public Weapon(String name, String description){
        super(name, description);
    }

    public Weapon(String name, String description, Event event){
        super(name, description, event);
    }


    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getAttackModifier() {
        return attackModifier;
    }

    public void equip(Player player){
        System.out.println(name + " equipped.");
        player.setWeapon(this);
    }

    public void setAttackModifier(int attackModifier) {
        this.attackModifier = attackModifier;
    }

}
