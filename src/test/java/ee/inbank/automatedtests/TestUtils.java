package ee.inbank.automatedtests;

import static com.codeborne.selenide.Selenide.webdriver;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import org.openqa.selenium.Cookie;

public class TestUtils {

  public static void assertCookiePresent(String name) {
    assertTrue(getAllCookies().stream().anyMatch(cookie -> cookie.getName().equalsIgnoreCase(name)));
  }

  private static Set<Cookie> getAllCookies() {
    return webdriver().driver().getWebDriver().manage().getCookies();
  }

  public static String generateEstonianPersonalID() {
    Integer gender = randomIntFromInterval(3, 4);
    LocalDate date = getRandomBirthDate();
    String dayPart = format("%02d", date.getDayOfMonth());
    String monthPart = format("%02d", date.getMonthValue());
    String yearPart = valueOf(date.getYear()).substring(2);
    String randomPart = format("%03d", randomIntFromInterval(1, 999));
    String partialIdentityCode = gender.toString() + yearPart + monthPart + dayPart + randomPart;

    return partialIdentityCode + calculateControlNumber(partialIdentityCode);
  }

  private static Integer randomIntFromInterval(Integer min, Integer max) {
    return (int) Math.abs(Math.floor(Math.random() * (min - max + 1) + min));
  }

  private static LocalDate getRandomBirthDate() {
    Random random = new Random();
    int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
    int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
    long randomDay = minDay + random.nextInt(maxDay - minDay);

    return LocalDate.ofEpochDay(randomDay);
  }

  private static int calculateControlNumber(String personalCodeBlocks) {
    String[] numberArray = personalCodeBlocks.split("");
    int[] multipliers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
    int parsedControlNumber = calculateWeightedSum(numberArray, multipliers);

    if (parsedControlNumber == 10) {
      multipliers = new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2, 3};
      parsedControlNumber = calculateWeightedSum(numberArray, multipliers);

      if (parsedControlNumber == 10) {
        return 0;
      }
    }

    return parsedControlNumber;
  }

  private static int calculateWeightedSum(String[] personalCodeBlocks, int[] multipliers) {
    int sum = IntStream
        .range(0, personalCodeBlocks.length)
        .map(i -> parseInt(personalCodeBlocks[i]) * multipliers[i])
        .sum();
    return sum % 11;
  }

  public static String generateRandomPhoneNumber() {
    return String.valueOf(new Random().nextInt(50000011, 50999999));
  }

  public static String generateRandomEmail() {
    return "api_ee_test_" + new Random().nextInt(50000011, 50999999) + "@inbank.ee";
  }
}
