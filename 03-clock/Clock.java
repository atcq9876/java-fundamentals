import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

class Clock {
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";
  public static void main(String[] args) {    
    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println("Before formatting: " + dateTime);

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    String formattedTime = dateTime.format(dateTimeFormatter);
    System.out.println("After formatting: The local " + ANSI_RED + "time" + ANSI_RESET + " is " + formattedTime);
  }
}
