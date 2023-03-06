package todo;

import java.util.ArrayList;

public class TodoList {
  ArrayList<String> todos = new ArrayList<String>();
  
  public static void main(String[] args) {
  }
  
  void addTask(String task) {
    todos.add(task);
  }
}
