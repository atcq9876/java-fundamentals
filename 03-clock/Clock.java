import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

class Clock {
  public static void main(String[] args) {
    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println("Before formatting: " + dateTime);

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    String formattedTime = dateTime.format(dateTimeFormatter);
    System.out.println("The local time is " + formattedTime);
  }
}
