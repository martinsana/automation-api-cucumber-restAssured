Feature: Pet management
  Business rules

  Scenario Outline: List animals by sale status
    Given I do not have sold pets
    When I search for <status> pets
    Then I see the list with <quantity> pets

    Examples: Storage pets
      | status    | quantity |
      | available | 7        |
      | pending   | 2        |

    Examples: No Storage pets
      | status | quantity |
      | sold   | 0        |