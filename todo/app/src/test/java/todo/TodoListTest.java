package todo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TodoListTest {
  @Test public void shouldStartWithEmptyList() {
    TodoList todoList = new TodoList();
    assertTrue("it starts with an empty list", todoList.todos.isEmpty());
  }
  @Test public void addsTaskToList() {
    TodoList todoList = new TodoList();
    todoList.addTask("Wash car");
    assertFalse("it adds a todo to the list", todoList.todos.isEmpty());
  }
}
