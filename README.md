# automated-test-suite
The purpose of this repository is to hold end-to-end tests.
Look [Quick Start](https://selenide.org/2014/10/01/how-to-start-writing-ui-tests/) for details. 
## Our Goal
* Set Release quality better
* Code is working as expected with existing functionality
* Main functionality is working expected with related components 
* Master branch is tested before going to Production
* Make QAs aware of automation
* Figure out Continuity plan(Who/When/What). Make Automated tests mandatory to write (Find suitable QA as responsible for related test suite, compose Automation Test story tickets)


## What is the process?
* Run tests ~16:00 so someone responsible is there to understand/analyse
* Where results are reported? (Slack-alert)
* Should release stop (yes - when test be having complete coverage & QA support)

## Structure of writing the tests
* Page Object Pattern is used. The benefit is that if the UI changes for the page, the tests themselves don’t need to change, only the code within the page object needs to change. Subsequently, all changes to support that new UI are located in one place.
  [Read more](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)

## TO-DO
* Dockerize
* Jenkins pipeline
* Describe tests Structure/Princaples how to write
* ...

## Requirements
* JDK 17
* Chrome Webdriver
* Use code style in config/codestyle.xml

## Test
`./gradlew clean check test`

## Build
`./gradlew build`

