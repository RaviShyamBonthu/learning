Feature: Contacts Functionalities
@Test
  Scenario: Verify user landed on contacts page
    Given Launch the Cogmento application
    And Click "Log In" button on welcome page
    And Verify the Title on login page
    When User enters Username and password on login page
    And Click "Login" button on login page
    Then Verify the Cogmento logo on dashboard page
    Then user navigates the contact page
    And user is verify the contacts page
    When user is click on create new button
    And user is enter contacts page mandatory field
    Then user is able to click the save button
    And verify that the user is able to save contacts



