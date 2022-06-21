Feature: Pet management
  Business rules

  Scenario: List pets available
    Given I have available pets
    When I search for available pets
    Then I see the list of available pets

  Scenario: List pets pending
    Given I have pending pets
    When I search for pending pets
    Then I see the list with 2 pets

  Scenario: List pets sold
    Given I do not have sold pets
    When I search for sold pets
    Then I see the list with 0 pet