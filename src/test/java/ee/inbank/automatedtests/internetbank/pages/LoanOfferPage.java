package ee.inbank.automatedtests.internetbank.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.SelenideElement;

// page_url = https://staging3.inbank.ee/en/loan/2750bcba-75f5-485b-9d4f-284eff057c1d/offer?polling=true
public class LoanOfferPage {

  private static final SelenideElement page = $("div.d-flex.flex-column.flex-grow-1");

  public LoanOfferPage() {
    page.shouldBe(visible);
  }

  public LoanOfferPage acceptOffer() {
    page.$(id("loan-offer-accept")).click();
    return this;
  }

  public LoanOfferPage confirmAction() {
    SelenideElement confirmActionModal = $(id("loan-offer-accept-modal___BV_modal_content_")).shouldBe(visible);
    confirmActionModal.$("button.btn.btn-primary").click();
    return this;
  }
}