package ee.inbank.automatedtests.internetbank.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

// page_url = https://staging2.inbank.ee/en
public class LoginPage {

  private final SelenideElement page = $("#login-modal___BV_modal_content_");

  public LoginPage() {
    page.shouldBe(visible);
  }

  public LoginPage getFakeAuthForm() {
    page.$(byText("Fake Auth")).click();
    return this;
  }

  public LoginPage insertExistingCustomerData() {
    page.$x((".//*[@id=\"fake-firstname\" and (@class=\"form-control\")]")).sendKeys("Alex");
    page.$x((".//*[@id=\"fake-lastname\" and (@class=\"form-control\")]")).sendKeys("Teder");
    page.$x((".//*[@id=\"fake-idcode\" and (@class=\"form-control\")]")).sendKeys("39403180218");
    page.$x((".//*[@id=\"fake-id-phone\" and (@class=\"form-control\")]")).sendKeys("58159643");
    return this;
  }

  public LoginPage insertNewCustomerData(String idCode, String phoneNumber) {
    page.$x((".//*[@id=\"fake-firstname\" and (@class=\"form-control\")]")).sendKeys("Alex");
    page.$x((".//*[@id=\"fake-lastname\" and (@class=\"form-control\")]")).sendKeys("Tester");
    page.$x((".//*[@id=\"fake-idcode\" and (@class=\"form-control\")]")).setValue(idCode);
    page.$x((".//*[@id=\"fake-id-phone\" and (@class=\"form-control\")]")).setValue(phoneNumber);
    return this;
  }

  public LoginPage submitFakeAuthForm() {
    SelenideElement fakeSubmitButton = page.$(By.id("fake-auth-form")).$("button.btn.btn-primary");
    fakeSubmitButton.shouldBe(visible);
    fakeSubmitButton.click();
    return this;
  }
}