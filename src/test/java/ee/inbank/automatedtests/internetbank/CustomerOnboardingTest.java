package ee.inbank.automatedtests.internetbank;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static ee.inbank.automatedtests.TestUtils.*;

public class CustomerOnboardingTest extends InternetBankAutomatedTest {

  public static final SelenideElement LOGIN_MODAL = $("#login-modal___BV_modal_header_");
  public static final SelenideElement FAKE_AUTH_MODAL = $(By.id("fake-auth-form"));
  public static final String SUBMIT_BUTTON = "button.btn.btn-primary";

  @Test
  public void onboardNewCustomer() {
    acceptCookies();
    onboardCustomer();
    closeWindow();
  }

  public void onboardCustomer() {
    TO_LOGIN_BUTTON.click();
    LOGIN_MODAL.shouldBe(visible);
    SelenideElement fakeSubmitButton = FAKE_AUTH_MODAL.$(SUBMIT_BUTTON);
    LOGIN_FAKE_AUTH.click();
    $x(("//*[@id=\"fake-firstname\" and (@class=\"form-control\")]")).sendKeys("Alex");
    $x(("//*[@id=\"fake-lastname\" and (@class=\"form-control\")]")).sendKeys("Tester");
    $x(("//*[@id=\"fake-idcode\" and (@class=\"form-control\")]")).setValue(generateEstonianPersonalID());
    $x(("//*[@id=\"fake-id-phone\" and (@class=\"form-control\")]")).setValue(generateRandomPhoneNumber());
    fakeSubmitButton.shouldBe(visible);
    fakeSubmitButton.click();
    $x(("//*[@id=\"email\" and (@class=\"form-control\")]")).setValue(generateRandomEmail());
    $("p.text-primary.u-cursor-pointer").shouldHave(Condition.matchText("24.45"), Duration.ofSeconds(50L));

  }
}
