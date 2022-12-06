package ee.inbank.automatedtests.internetbank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ee.inbank.automatedtests.internetbank.pages.CalculatorPage;
import ee.inbank.automatedtests.internetbank.pages.MainPage;
import org.junit.jupiter.api.Test;

public class LoanCalculatorTest extends InternetBankAutomatedTest {

  // This test will break if product parameters are changed. Then the result is different.
  @Test
  public void loanCalculatorTest() {
    MainPage mainPage = new MainPage();

    mainPage.getConsentsPage().giveAllConsents();

    CalculatorPage calculatorPage = mainPage.getCalculatorPage();

    calculatorPage.setMonthValue("12");
    calculatorPage.setAmountValue("1000");
    assertEquals(calculatorPage.getCalculatedValue("93.38"), "93.38");

    mainPage.close();
  }
}
