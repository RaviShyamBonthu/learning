Feature: Deals Functionality verification
@Deals
  Scenario: verify user landed on deals page
    Given Launch the Cogmento application
    And Click "Log In" button on welcome page
    And Verify the Title on login page
    When User enters Username and password on login page
    And Click "Login" button on login page
    Then Verify the Cogmento logo on dashboard page
    Then User navigates to the Deals page
    And User verify the deals title
    Then user click on create button
