import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DurationCalculator {

  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

  public static void main(String[] args) {
    try {
      LocalDate from = getDate("start");
      LocalDate to = getDate("end");

      displayDuration(from, to);

    } catch (Exception e) {
      System.out.println("An error has occurred. Please check your input and try again.");
    }
  }

  private static void displayDuration(LocalDate from, LocalDate to) {
    Duration d = Duration.between(from.atStartOfDay(), to.atStartOfDay());

    System.out.printf("Duration between %s and %s are:", from.toString(), to.toString());

    System.out.printf("%n%s day(s)", DECIMAL_FORMAT.format(d.toDays()));
    System.out.printf("%n%s hours", DECIMAL_FORMAT.format(d.toHours()));
    System.out.printf("%n%s minutes", DECIMAL_FORMAT.format(d.toMinutes()));
    System.out.printf("%n%s seconds", DECIMAL_FORMAT.format(d.getSeconds()));
  }

  /**
   * Get user input
   *
   * @return
   */
  private static LocalDate getDate(String str) {
    System.out.printf("Please enter the %s date (yyyy/mm/dd): ", str);

    Scanner sc = new Scanner(System.in);
    String input = sc.next();

    return LocalDate.parse(input, DATE_FORMATTER);
  }
}
