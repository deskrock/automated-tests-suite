package ee.inbank.automatedtests.internetbank.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public abstract class MainPage {

  public MainPage() {
    Selenide.open(getUrl());
  }

  public ConsentsPage getConsentsPage() {
    return new ConsentsPage();
  }

  public CalculatorPage getCalculatorPage() {
    return new CalculatorPage();
  }

  public LoginPage getLoginPage() {
    SelenideElement loginButton = $("a[class$=\"ga-link-navigation-log-in\"]");
    loginButton.click();
    return new LoginPage();
  }

  protected abstract String getUrl();
}
