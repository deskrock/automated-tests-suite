package ee.inbank.automatedtests.internetbank.pages.poland;

import ee.inbank.automatedtests.internetbank.pages.MainPage;

// page_url = https://staging2.inbank.pl/en
public class PolishMainPage extends MainPage {

  @Override
  protected String getUrl() {
    return "https://staging2.inbank.pl/en";
  }
}
