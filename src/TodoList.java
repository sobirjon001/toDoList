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

        String task ; // instance , every new object will have his own value

        boolean isDone = false;

        public ToDoList(String task ){ // it s constructor, it is like setInfo
            this.task = task;
        } // it is a constructor , works like a setInfo

        public void toggleDone(){ // this is the method
            this.isDone = !isDone; // changes to opposite value to true or false
        }

        public String toString() {
            return ( isDone ? " [✔] " : " [ ] " ) + task ;
        }

    }


    static Scanner s = new Scanner(System.in);
    static ArrayList<ToDoList> tasks = new ArrayList<>();

    static public void menu(){ // lets user to choose the action , that he want

        for (int i = 0; i < tasks.size(); i++){
            System.out.println( i + " - " + tasks.get(i) ); // represents each object of the ArrayList
        }

        System.out.println("Please choose your action: \n[1] - add new task\n[2] - delete task");
        System.out.println("[3] - mark ✔ this task is done or not ");
        System.out.println("[4] - show all tasks is done ");
        System.out.println("[5] - show all tasks is not done ");

        int number = s.nextInt();

        switch (number){ // we need switch statement to use our methods (which we created for our actions)

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
                s.nextLine();
                System.out.println("Invalid entry \nPress enter to try again");
                s.nextLine();
                menu();
        }
    }

    static public void createTask(){
        System.out.println("Please enter your task: ");
        s.nextLine(); // it will accept enter
       String input = s.nextLine();

       tasks.add( new ToDoList(input) ); // adding our input to ArrayList

       menu();
    }

   static public void deleteTask(){
        System.out.println("Which one to delete ?");

        for (int i = 0; i < tasks.size(); i++){
            System.out.println( i + " - " + tasks.get(i) );
        }

        int x = s.nextInt();
        if (x>=tasks.size()){
            System.out.println("Please enter a valid task number"); //Enter this if statment
            x = s.nextInt();
        }

        tasks.remove(x);

        menu();

    }

    static public void markTask(){
        System.out.println("Which one to mark ?");

        for (int i = 0; i < tasks.size(); i++){
            System.out.println( i + " - " + tasks.get(i) ); //each object in ArrayList
        }

        int n = s.nextInt();
        if (n>=tasks.size()){
            System.out.println("Please enter a valid task number");  // Enter this if statement
            n = s.nextInt();
        }

        tasks.get(n).toggleDone(); // we are using method "toggleDone" to switch our boolean isDone to true or vice versa

        menu();
    }

    static public void showAllDone(){

        for (int i = 0; i< tasks.size(); i++){
            if ( tasks.get(i).isDone ){ // if object have boolean = true, then
                System.out.println( i + " - " + tasks.get(i) );
            }

        }

        s.nextLine(); // accepts enter
        System.out.println("Press enter to go to menu");
        s.nextLine();
        menu();
    }

    static public void showAllNotDone(){
        for (int i = 0; i< tasks.size(); i++){
            if ( !(tasks.get(i).isDone) ){ // if object have boolean = !true, then
                System.out.println( i + " - " + tasks.get(i) );
            }

        }

        s.nextLine(); // accepts enter
        System.out.println("Press enter to go to menu");
        s.nextLine();
        menu();

    }



}
