package ee.inbank.automatedtests.internetbank.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

// page_url = https://staging3.inbank.ee/en/loan/personal-loan/15f062aa-e868-49ac-9614-18fb24c5f63e/offer
public class CreditApplicationDecisionPage {
  private static final SelenideElement page = $("div.d-flex.flex-column.flex-grow-1");

  public CreditApplicationDecisionPage() {
    page.shouldBe(visible);
  }

  public CreditApplicationDecisionPage continueWithoutChanges(){
    page.$(id("decline-max-limit")).click();
    return this;
  }
}

