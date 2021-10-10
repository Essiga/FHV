package at.fhv.ae.mud;

import java.util.Scanner;

public class Event {
    private String name;
    private String story;
    private String solution;
    private String success;
    private String failure;


    public Event(String name, String story, String solution, String success, String failure) {
        this.name = name;
        this.story = story;
        this.solution = solution;
        this.success = success;
        this.failure = failure;

    }

    public boolean play(){
        Scanner sc = new Scanner(System.in);
        System.out.println(story);
        String answer = sc.nextLine();

        if(answer.equals(solution)){
            System.out.println(success);
            return true;
        }
        else {
            System.out.println(failure);
            return false;
        }

    }
}
