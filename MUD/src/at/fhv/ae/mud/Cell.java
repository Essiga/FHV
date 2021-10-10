package at.fhv.ae.mud;

import java.util.LinkedList;

public abstract class Cell {
    protected String name;
    protected String shortDescription;
    protected String longDescription;
    private Cell[] adjacentCells;
    protected LinkedList<Player> playersInCell = new LinkedList<Player>();
    protected LinkedList<Item> items= new LinkedList<Item>();


    public abstract String getName();

    public LinkedList<Player> getPlayersInCell() {
        return playersInCell;
    }


    public void printLongDescription(){
        System.out.println("Field: " + name);
        System.out.println(longDescription);
    }

    public void addItem(Item item){
        items.addLast(item);
    }


    public LinkedList<Item> getItems() {
        return items;
    }

    public void printInfo(){
        System.out.println("Name: " +name);
        System.out.println("Description: " +longDescription);
    }

    public abstract void enter(Player player);



}
