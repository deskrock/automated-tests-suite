package ee.inbank.automatedtests.internetbank;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class ConsentsPage {

  public final SelenideElement page = $("#cookie-consent-modal___BV_modal_content_");

  public ConsentsPage() {
    page.shouldBe(visible);
  }

  public void giveAllConsents() {
    SelenideElement acceptButton =  page.$("button.btn.ml-lg-3.order-1.order-lg-2.btn-primary");
    acceptButton.shouldHave(exactText("Accept all cookies"));
    acceptButton.click();
  }
}
