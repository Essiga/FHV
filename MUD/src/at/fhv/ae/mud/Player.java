package at.fhv.ae.mud;

import java.util.LinkedList;
import java.util.Random;

public class Player {
    protected String name;
    protected int hitPoints;
    protected LinkedList<Item> inventory = new LinkedList<Item>();
    private Weapon weapon;
    private Armor armor;
    protected Field currentCell;

    public Player(String name, Field currentCell) {
        Weapon fists = new Weapon("Fists");
        fists.setAttackDamage(1);
        fists.setAttackModifier(5);
        Armor none = new Armor("None");
        none.setArmorClass(0);
        this.armor = none;
        this.weapon = fists;
        this.name = name;
        this.currentCell = currentCell;
        hitPoints = 100;
    }

    public LinkedList<Item> getInventory() {
        return inventory;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public Field getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Field currentCell) {
        this.currentCell = currentCell;
    }


    public String getName() {
        return name;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    public void equipArmor(Armor armor) {
        this.armor = armor;
    }
    public void addToInventory(Item item){
        inventory.add(item);
    }

    public void move(Direction dir){
        currentCell.getNeighbour(dir).enter(this);
    }
    public void equip(String itemName){
        boolean itemFound = false;
        if(currentCell.getItems() != null) {
            for (Item item : inventory) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    itemFound = true;
                    item.equip(this);
                }
            }
            if(itemFound == false){
                System.out.println("No item called: " + itemName);
            }
        }
    }

    public void take(String itemName){
        boolean itemFound = false;
        LinkedList<Item> itemsToRemoveFromCell = new LinkedList<>();
        if(currentCell.getItems() != null){
            for(Item item : currentCell.getItems()){
                if(item.getName().equalsIgnoreCase(itemName)){
                    itemFound = true;
                    if(item.isEventActive() == true){
                        if(item.getEvent().play()){
                            item.take(this);
                            System.out.println(itemName + " added to your Inventory.");
                        }
                    }
                    else{
                        item.take(this);
                        System.out.println(itemName + " added to your Inventory.");
                    }

                }
            }

        }
        if(itemFound == false){
            System.out.println("No item called " + itemName + " in this room.");
        }
    }


    public void listInventory(){
        System.out.println("Inventory:");
        for(Item item : inventory){
            System.out.println(item.getName());
        }
        System.out.println("Weapon: " + weapon.getName() + " ( " + weapon.getAttackModifier() + " / " + weapon.getAttackDamage() + " )");
    }

    public void inspect(){
        currentCell.printLongDescription();
    }

    public void inspect(String name){
        boolean found = false;
        for(Player player : currentCell.getPlayersInCell()){
            if(player.getName().equalsIgnoreCase(name)){
                player.printInfo();
                found = true;
            }
        }
        for(Item item : inventory){
            if(item.getName().equalsIgnoreCase(name)){
                item.printInfo();
                found = true;
            }
        }
        if(found == false){
            System.out.println("No " + name + " found.");
        }
    }

    public void printInfo(){
        System.out.println("Name: "+name);
        System.out.println("Health: "+hitPoints);
        System.out.println("Weapon: "+weapon.getName());
        System.out.println("Armor: "+armor.getName());

    }

    public void takeDamage(int damage){
        hitPoints = hitPoints - damage;
        if(hitPoints < 0){
            hitPoints = 0;
        }
    }

    public void restoreHealth(int health){
        hitPoints = hitPoints + health;
        if(hitPoints > 100){
            hitPoints = 100;
        }
    }

    public void attack(String enemyName){
        Player enemy = null;
        boolean enemyFound = false;
        for(Player player : currentCell.getPlayersInCell()){
            if(player.getName().equalsIgnoreCase(enemyName)){
                enemy = player;
                enemyFound = true;
            }
        }

        if(enemyFound){
            Random rand = new Random();
            int toHit = rand.nextInt(19) + 1 + weapon.getAttackModifier();
            int damage = rand.nextInt(weapon.getAttackDamage())+1;

            if(toHit > enemy.getArmor().getArmorClass()){
                System.out.println(name + " dealt "+ damage + " damage to " + enemy.getName());
                enemy.takeDamage(damage);
            }
            else{
                System.out.println(name + " missed!");
            }
            if(enemy instanceof NPC && enemy.getHitPoints() > 0){
                enemy.attack(this.name);
            }
        }

    }
    public void printHitPoints(){
        System.out.println("Health: "+hitPoints + "/100.");
    }

    public void use(String itemName){
        for(Item item : inventory){
            if(item.getName().equalsIgnoreCase(itemName)){
                item.use(this);
                break;
            }
        }

    }

    public void talk(String name){
        for(Player player : currentCell.getPlayersInCell()){
            if(player.getName().equalsIgnoreCase(name) && player instanceof NPC){
                ((NPC) player).printDialogue();
            }
        }
    }
}
