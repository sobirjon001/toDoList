import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  // Global variables
  static Scanner s = new Scanner(System.in);
  static ArrayList<ToDo> tasks = new ArrayList<>();
  // End of Global variables

  public static void main(String[] args) {
    menu();
  }

  public static void line(){
    System.out.println("=========================================================");
  }

  public static void menu() {
    line();
    // List all available tasks:
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(i + " - " + tasks.get(i));
    }
    if(tasks.isEmpty()){
      System.out.println("You have no tasks yet");
    }
    line();
    // Ask use for actions:
    System.out.println("Please choose your action:");
    System.out.println("1 - add new task");
    System.out.println("2 - delete task");
    System.out.println("3 - mark ✔ this task is done or not ");
    System.out.println("4 - show all tasks is done ");
    System.out.println("5 - show all tasks is not done ");

    String number = s.next();  // convert to string
    if(!tasks.isEmpty()||number.equals("1")) {
      switch (number) {
        case "1":
          createTask();
          break;
        case "2":
            deleteTask();
          break;
        case "3":
            markTask();
          break;
        case "4":
            showAllDone();
          break;
        case "5":
            showAllNotDone();
          break;
        default:
          System.out.println("Invalid entry! \nPress Enter to try again");
          s.nextLine();
          s.nextLine();
          menu();
      }// end of switch statement
    }else {
      menu();
    }
  }

  public static void createTask() {
    s.nextLine();
    line();
    System.out.println("Please enter your task: ");
    String input = s.nextLine();
    tasks.add(new ToDo(input));
    menu();
  }

  static public int inputAndInvalid(){
    /*
        this method gets users input and checks for invalid entry
        this method made separately because deleteTask() and markTask()
        use same logic so it combined between them
     */
    boolean isNotValid = true;
    boolean isDigit = true;
    int x = 0; // declaring x outside while so return can access it
    while (isNotValid){
      isDigit = true;
      String xx= s.next();  // Have them enter as String
      for (char each:xx.toCharArray()){  //check to confirm they are digit
        if (!Character.isDigit(each)){
          isDigit = false;
        }
      }
      if (isDigit){
        x = Integer.parseInt(xx);  //convert String to int
        if(x < tasks.size()-1){
          isNotValid = false;
        }else {
          System.out.println("Please enter a valid task number");
        }
      }else {
        System.out.println("Please enter a valid task number");
      }
    }
    return x;
  }

  static public void deleteTask() {
    line();
    System.out.println("Which one to delete ?");
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(i + " - " + tasks.get(i));
    }
    int x = inputAndInvalid(); // get user input and checking for invalid entry:
    tasks.remove(x);
    menu();
  }

  static public void markTask() {
    line();
    System.out.println("Which one to mark ?");
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(i + " - " + tasks.get(i));
    }
    int x = inputAndInvalid(); // get user input and checking for invalid entry:
    tasks.get(x).toggleDone();
    menu();
  }

  static public void showAllDone() {
    line();
    int count = 0;
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).isDone) {
        System.out.println(i + " - " + tasks.get(i));
        count++;
      }
    }
    if(count == 0){
      System.out.println("You have no done tasks yet");
    }
    line();
    s.nextLine();
    System.out.println("Press enter to go to menu");
    s.nextLine();
    menu();
  }

  static public void showAllNotDone() {
    line();
    int count = 0;
    for (int i = 0; i < tasks.size(); i++) {
      if (!(tasks.get(i).isDone)) {
        System.out.println(i + " - " + tasks.get(i));
        count++;
      }
    }
    if(count==0){
      System.out.println("You have no not done tasks yet");
    }
    line();
    s.nextLine();
    System.out.println("Press enter to go to menu");
    s.nextLine();
    menu();
  }
}
