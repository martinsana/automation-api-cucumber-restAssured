Feature: Orders management

  @DeleteExtraPets @sanity
  Scenario: Client order
    Given I want have an available pet
    When I order for a pet
    Then the order is approved
