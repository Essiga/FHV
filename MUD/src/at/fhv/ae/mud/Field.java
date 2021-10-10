package at.fhv.ae.mud;

import java.util.LinkedList;



public class Field extends Cell {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    private int id;
    private Cell[] adjacentCells = new Cell[4]; //pos: 0 = N, 1 = E, 2 = S, 3 = W


    @Override
    public String getName() {
        return name;
    }

    public Field(int id) {
        shortDescription = "nothing interesting here";
        longDescription = "nothing interesting here";
        this.id = id;
    }

    @Override
    public void printLongDescription() {
        System.out.println();
        System.out.println("Field: " + name);
        System.out.println("Description: " + longDescription);
        System.out.println();
        System.out.println(ANSI_YELLOW+"Directions:"+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"North: " + adjacentCells[0].getName()+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"East: " + adjacentCells[1].getName()+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"South: " + adjacentCells[2].getName()+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"West: " + adjacentCells[3].getName()+ANSI_RESET);

        for (Item item : items) {
            System.out.println(ANSI_BLUE+"Item: " + item.getName()+ANSI_RESET);
        }

        for (Player player : playersInCell) {
            System.out.println(ANSI_PURPLE+"Player: " + player.getName()+ANSI_RESET);
        }
    }

    public Field(int id, String name, String shortDescription, String longDescription) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
    }

    public void addPlayer(Player player) {
        playersInCell.add(player);
    }

    public void setAdjacentCell(Direction dir, Cell adjacentCell) {
        this.adjacentCells[dir.ordinal()] = adjacentCell;
    }

    public Cell getNeighbour(Direction dir) {
        return adjacentCells[dir.ordinal()];
    }

    public void enter(Player player) {
        player.getCurrentCell().leave(player);
        playersInCell.add(player);
        player.setCurrentCell(this);
        System.out.println();
        System.out.println("Field: " + name);
        System.out.println("Description: " + shortDescription);
    }


    public void leave(Player player) {
        playersInCell.remove(player);
    }


}
