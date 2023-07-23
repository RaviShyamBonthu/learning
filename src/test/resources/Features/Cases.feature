Feature: Cases Functionality verification
  Background: Login functionality
    Given Launch the Cogmento application
    And Click "Log In" button on welcome page
    And Verify the Title on login page
    When User enters Username and password on login page
    And Click "Login" button on login page
    Then Verify the Cogmento logo on dashboard page
  @Passed
  Scenario: verify user landed on cases page
    Then User navigates to the Cases page
    And verifies the Cases text
    When User click on create button
    And user enter fields in cases module
    Then User click on save button
    And User is see the information for cases which is created

    @Pass1
    Scenario: verify user is edit the case pageerify that
      Then user is navigate to cases page
      And user is verify the cases page
      When user is click on create button
      And user is enter fields in cases create page
      Then verify that user is saved the created case page
      And user is edit the case title in created cases page

      @Pass2
      Scenario: verify tha user is able see the created case in Rubbish Bin
        Then user is able to navigate to the cases page
        And verify that user is on cases page
        When user is able to click on create button
        And user is able to enter the cases fields
        Then user is able to click on save button
        And Verify that user is able to created the cases page
        Then user is able to delete the created case
        And verify that user is able to delete the created case
        Then user is able to click on Rubbish Bin
        And Verify that user is able to see the deleted case in ribbish Bin





