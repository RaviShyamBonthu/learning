Feature: Cases Functionality verification
  @Test
  Scenario: verify user landed on cases page
    Given Launch the Cogmento application
    And Click "Log In" button on welcome page
    And Verify the Title on login page
    When User enters Username and password on login page
    And Click "Login" button on login page
    Then Verify the Cogmento logo on dashboard page
    Then User navigates to the Cases page
    And verifies the Cases text
    When User click on create button
    And user enter fields in cases module
