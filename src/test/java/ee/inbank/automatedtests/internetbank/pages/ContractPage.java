package ee.inbank.automatedtests.internetbank.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.SelenideElement;

// page_url = https://staging3.inbank.ee/en/loan/defd2f5e-418c-4f35-b66e-58ea2eaa6081/contract?polling=true
public class ContractPage {

  private static final SelenideElement page = $("div.container.mb-7");

  public ContractPage() {
    page.shouldBe(visible);
  }

  public ContractPage declineIdentification() {
    page.$("label[for=postpone]").click();
    return this;
  }

  public ContractPage signContract() {
    page.$(id("click-accept-confirm")).shouldBe(visible);
    page.$(id("click-accept-confirm")).click();
    return this;
  }

}