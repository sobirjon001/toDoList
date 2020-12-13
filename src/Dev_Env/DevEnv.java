package Dev_Env;

import Market.ToDo;

import java.util.ArrayList;
import java.util.Scanner;


//************  DEVELOPERS ENVIRONMENT  **********************

public class DevEnv {
  // Global variables
  static Scanner s = new Scanner(System.in);
  static ArrayList<ToDo> tasks = new ArrayList<>();
  // End of Global variables

  public static void main(String[] args) {
    // creating tasks for running unit test
    tasks.add(new ToDo("task 1"));
    tasks.add(new ToDo("task 2"));
    tasks.add(new ToDo("task 3"));
    tasks.add(new ToDo("task 4"));
    tasks.add(new ToDo("task 5"));
    tasks.add(new ToDo("task 6"));

    // running unit test of inputAndInvalid()
    System.out.println("Please enter number from 0 to " + (tasks.size() - 1));
    int test = inputAndInvalid();
    System.out.println("Correct number is: " + test);
  }

  static public int inputAndInvalid() {
    /*
        this method gets users input and checks for invalid entry
        this method made separately because deleteTask() and markTask()
        use same logic so it combined between them
     */
    boolean isNotValid = true;
    boolean isDigit;
    int x = 0; // declaring x outside while so return can access it
    while (isNotValid) {
      isDigit = true;
      String xx = s.next();  // Have them enter as String
      for (char each : xx.toCharArray()) {  //check to confirm they are digit
        if (!Character.isDigit(each)) {
          isDigit = false;
        }
      }
      if (isDigit) {
        x = Integer.parseInt(xx);  //convert String to int
        if (x < tasks.size()) {
          isNotValid = false;
        } else { // if incorrect number entered
          System.out.println("Please enter a valid task number");
        }
      } else { // if not digits entered
        System.out.println("Please enter a valid task number");
      }
    }
    return x;
  }
}

