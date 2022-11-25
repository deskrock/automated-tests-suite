package ee.inbank.automatedtests;

import static com.codeborne.selenide.Selenide.webdriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import org.openqa.selenium.Cookie;

public class TestUtils {

  public static void assertCookiePresent(String name) {
    assertTrue(getAllCookies().stream().anyMatch(cookie -> cookie.getName().equalsIgnoreCase(name)));
  }

  private static Set<Cookie> getAllCookies() {
    return webdriver().driver().getWebDriver().manage().getCookies();
  }
}
