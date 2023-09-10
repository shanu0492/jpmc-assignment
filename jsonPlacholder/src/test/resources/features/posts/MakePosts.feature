Feature: Get posts endpoint to get all posts from  json placeholder application

  Background:
    Given user has access to endpoint "/posts"

  Scenario: To validate status code and schema of get posts endpoint
    When user hits the request
    Then user should get the response code 200
    And validate the getPosts response by deserializing


  Scenario: To validate all post Id's are unique
    When user hits the request
    And validate the getPosts response by deserializing
    Then validate all id and titles are unique


  Scenario Outline: To validate filter of post on basis of id
    When user hits the request with <ID> as query param
    And validate the getPosts response by deserializing
    Then validate all post of id <ID> are in response
    Examples:
      | ID |
      | 1  |
      | 2  |
