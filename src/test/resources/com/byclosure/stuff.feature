Feature: Search for "stuff"
  As an Internet User
  I want to access Google
  So that I can search something on the Internet

  @peter @wip @byclosure
  Scenario: Search for Byclosure in Progress
    Given I am in "http://www.google.com"
    When I search for "Byclosure"
    Then I should see a list of results referring to "Byclosure"
	

  Scenario: Search for Byclosure with multiple details
    Given I am in "http://www.google.com"
    When I search for "Byclosure"
    Then I should see the following details:
		| type | value |
		|results|370000|
		|duration|0.27|
		|address|lisbon|
		
		
  Scenario Outline: Search for several terms
    Given I am in "http://www.google.com"
    When I search for "<term>"
    Then I should see a list of results referring to "<term>"
	
	Examples:
    |term|
    |lycos|
	|astalavista|