Feature: Get users endpoint to get all users from  json placeholder application

  Background:
    Given user has access to endpoint "/users"

  Scenario: To validate schema and status code of get users endpoint
    When user hits the request
    Then user should get the response code 200
    And validate the getUsers response by deserializing

  Scenario: To validate email Id is valid and unique per user
    When user hits the request
    And validate the getUsers response by deserializing
    Then validate email-Id is valid in user request
    And email-Id is unique per user

  Scenario: To validate userName is unique
    When user hits the request
    And validate the getUsers response by deserializing
    Then validate user name is unique

  Scenario: To validate phone number is valid
    When user hits the request
    And validate the getUsers response by deserializing
    Then validate phone number is valid in user request

  Scenario Outline: To validate filter of user on basis of id
    When user hits the request with <ID> as query param
    And validate the getUsers response by deserializing
    Then validate all users of id <ID> are in response
    Examples:
      | ID |
      | 1  |
      | 2  |
