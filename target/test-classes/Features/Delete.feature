Feature: Delete the Created Deal
  @Test1
  Scenario: Verify that the user is able to delete the Deal
    Given Launch the Cogmento application
    And Click "Log In" button on welcome page
    And Verify the Title on login page
    When User enters Username and password on login page
    And Click "Login" button on login page
    Then Verify the Cogmento logo on dashboard page
    Then User is navigate to Deals page page
    And verifies the Deals Title
    Then Click on create button in Deals page
    And user enter the fields in Deals module
    When User is click on save button
    And User is see the information on Deals page are created
    Then user is delete the created Deals
    And verify the deal is deleted