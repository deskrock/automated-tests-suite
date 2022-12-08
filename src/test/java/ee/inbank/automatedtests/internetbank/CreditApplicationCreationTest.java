package ee.inbank.automatedtests.internetbank;

import ee.inbank.automatedtests.internetbank.pages.CalculatorPage;
import ee.inbank.automatedtests.internetbank.pages.CreditApplicationDecisionPage;
import ee.inbank.automatedtests.internetbank.pages.CreditApplicationPage;
import ee.inbank.automatedtests.internetbank.pages.LoanOfferPage;
import ee.inbank.automatedtests.internetbank.pages.LoginPage;
import ee.inbank.automatedtests.internetbank.pages.MainPage;
import org.junit.jupiter.api.Test;

// TODO: Migrate into Page Objects pattern
public class CreditApplicationCreationTest extends InternetBankAutomatedTest {

  private static void loginCustomer(MainPage mainPage) {
    LoginPage loginPage = mainPage.getLoginPage();
    loginPage.getFakeAuthForm();
    loginPage.insertExistingCustomerData();
    loginPage.submitFakeAuthForm();
  }

  @Test
  public void creditApplicationCreationFlowTest() {
    MainPage mainPage = new MainPage();
    mainPage.getConsentsPage().giveAllConsents();

    loginCustomer(mainPage);

    CalculatorPage calculatorPage = mainPage.getCalculatorPage();
    calculatorPage.setAmountValue("600");
    calculatorPage.setMonthValue("12");
    calculatorPage.applyForLoan();

    CreditApplicationPage creditApplicationPage = new CreditApplicationPage();
    creditApplicationPage.insertLoanApplicationForm();
    creditApplicationPage.acceptGeneralConsents();
    creditApplicationPage.submitLoanApplication();

    CreditApplicationDecisionPage creditApplicationDecisionPage = new CreditApplicationDecisionPage();
    creditApplicationDecisionPage.continueWithoutChanges();

    LoanOfferPage loanOfferPage = new LoanOfferPage();
    loanOfferPage.acceptOffer();
  }
}