Feature: Get comments endpoint to get all posts from  json placeholder application

  Background:
    Given user has access to endpoint "/comments"

  Scenario: To validate schema and status code of get comments endpoint
    When user hits the request
    Then user should get the response code 200
    And validate the getComments response by deserializing

  Scenario: To validate email Id is in valid format
    When user hits the request
    And validate the getComments response by deserializing
    Then validate email-Id is valid

  Scenario: To validate comment Id is unique
    When user hits the request
    And validate the getComments response by deserializing
    Then validate comment ID is unique


  Scenario Outline: To validate filter comments on basis of id
    When user hits the request with <ID> as query param
    And validate the getComments response by deserializing
    Then validate all comments of id <ID> are in response
    Examples:
      | ID |
      | 1  |
      | 2  |
