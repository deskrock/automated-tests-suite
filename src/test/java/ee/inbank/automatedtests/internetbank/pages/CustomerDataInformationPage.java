package ee.inbank.automatedtests.internetbank.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

// page_url = https://staging2.inbank.ee/en/auth/application

public class CustomerDataInformationPage {

  private static final SelenideElement page = $x("//*[@id=\"__layout\"]/div/div[1]/main/section[2]/div");

  public CustomerDataInformationPage() {
    page.shouldBe(visible);
  }

  public CustomerDataInformationPage insertDataForm(String generatedEmail) {
    page.$("#email").setValue(generatedEmail);
    page.$("#county").selectOption(0);
    page.$("#parish").selectOption(0);
    page.$("#township").selectOption(0);
    page.$("#street").selectOption(2);
    page.$("#house").selectOption(0);
    return this;
  }

  public CustomerDataInformationPage acceptGeneralConsents() {
    page.$("label[for=marketing-general]").click();
    page.$("label[for=eservice]").click();
    page.$("label[for=data-processing] span").click();
    return this;
  }

  public CustomerDataInformationPage applyCustomerButton() {
    page.$("#submit-onboarding-application").click();
    return this;
  }
}