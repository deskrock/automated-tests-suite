package ee.inbank.automatedtests.internetbank.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

// page_url = https://staging2.inbank.ee/en
public class MainPage {

  public MainPage() {
    Selenide.open("/");
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

  public void close() {
    Selenide.closeWindow();
  }
}