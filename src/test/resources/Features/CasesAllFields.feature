Feature: Cases All fields Enter Functionalities
@Test3
  Scenario: Verify that the user is able to enter all cases fields
    Given Launch the Cogmento application
    And Click "Log In" button on welcome page
    And Verify the Title on login page
    When User enters Username and password on login page
    And Click "Login" button on login page
    Then Verify the Cogmento logo on dashboard page
    And User is navigates to cases page
    Then Verify user is on cases Page
    And User is able to click on create button
    When User is enter the cases fields in cases page
    Then User is able to click on save button
    And  verify that user is able to save the created cases


