package ee.inbank.automatedtests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class AutomatedTest {

  @BeforeAll
  public static void setUpAll() {
    // Set up common webdriver configuration for all flows
    // Configuration.browserSize = "1580x1000";
    // Configuration.browser = "chrome";
    Configuration.timeout = 100000L;
  }
}
