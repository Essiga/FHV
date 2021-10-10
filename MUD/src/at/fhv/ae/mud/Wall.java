package at.fhv.ae.mud;

import java.util.LinkedList;

public class Wall extends Cell {

//    private String name;
//    private String description;
    private Cell[] adjacentCells = new Cell[1];
    private LinkedList<Player> playersInCell;

    public Wall() {
        name = "Wall";
        shortDescription = "You see a grey brick wall.";
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void enter(Player player) {
        System.out.println("You walked against a wall.");
    }
}
