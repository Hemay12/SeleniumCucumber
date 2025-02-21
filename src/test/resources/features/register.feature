Feature: User Registration
	
	@Smoke
  Scenario: Register a user
  
    Given the user is on the registration page
    When the user enters all required details
    And clicks on the register button
    Then the user should be successfully registered with confirmation message
