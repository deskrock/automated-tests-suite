package ee.inbank.automatedtests.internetbank;


import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ee.inbank.automatedtests.internetbank.pages.LoginPage;
import ee.inbank.automatedtests.internetbank.pages.MainPage;
import java.time.Duration;
import org.junit.jupiter.api.Test;

public class CreditApplicationCreationTest extends InternetBankAutomatedTest {

  public static final SelenideElement APPLY_SMALL_LOAN = $("button.btn.btn-white.ga-button-mainpage-calculator-small-loan-apply");
  public static final SelenideElement ACCEPT_MODAL = $(id("loan-offer-accept-modal___BV_modal_content_"));
  public static final SelenideElement IDENTIFICATION_MODAL = $("div.row.border-top.pt-5.mt-4");

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

    loanApplicationCreate();

  }

  private void loanApplicationCreate() {
    APPLY_SMALL_LOAN.shouldBe(Condition.visible);
    APPLY_SMALL_LOAN.click();
    $(id("terms-checkbox-text")).shouldBe(Condition.visible);
    $(id("loan-amount")).setValue("1500");
    $(id("terms-checkbox-text")).shouldBe(Condition.visible);
    $(id("terms-checkbox-text")).click();
    $(id("submit-loan-application")).click();
    $("a.text-white").hover();
    SelenideElement loanOfferAcceptButton = $(id("loan-offer-accept"));
    loanOfferAcceptButton.shouldBe(Condition.visible);
    loanOfferAcceptButton.click();
    ACCEPT_MODAL.shouldBe(Condition.visible);
    SelenideElement acceptButton = ACCEPT_MODAL.$("button.btn.btn-primary");
    acceptButton.click();
    //  $(id("postpone")).click();
    $(id("click-accept-confirm")).click();
    $("p.text-primary.u-cursor-pointer").shouldHave(Condition.matchText("24.45"), Duration.ofSeconds(50L));
  }
}