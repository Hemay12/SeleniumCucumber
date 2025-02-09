Feature: Login functionality

  Scenario Outline: Logging in a user
    Given the user is on login page
    When the user enters "<username>" and "<password>"
    Then the user should be passORfail "<username>"

  Examples:
    | username                | password   |
    | dummy1233user@gmail.com | Dummy@123 |
    | asdf@asdf.asdf          | asdf      |