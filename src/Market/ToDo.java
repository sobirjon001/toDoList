package Market;

public class ToDo {

  public String task;

  public boolean isDone = false;

  public ToDo(String task) { // it s constructor, it is like setInfo
    this.task = task;
  }

  public void toggleDone() { // this is the method
    this.isDone = !isDone; // change to opposite value to true or false
  }

  public String toString() {
    return (isDone ? " [✔] " : " [ ] ") + task;
  }


}

