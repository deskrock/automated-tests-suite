package ee.inbank.automatedtests.internetbank;

import static ee.inbank.automatedtests.TestUtils.assertCookiePresent;
import static ee.inbank.automatedtests.TestUtils.generateEstonianPersonalID;
import static ee.inbank.automatedtests.TestUtils.generateRandomEmail;
import static ee.inbank.automatedtests.TestUtils.generateRandomPhoneNumber;

import ee.inbank.automatedtests.internetbank.pages.CustomerDataInformationPage;
import ee.inbank.automatedtests.internetbank.pages.LoginPage;
import ee.inbank.automatedtests.internetbank.pages.MainPage;
import ee.inbank.automatedtests.internetbank.pages.estonia.EstonianMainPage;
import ee.inbank.automatedtests.internetbank.pages.poland.PolishMainPage;
import org.junit.jupiter.api.Test;

public class CustomerOnboardingTest extends InternetBankAutomatedTest {

  @Test
  public void onboardNewCustomerEstonianTest() {
    MainPage mainPage = new EstonianMainPage();

    mainPage.getConsentsPage().giveAllConsents();
    assertCookiePresent(MARKETING_COOKIE_NAME);

    LoginPage loginPage = mainPage.getLoginPage();
    loginPage.getFakeAuthForm();
    loginPage.insertNewCustomerData(generateEstonianPersonalID(), generateRandomPhoneNumber());
    loginPage.submitFakeAuthForm();

    CustomerDataInformationPage customerDataInformationPage = new CustomerDataInformationPage();
    customerDataInformationPage.insertDataForm(generateRandomEmail());
    customerDataInformationPage.acceptGeneralConsents();
    customerDataInformationPage.applyCustomerButton();
  }

  @Test
  public void onboardNewCustomerPolandTest() {
    MainPage mainPage = new PolishMainPage();

    mainPage.getConsentsPage().giveAllConsents();
    assertCookiePresent(MARKETING_COOKIE_NAME);
  }
}
