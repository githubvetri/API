@ProfilePic
Feature: Profile module API Automation

  Scenario: User should change the profile picture
    Given User should add the headers
    When User should send "POST" request for Updateprofilepic endpoint
    Then User verify the status code is 200
    And User should verify the response body of update profilepic message present as "Profile updated Successfully"
