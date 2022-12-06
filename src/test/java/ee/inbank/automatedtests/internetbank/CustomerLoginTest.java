package ee.inbank.automatedtests.internetbank;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CustomerLoginTest extends InternetBankAutomatedTest {

  public static final SelenideElement LOGIN_MODAL = $("#login-modal___BV_modal_header_");
  public static final SelenideElement FAKE_AUTH_MODAL = $(By.id("fake-auth-form"));
  public static final String SUBMIT_BUTTON = "button.btn.btn-primary";


  @Test
  public void loginExistingCustomer() {
    acceptCookies();
    loginCustomer();
    closeWindow();
  }

  public void loginCustomer() {
    TO_LOGIN_BUTTON.click();
    LOGIN_MODAL.shouldBe(visible);
    SelenideElement fakeSubmitButton = FAKE_AUTH_MODAL.$(SUBMIT_BUTTON);
    LOGIN_FAKE_AUTH.click();

    $x(("//*[@id=\"fake-firstname\" and (@class=\"form-control\")]")).sendKeys("Alex");
    $x(("//*[@id=\"fake-lastname\" and (@class=\"form-control\")]")).sendKeys("Teder");
    $x(("//*[@id=\"fake-idcode\" and (@class=\"form-control\")]")).sendKeys("39403180218");
    $x(("//*[@id=\"fake-id-phone\" and (@class=\"form-control\")]")).sendKeys("58159643");
    fakeSubmitButton.shouldBe(visible);
    fakeSubmitButton.click();
  }
}
