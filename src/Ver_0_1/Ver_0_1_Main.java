package Ver_0_1;

import Market.ToDo;

import java.util.ArrayList;
import java.util.Scanner;

public class Ver_0_1_Main {
  // Global variables
  static Scanner s = new Scanner(System.in);
  static ArrayList<ToDo> tasks = new ArrayList<>();
  // End of Global variables

  public static void main(String[] args) {
    menu();
  }

  public static void menu() {
    // List all available tasks:
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(i + " - " + tasks.get(i));
    }
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
    System.out.println("Please enter your task: ");
    String input = s.nextLine();
    tasks.add(new ToDo(input));
    menu();
  }

  static public void deleteTask() {
    System.out.println("Which one to delete ?");
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(i + " - " + tasks.get(i));
    }
    int x = s.nextInt();
    tasks.remove(x);
    menu();
  }

  static public void markTask() {
    System.out.println("Which one to mark ?");
    for (int i = 0; i < tasks.size(); i++) {
      System.out.println(i + " - " + tasks.get(i));
    }
    int x = s.nextInt();
    tasks.get(x).toggleDone();
    menu();
  }

  static public void showAllDone() {
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).isDone) {
        System.out.println(i + " - " + tasks.get(i));
      }
    }
    s.nextLine();
    System.out.println("Press enter to go to menu");
    s.nextLine();
    menu();
  }

  static public void showAllNotDone() {
    for (int i = 0; i < tasks.size(); i++) {
      if (!(tasks.get(i).isDone)) {
        System.out.println(i + " - " + tasks.get(i));
      }
    }
    s.nextLine();
    System.out.println("Press enter to go to menu");
    s.nextLine();
    menu();
  }
}