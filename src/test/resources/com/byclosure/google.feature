Feature: Search for "byclosure"
  As an Internet User
  I want to access Google
  So that I can search something on the Internet
  
  @bugfeature
  Scenario: Search for Byclosure
    Given I am in "http://www.google.com"
    When I search for "Byclosure"
    Then I should see a list of results referring to "Byclosure"
    
  @newtag
  Scenario: Search for ByclosureXXX
    Given I am in "http://www.google.com"
    When I search for "ByclosureXXX"
    Then I should see a list of results referring to "ByclosureXXX"