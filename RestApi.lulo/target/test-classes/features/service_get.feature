Feature: Client requests diferent services

  @success
  Scenario: Request get service
    Given The data is used
    |url|statuscode|
    |api/v1/employees|200|
    When the client requests a employees service
    Then the response is a employees list
