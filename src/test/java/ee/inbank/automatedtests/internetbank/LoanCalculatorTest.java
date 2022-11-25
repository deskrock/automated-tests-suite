package ee.inbank.automatedtests.internetbank;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWindow;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class LoanCalculatorTest extends InternetBankAutomatedTest {

  private static final SelenideElement CALCULATOR_PARTIAL = $("#calculator");
  private static final Duration LONG_REQUEST_TIMEOUT = ofSeconds(20L);

  @Test
  public void assertLoanCalculatorWorks() {
    acceptCookies();
    // Maybe we should set required cookies beforehand so not all tests will have to check if cookies work?
    assertCalculatorCalculations("12", "1000", "93.61");
    assertCalculatorCalculations("12", "2000", "181.72");
    assertCalculatorCalculations("36", "1000", "35.90");
    closeWindow();
  }

  // valid monthValues are 12-72 with 6 month step. Ugly hack sorry
  // This test will break if product parameters are changed
  private static void assertCalculatorCalculations(String monthValue, String amountValue, String expectedMonthlyPayment) {
    CALCULATOR_PARTIAL.shouldBe(visible);
    CALCULATOR_PARTIAL.$("#period").sendKeys(monthValue, Keys.ENTER);
    CALCULATOR_PARTIAL.$("#amount").setValue(amountValue);

    SelenideElement calculatedValue = CALCULATOR_PARTIAL.$x(".//*[@id=\"__BVID__146\"]/div/div[2]/h2/span");
    calculatedValue.shouldHave(exactText(expectedMonthlyPayment), LONG_REQUEST_TIMEOUT);
  }
}
