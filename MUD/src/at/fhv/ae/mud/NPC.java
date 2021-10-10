package at.fhv.ae.mud;

public class NPC extends Player{
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";



    private String dialogue;
    private String description;

    public NPC(String name, Field currentCell) {
        super(name, currentCell);
    }
    public NPC(String name, Field currentCell, String dialogue) {
        super(name, currentCell);
        this.dialogue = dialogue;
    }
    
    public void takeDamage(int damage){
        hitPoints = hitPoints - damage;
        if(hitPoints < 0){
            hitPoints = 0;
            die();
            System.out.println(ANSI_RED + name + " falls lifeless to the ground."+ANSI_RESET);
        }
    }

    public void die(){
          for(Item item : inventory){
            currentCell.getItems().add(item);
          }
          currentCell.getPlayersInCell().remove(this);
    }

    public void printDialogue() {
          System.out.println(name + ": '"+dialogue+"'");
    }
}
