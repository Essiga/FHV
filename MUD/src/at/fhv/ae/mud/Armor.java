package at.fhv.ae.mud;

public class Armor extends Item{

    private int armorClass;

    public Armor(String name) {
        super(name);
    }

    public Armor(String name, String description) {
        super(name, description);
    }

    public Armor(String name, String description, Event event) {
        super(name, description, event);
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

}
