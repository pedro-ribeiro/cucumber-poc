Feature: Search for "yahoo"
  As an Internet User
  I want to access Google
  So that I can search "yahoo"

  Scenario: Search for Yahoo
    Given I am in "http://www.google.com"
    When I search for "yahoo"
    Then I should see a list of results referring to "yahoo"