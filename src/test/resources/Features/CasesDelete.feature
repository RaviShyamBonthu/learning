Feature: Delete the Created Cases
@Test1
  Scenario: Verify that the user is able to delete the Cases
    Given Launch the Cogmento application
    And Click "Log In" button on welcome page
    And Verify the Title on login page
    When User enters Username and password on login page
    And Click "Login" button on login page
    Then Verify the Cogmento logo on dashboard page
    Then User is navigate to cases page
    And verifies the Cases Title
    Then Click on create button in cases page
    And user enter the fields in cases module
    When User is click on save button
    And User is see the information on cases page are created
    Then user is navigate leftpanelEntity for cases
    And user is delete the created cases


