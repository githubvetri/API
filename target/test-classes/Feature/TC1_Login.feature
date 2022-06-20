@Login
Feature: Login module API automation

  Scenario: Get user logtoken from user login
    Given User add headers
    When User send "POST" request for login endpoint
    Then User verify the status code is 200
    And User verify the response body firstname present as "VENKATACHALAM R" and the logtoken saved
