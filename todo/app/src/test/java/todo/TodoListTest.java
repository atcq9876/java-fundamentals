package todo;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class TodoListTest {
  @Test public void shouldStartWithEmptyList() {
    TodoList todoList = new TodoList();
    
    assertTrue("it starts with an empty list", todoList.todos.isEmpty());
  }
  @Test public void addsTaskToList() {
    TodoList todoList = new TodoList();
    ArrayList<String> expectedList = new ArrayList<String>();
    expectedList.add("Wash car");

    assertEquals("it adds a todo to the list", expectedList, todoList.addTask("Wash car"));
  }
}
