Feature: User management
  Business rules

    @deleteAllUsers @sanity
    Scenario: User created
      Given I create a user
      Then User is saved