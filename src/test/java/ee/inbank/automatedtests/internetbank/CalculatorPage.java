package ee.inbank.automatedtests.internetbank;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public class CalculatorPage {

  private static final SelenideElement page = $("#calculator");

  public CalculatorPage() {
    page.shouldBe(visible);
  }

  // valid monthValues are 12-72 with 6 month step. Ugly hack sorry
  public void setMonthValue(String monthValue) {
    SelenideElement periodElement = page.$("#period").shouldBe(visible);
    periodElement.sendKeys(monthValue, Keys.ENTER);
  }

  public void setAmountValue(String amountValue) {
    SelenideElement amountElement = page.$("#amount").shouldBe(visible);
    amountElement.setValue(amountValue);
  }

  public String getCalculatedValue(String expectedValue) {
    SelenideElement resultElement = page.$x(".//*[@id=\"__BVID__146\"]/div/div[2]/h2/span").shouldHave(exactText(expectedValue), ofSeconds(20L));
    return resultElement.getText();
  }
}
