package ee.inbank.automatedtests.internetbank;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class CreditApplicationCreationTest extends CustomerOnboardingTest{
    public static final SelenideElement APPLY_SMALL_LOAN = $("button.btn.btn-white.ga-button-mainpage-calculator-small-loan-apply");
    public static final SelenideElement ACCEPT_MODAL = $(id("loan-offer-accept-modal___BV_modal_content_"));
    public static final SelenideElement IDENTIFICATION_MODAL = $("div.row.border-top.pt-5.mt-4");
    @Test
    public void assertLoanCalculatorWorks() {
        acceptCookies();
        loginCustomer();
        loanApplicationCreate();

    }
    private void loanApplicationCreate() {
        APPLY_SMALL_LOAN.should(Condition.visible,Duration.ofMinutes(10L));;
        APPLY_SMALL_LOAN.click();
        $(id("terms-checkbox-text")).should(Condition.visible,Duration.ofMinutes(10L));
        $(id("loan-amount")).setValue("1500");
        $(id("terms-checkbox-text")).should(Condition.visible,Duration.ofMinutes(10L));
        $(id("terms-checkbox-text")).click();
        $(id("submit-loan-application")).click();
        $("a.text-white").hover();
        SelenideElement loanOfferAcceptButton = $(id("loan-offer-accept"));
        loanOfferAcceptButton.should(Condition.visible, Duration.ofMinutes(10L));
        loanOfferAcceptButton.click();
        ACCEPT_MODAL.shouldBe(Condition.visible);
        SelenideElement acceptButton = ACCEPT_MODAL.$("button.btn.btn-primary");
        acceptButton.click();
      //  $(id("postpone")).click();
        $(id("click-accept-confirm")).click();
        $("p.text-primary.u-cursor-pointer").shouldHave(Condition.matchText("24.45"), Duration.ofSeconds(50L));
    }
}