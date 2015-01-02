Feature: Search for "byclosure"
  As an Internet User
  I want to access Google
  So that I can search something on the Internet
  
  Background:
    Given I am in "http://www.google.com"

  @bugfeature
  Scenario: Search for Byclosure
    When I search for "Byclosure"
    Then I should see a list of results referring to "ByclosureXXX"