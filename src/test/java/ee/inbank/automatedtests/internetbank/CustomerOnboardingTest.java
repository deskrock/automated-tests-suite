package ee.inbank.automatedtests.internetbank;

import static com.codeborne.selenide.Selenide.closeWindow;

import org.junit.jupiter.api.Test;

public class CustomerOnboardingTest extends InternetBankAutomatedTest {

  @Test
  public void onboardNewCustomer() {
    acceptCookies();
    loginCustomer();
    closeWindow();
  }

  private void loginCustomer() {

  }
}
