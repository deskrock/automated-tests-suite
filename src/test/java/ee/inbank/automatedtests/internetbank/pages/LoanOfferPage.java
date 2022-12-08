package ee.inbank.automatedtests.internetbank.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

// page_url = https://staging3.inbank.ee/en/loan/2750bcba-75f5-485b-9d4f-284eff057c1d/offer?polling=true
public class LoanOfferPage {

  private static final SelenideElement page = $("div.d-flex.flex-column.flex-grow-1");

  public LoanOfferPage() {
    page.shouldBe(visible);
  }

  public LoanOfferPage acceptOffer(){
    page.$(id("loan-offer-accept")).click();
    return this;
  }
}