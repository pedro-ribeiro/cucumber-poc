Feature: Story proof of concept
  As an Account Holder
  I want to transfer to and from my account
  So that I can manage my money

  Background:
    Given I have a bank account
    And my balance is $100

  @simple
  Scenario: Simple scenario
    When I withdraw $10
    Then my bank account balance should be $90

  @examples
  Scenario Outline: Scenario with Examples
    When I add $<value>
    Then my bank account balance should be $<balance>

    Examples:
      | value | balance |
      | 10    | 110     |
      | 50    | 150     |

  @tables
  Scenario: Scenario with data tables
    Given these people have bank accounts with balances:
      | Name    | balance |
      | Person1 | 1000    |
      | Person2 | 500     |
    When I take all their money
    Then my bank account balance should be $1600