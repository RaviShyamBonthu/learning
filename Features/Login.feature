Feature: Login Functionality

Scenario: Login page logo
	Given Launch the Cogmento application
  And Click "Log In" button on welcome page
	And Verify the Title on login page
	When User enters Username and password on login page
	And Click "Login" button on login page
	Then Verify the Cogmento logo on dashboard page
	
	
	