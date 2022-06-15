Feature: User management
  Business rules

  Scenario: Create a user
    When I do a post to /v3/user with:
      | id         | 10             |
      | username   | theUser        |
      | firstName  | John           |
      | lastName   | James          |
      | email      | john@email.com |
      | password   | 12345          |
      | phone      | 12345          |
      | userStatus | 1              |
    Then I do get /v3/user/theUser, the user created is returned

  Scenario: Create a user - json
    When I do a post to /v3/user with docstring:
      """ json
      {
        "id": 10,
        "username": "theUser",
        "firstName": "John",
        "lastName": "James",
        "email": "john@email.com",
        "password": "12345",
        "phone": "12345",
        "userStatus": 1
      }
      """
    Then I do get /v3/user/theUser, the user created is returned

    Scenario: User created
      Given I create a user
      Then User is saved