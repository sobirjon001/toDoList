import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
//
 // add new task
 // delete task
 // mark ✔ this task is done or not
 // show all tasks is done
 // show all task is not done

    // i will use different methods, instances , custom class todoList





    static class ToDoList{

        String task ;

        boolean isDone = false;

        public ToDoList(String task ){ // it s constructor, it is like setInfo
            this.task = task;
        }

        public void toggleDone(){ // this is the method
            this.isDone = !isDone; // change to opposite value to true or false
        }

        public String toString() {
            return ( isDone ? " [✔] " : " [ ] " ) + task ;
        }

    }


    static Scanner s = new Scanner(System.in);
    static ArrayList<ToDoList> tasks = new ArrayList<>();

    static public void menu(){

        for (int i = 0; i < tasks.size(); i++){
            System.out.println( i + " - " + tasks.get(i) );
        }

        System.out.println("Please choose your action: \n[1] - add new task\n[2] - delete task");
        System.out.println("[3] - mark ✔ this task is done or not ");
        System.out.println("[4] - show all tasks is done ");
        System.out.println("[5] - show all tasks is not done ");

        int number = s.nextInt();

        switch (number){

            case 1:
                createTask();
                break;

            case  2:
                deleteTask();
                break;
            case  3:
                markTask();
                break;
            case  4:
                showAllDone();
                break;
            case  5:
                showAllNotDone();
                break;

            default:
                System.out.println("Invalid entry \nPress enter to try again");
                s.nextLine();
                menu();


        }





    }

    static public void createTask(){
        System.out.println("Please enter your task: ");
        s.nextLine();
       String input = s.nextLine();

       tasks.add( new ToDoList(input) );

       menu();
    }

   static public void deleteTask(){
        System.out.println("Which one to delete ?");

        for (int i = 0; i < tasks.size(); i++){
            System.out.println( i + " - " + tasks.get(i) );
        }

        int x = s.nextInt();
        if (x>=tasks.size()){
            System.out.println("Please enter a valid task number");
            x = s.nextInt();
        }

        tasks.remove(x);

        menu();

    }

    static public void markTask(){
        System.out.println("Which one to mark ?");

        for (int i = 0; i < tasks.size(); i++){
            System.out.println( i + " - " + tasks.get(i) );
        }

        int n = s.nextInt();
        if (n>=tasks.size()){
            System.out.println("Please enter a valid task number");
            n = s.nextInt();
        }

        tasks.get(n).toggleDone();

        menu();
    }

    static public void showAllDone(){

        for (int i = 0; i< tasks.size(); i++){
            if ( tasks.get(i).isDone ){
                System.out.println( i + " - " + tasks.get(i) );
            }

        }

        s.nextLine();
        System.out.println("Press enter to go to menu");
        s.nextLine();
        menu();
    }

    static public void showAllNotDone(){
        for (int i = 0; i< tasks.size(); i++){
            if ( !(tasks.get(i).isDone) ){
                System.out.println( i + " - " + tasks.get(i) );
            }

        }

        s.nextLine();
        System.out.println("Press enter to go to menu");
        s.nextLine();
        menu();

    }



}
