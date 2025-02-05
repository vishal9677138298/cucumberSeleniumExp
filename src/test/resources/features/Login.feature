Feature: Login

  As a registered user I want to login into the application

  Scenario: Login with valid credentials
    Given the user is on the login page
    When the users logins with "Admin" userName and "admin123" password
    Then the user must be logged in


  Scenario: Login with invalid credentials
    Given the user is on the login page
    When the users logins with "invalidUsername" userName and "invalidPassword" password
    Then a toast message must be shown for invalid credentials