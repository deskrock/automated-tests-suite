package ee.inbank.automatedtests.internetbank.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

// page_url = https://staging2.inbank.ee/en
public class CreditApplicationPage {

  private static final SelenideElement page = $("div.row.no-gutters.bg-white.rounded-bottom.mb-5");

  public CreditApplicationPage() {
    page.shouldBe(visible);
  }

  public CreditApplicationPage insertLoanApplicationForm() {
    page.$(id("loan-amount")).setValue("1500");
    page.$(id("loan-period")).selectOptionByValue("24");
    page.$(id("payment-day")).selectOptionByValue("15");
    page.$(id("monthly-net-income")).setValue("3000");
    return this;
  }

  public CreditApplicationPage acceptGeneralConsents() {
    page.$(id("terms-checkbox-text")).shouldBe(Condition.visible);
    page.$(id("terms-checkbox-text")).click();
    return this;
  }

  public CreditApplicationPage submitLoanApplication() {
    page.$(id("submit-loan-application")).shouldBe(Condition.visible);
    page.$(id("submit-loan-application")).click();
    return this;
  }

}
