package at.fhv.ae.mud;

import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void play(){
        //initialize map
        Field startingField = new Field(0, "Prison Cell", "A prison cell.",
                "a dark and dusty prison cell. The only bit of light comes through cracks of the door.");

        Key prisonKey = new Key("Prison Key", "A rusty old Key.");
        Door prisonDoor = new Door(true, prisonKey);
        Weapon rustyDagger = new Weapon("Rusty Dagger");
        rustyDagger.setAttackModifier(8);
        rustyDagger.setAttackDamage(4);

        startingField.addItem(prisonKey);
        startingField.addItem(rustyDagger);

        startingField.setAdjacentCell(Direction.NORTH, new Wall());
        startingField.setAdjacentCell(Direction.EAST, prisonDoor);
        startingField.setAdjacentCell(Direction.SOUTH, new Wall());
        startingField.setAdjacentCell(Direction.WEST, new Wall());

        Field courtYard = new Field(1, "Courtyard", "A courtyard with a couple of small bushes.",
                "A courtyard with a couple of small bushes. The sun is shining and a smell of smoke is in the air.");
        Field wood = new Field(4, "Woods", "A forested area",
                "You see a lush forest with lots of foliage around you. In the middle of the forest you find a sword that seems to be stuck in a stone.");


        prisonDoor.addAdjacentCells(startingField);
        prisonDoor.addAdjacentCells(courtYard);

        Field campingPlace = new Field(2, "Camping Place", "You see a small camp.",
                "You see a small camp, the fire looks like it was just put out. It's still smoking.");
        courtYard.setAdjacentCell(Direction.NORTH, new Wall());
        courtYard.setAdjacentCell(Direction.EAST, campingPlace);
        courtYard.setAdjacentCell(Direction.SOUTH, wood);
        courtYard.setAdjacentCell(Direction.WEST, prisonDoor);





        Field tent = new Field(3, "Tent", "A big well lit tent",
                "You see a big well lit tent, with a couple of bedrolls on the floor and some dice on a table.");
        tent.setAdjacentCell(Direction.NORTH, new Wall());
        tent.setAdjacentCell(Direction.EAST, new Wall());
        tent.setAdjacentCell(Direction.SOUTH, new Wall());
        tent.setAdjacentCell(Direction.WEST, campingPlace);

        campingPlace.setAdjacentCell(Direction.NORTH, new Wall());
        campingPlace.setAdjacentCell(Direction.EAST, tent);
        campingPlace.setAdjacentCell(Direction.SOUTH, new Wall());
        campingPlace.setAdjacentCell(Direction.WEST, courtYard);

        Weapon swordOfKas = new Weapon("Sword of Kas", "A blueish-green sword forged out of Mithril");

        swordOfKas.setAttackModifier(5);
        swordOfKas.setAttackDamage(12);

        Armor robeOfArchmage = new Armor("Robe of the Archmage", "A powerful enchanted robe");
        robeOfArchmage.setArmorClass(20);

        NPC enemy = new NPC("Vecna", tent, "Oh, you have managed to escape from the prison? But you won't be able to defeat me!");

        tent.addPlayer(enemy);
        enemy.equipWeapon(swordOfKas);
        enemy.equipArmor(robeOfArchmage);
        enemy.addToInventory(swordOfKas);
        enemy.addToInventory(robeOfArchmage);

        Event swordInStoneEvent = new Event("Sword in Stone",
                "As you reach for the sword with your hand, you hear a voice in your head: 'What is the answer to life the universe and everything?'",
                "42", "Effortlessly you lift the sword with the stone still attached to it.", "The Sword doesn't move.");

        Weapon sword = new Weapon("Sword in Stone", "A sword with a stone attached to it.", swordInStoneEvent);


        sword.setAttackModifier(15);
        sword.setAttackDamage(20);
        wood.addItem(sword);
        wood.setAdjacentCell(Direction.NORTH, courtYard);
        wood.setAdjacentCell(Direction.EAST, new Wall());
        wood.setAdjacentCell(Direction.SOUTH, new Wall());
        wood.setAdjacentCell(Direction.WEST, new Wall());

        Food healingPotion = new Food("Potion of Healing", 20);
        tent.addItem(healingPotion);


        LinkedList<Cell> map = new LinkedList<Cell>();
        map.add(startingField);
        map.add(courtYard);
        map.add(campingPlace);
        map.add(tent);
        map.add(wood);

        printMap(map);




        Scanner sc = new Scanner(System.in);

        System.out.println(ANSI_PURPLE + "     ##### ##                   ##                              ###     " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "  ######  /### /                 ##                         #    ###    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + " /#   /  / ###/                  ##                        ###    ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "/    /  /   ##                   ##                         #     ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "    /  /                         ##                               ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "   ## ##       ###  /###     ### ##    /###   ###  /###   ###     ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "   ## ##        ###/ #### / ######### / ###  / ###/ #### / ###    ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "   ## ######     ##   ###/ ##   #### /   ###/   ##   ###/   ##    ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "   ## #####      ##    ##  ##    ## ##    ##    ##          ##    ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "   ## ##         ##    ##  ##    ## ##    ##    ##          ##    ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "   #  ##         ##    ##  ##    ## ##    ##    ##          ##    ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "      /          ##    ##  ##    ## ##    ##    ##          ##    ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "  /##/         / ##    ##  ##    /# ##    ##    ##          ##    ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + " /  ##########/  ###   ###  ####/    ######     ###         ### / ### / " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "/     ######      ###   ###  ###      ####       ###         ##/   ##/  " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "#                                                                       " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + " ##                                                                    " + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_PURPLE + "          #####   ##    ##       ##### /    ##        ##### ##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "       ######  /#### #####    ######  /  #####     /#####  /##    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "      /#   /  /  ##### ##### /#   /  /     ##### //    /  / ###   " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "     /    /  /   # ##  # ## /    /  ##     # ## /     /  /   ###  " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "         /  /    #     #        /  ###     #         /  /     ### " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "        ## ##    #     #       ##   ##     #        ## ##      ## " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "        ## ##    #     #       ##   ##     #        ## ##      ## " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "        ## ##    #     #       ##   ##     #        ## ##      ## " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "        ## ##    #     #       ##   ##     #        ## ##      ## " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "        ## ##    #     ##      ##   ##     #        ## ##      ## " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "        #  ##    #     ##       ##  ##     #        #  ##      ## " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "           /     #      ##       ## #      #           /       /  " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "       /##/      #      ##        ###      /      /###/       /   " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "      /  #####           ##        #######/      /   ########/    " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "     /     ##                        ####       /       ####      " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "     #                                          #                 " + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "      ##                                         ##               " + ANSI_RESET);

        System.out.println();
        System.out.println(ANSI_CYAN+"################################################################################################################################################");
        System.out.println("Commands:");
        System.out.println("<> = required, [] = optional, / = or");
        System.out.println("move <north/east/south/west>                Move in different Directions");
        System.out.println("inspect [item_name/player_name]             Get detailed information about a Room, Player, or Item.");
        System.out.println("                                            If no parameter is specified, the current room will be inspected");
        System.out.println("take <item_name>                            Pickup item");
        System.out.println("use <item_name>                             Uses an Item");
        System.out.println("inventory                                   Lists all the items in your Inventory and your equipped weapon");
        System.out.println("equip <item_name>                           Equips weapons");
        System.out.println("health                                      Shows your current health");
        System.out.println("attack <player_name>                        Attacking another Player or NPC. Attackdamage and hitchance are determined by the equipped weapon");
        System.out.println();
        System.out.println("################################################################################################################################################"+ANSI_RESET);

        System.out.println();
        System.out.println();
        System.out.println(ANSI_GREEN + "Welcome traveller, how doth thou want to be called?" + ANSI_RESET);
        System.out.print("Name: ");
        String playerName = sc.nextLine();

        Player currentPlayer = new Player(playerName, startingField);

        LinkedList<Player> playerList = new LinkedList<Player>();
        playerList.add(currentPlayer);

        System.out.println(ANSI_GREEN + "You wake up in a prison cell not knowing how you got here, what do you wish to do?" + ANSI_RESET);

        while(currentPlayer.getHitPoints()>0) {
            String command = sc.nextLine();
            String[] commands = command.split(" ", 2);

            if (commands[0].equalsIgnoreCase("inspect")) {
                if(commands.length == 1){
                    currentPlayer.inspect();
                }
                else{
                    currentPlayer.inspect(commands[1]);
                }

            } else if (commands[0].equalsIgnoreCase("take")) {
                String itemName = commands[1];
                currentPlayer.take(itemName);
            } else if (commands[0].equalsIgnoreCase("move")) {
                String directionName = commands[1];
                switch (directionName) {
                    case "north":
                        currentPlayer.move(Direction.NORTH);
                        break;
                    case "east":
                        currentPlayer.move(Direction.EAST);
                        break;
                    case "south":
                        currentPlayer.move(Direction.SOUTH);
                        break;
                    case "west":
                        currentPlayer.move(Direction.WEST);
                        break;
                    default:
                        System.out.println(directionName + " is not a valid direction");
                }

            }
            else if(commands[0].equalsIgnoreCase("attack")){
                String enemyName = commands[1];
                currentPlayer.attack(enemyName);


            }
            else if(commands[0].equalsIgnoreCase("use")){
                String itemName = commands[1];

                currentPlayer.use(itemName);

            }
            else if(commands[0].equalsIgnoreCase("inventory")){
                currentPlayer.listInventory();

            }
            else if(commands[0].equalsIgnoreCase("health")) {
                currentPlayer.printHitPoints();
            }
            else if(commands[0].equalsIgnoreCase("equip")) {
                String itemName = commands[1];
                currentPlayer.equip(itemName);
            }
            else if(commands[0].equalsIgnoreCase("talk")) {
                String npcName = commands[1];
                currentPlayer.talk(npcName);
            }
            else if(commands[0].equalsIgnoreCase("logout")) {
                boolean playerFound = false;
                System.out.println(ANSI_GREEN + "Welcome traveller, how doth thou want to be called?" + ANSI_RESET);
                playerName = sc.nextLine();
                for (Player player : playerList){
                    if(player.getName().equalsIgnoreCase(playerName)){
                        currentPlayer = player;
                        playerFound = true;
                    }
                }
                if(playerFound == false){
                    playerList.addLast(new Player(playerName, startingField));
                    currentPlayer = playerList.getLast();
                }

            }
            else{
                System.out.println(command + " is not a valid command");
            }
        }
        System.out.println(ANSI_RED + "You fall to the ground as the light fades around you. You are dead." + ANSI_RESET);
    }

    public static void printMap(LinkedList<Cell> map){
        for(Cell cell : map){
            cell.printLongDescription();
            System.out.println("------------------------------------------------------------------------------------------");
        }
    }


}
