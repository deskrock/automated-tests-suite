package ee.inbank.automatedtests.internetbank;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ee.inbank.automatedtests.TestUtils.assertCookiePresent;

import com.codeborne.selenide.SelenideElement;
import ee.inbank.automatedtests.AutomatedTest;
import org.junit.jupiter.api.BeforeEach;

public class InternetBankAutomatedTest extends AutomatedTest {

  public static final String URL = "https://staging2.inbank.ee/en";
  public static final String MARKETING_COOKIE_NAME = "_inbank_marketing";

  public static final SelenideElement COOKIE_CONSENT_MODAL = $("#cookie-consent-modal___BV_modal_content_");

  @BeforeEach
  public void setUp() {
    open(URL);
  }

  protected void acceptCookies() {
    COOKIE_CONSENT_MODAL.shouldBe(visible);

    SelenideElement acceptButton =  COOKIE_CONSENT_MODAL.$("button.btn.ml-lg-3.order-1.order-lg-2.btn-primary");
    acceptButton.shouldHave(exactText("Accept all cookies"));
    acceptButton.click();

    assertCookiePresent(MARKETING_COOKIE_NAME);
  }
}
