package ee.inbank.automatedtests.internetbank;

import com.codeborne.selenide.Configuration;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import ee.inbank.automatedtests.AutomatedTest;
import org.junit.jupiter.api.BeforeEach;

public class InternetBankAutomatedTest extends AutomatedTest {

  protected static final String MARKETING_COOKIE_NAME = "_inbank_marketing";
  private static final String URL = "https://staging3.inbank.ee/en";

  @BeforeEach
  @SuppressFBWarnings("ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD")
  public void setup() {
    Configuration.baseUrl = URL;
  }
}
