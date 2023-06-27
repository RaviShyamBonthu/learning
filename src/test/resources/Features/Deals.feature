Feature: Cases Functionality verification

  Scenario: verify user landed on deals page
    Given Launch the Cogmento application
    And Click "Log In" button on welcome page
    And Verify the Title on login page
    When User enters Username and password on login page
    And Click "Login" button on login page
    Then Verify the Cogmento logo on dashboard page
    Then User navigates to the Deals page
    And verifies the Deals text
    When User click on create button
    And user enter fields in deals module