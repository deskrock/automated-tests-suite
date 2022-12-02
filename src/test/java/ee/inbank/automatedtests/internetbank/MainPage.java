package ee.inbank.automatedtests.internetbank;

import com.codeborne.selenide.Selenide;

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

  public void loginCustomer() {
  }

  public void close() {
    Selenide.closeWindow();
  }
}
