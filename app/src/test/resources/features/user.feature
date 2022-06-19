Feature: User management
  Business rules

    @deleteAllUsers
    Scenario: User created
      Given I create a user
      Then User is saved