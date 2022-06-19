Feature: Pet management
  Business rules

  Scenario: List pets available
    Given I have available pets
    When I search for available pets
    Then I see the list of available pets