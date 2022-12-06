package ee.inbank.automatedtests.internetbank.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

import com.codeborne.selenide.SelenideElement;

// page_url = https://staging2.inbank.ee/en
public class CreditApplicationPage {

  private static final SelenideElement page = $(id("loan-offer-accept-modal___BV_modal_content_"));

  public CreditApplicationPage() {
    page.shouldBe(visible);
  }

  public void accept() {
    SelenideElement acceptButton = page.$("button.btn.btn-primary");
    acceptButton.click();
  }
}
