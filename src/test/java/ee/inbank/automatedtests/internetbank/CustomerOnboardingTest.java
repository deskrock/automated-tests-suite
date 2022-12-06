package ee.inbank.automatedtests.internetbank;

import static ee.inbank.automatedtests.TestUtils.assertCookiePresent;

import ee.inbank.automatedtests.internetbank.pages.MainPage;
import org.junit.jupiter.api.Test;

public class CustomerOnboardingTest extends InternetBankAutomatedTest {

  @Test
  public void onboardNewCustomerTest() {
    MainPage mainPage = new MainPage();

    mainPage.getConsentsPage().giveAllConsents();
    assertCookiePresent(MARKETING_COOKIE_NAME);

    mainPage.loginCustomer();

    mainPage.close();
  }
}
