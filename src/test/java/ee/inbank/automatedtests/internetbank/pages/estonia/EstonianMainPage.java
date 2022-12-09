package ee.inbank.automatedtests.internetbank.pages.estonia;

import ee.inbank.automatedtests.internetbank.pages.MainPage;

// page_url = https://staging2.inbank.ee/en
public class EstonianMainPage extends MainPage {

  @Override
  protected String getUrl() {
    return "https://staging3.inbank.ee/en";
  }
}
