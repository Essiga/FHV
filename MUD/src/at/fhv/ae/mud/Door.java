package at.fhv.ae.mud;

import java.util.LinkedList;

public class Door extends Cell {

    //private String name;
    private boolean isLocked;
    private Key key;
    private final LinkedList<Field> adjacentCells = new LinkedList<Field>();

    public Door() {
        name = "Door";
        isLocked = false;
    }
    public Door(boolean isLocked, Key key){
        name = "Door";
        this.isLocked = isLocked;
        this.key = key;
    }

    @Override
    public String getName() {
        return name;
    }


    public LinkedList<Field> getAdjacentCellsList() {
        return adjacentCells;
    }

    public void addAdjacentCells(Field adjacentCell) {
        this.adjacentCells.addLast(adjacentCell);
    }

    //moves player to the opposite side of the door
    @Override
    public void enter(Player player) {
        if (canOpen(player)) {
            if (player.getCurrentCell() == adjacentCells.getFirst()) {

                adjacentCells.getLast().enter(player);
            } else {
                adjacentCells.getFirst().enter(player);
            }
        } else {
            System.out.println("The door is Locked you need to find a Key.");
        }
    }



    private boolean canOpen(Player player) {
        if (isLocked) {

            if (player.getInventory().contains(key)) {
                isLocked = false;
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
