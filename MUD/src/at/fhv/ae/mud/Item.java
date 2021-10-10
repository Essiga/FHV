package at.fhv.ae.mud;

public class Item {

    protected String name;
    private String description;
    private boolean isEventActive;
    private Event event;


    public Item(String name) {
        isEventActive = false;
        this.name = name;
    }
    public Item(String name, String description){
        isEventActive = false;
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, Event event){
        isEventActive = true;
        this.name = name;
        this.description = description;
        this.event = event;
    }

    public boolean isEventActive() {
        return isEventActive;
    }

    public Event getEvent() {
        return event;
    }

    public String getName() {
        return name;
    }

    public void take(Player player){
        player.getCurrentCell().items.remove(this);
        player.getInventory().add(this);
    }

    public void equip(Player player){
        System.out.println("You cannot equip: " + name);
    }

    public void printInfo(){
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
    }

    public void use(Player player){
        System.out.println("You can't use that");
    }
}
