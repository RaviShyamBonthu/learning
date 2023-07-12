Feature: Delete the Created Contacts
  @Test1
  Scenario: verify  the user id able to delete Contacts Page
    Given Launch the Cogmento application
    And Click "Log In" button on welcome page
    And Verify the Title on login page
    When User enters Username and password on login page
    And Click "Login" button on login page
    Then Verify the Cogmento logo on dashboard page
    Then User is navigate to contacts page
    And Verify user is on contacts page
    When User is click on create button
    And User is enter the all contacts fields
    Then User able to click the save button

