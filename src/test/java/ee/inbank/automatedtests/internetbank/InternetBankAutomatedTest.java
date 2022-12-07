package ee.inbank.automatedtests.internetbank;

import com.codeborne.selenide.Configuration;
import ee.inbank.automatedtests.AutomatedTest;
import org.junit.jupiter.api.BeforeEach;

public class InternetBankAutomatedTest extends AutomatedTest {

  public static final String MARKETING_COOKIE_NAME = "_inbank_marketing";
  protected static final String URL = "https://staging2.inbank.ee/en";

  @BeforeEach
  public void setup() {
    Configuration.baseUrl = URL;
  }
}
