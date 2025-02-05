Feature: Adding new users
  As an admin
  I should be able to add new users

  Background:
    Given the user is on the login page
    When the users logins with "Admin" userName and "admin123" password
    Then the user must be logged in

  @smoke
  Scenario Outline: Filtering of users based on User Role
    Given I'm in admin module
    When I select a filter users based on a "<user role>"
    Then the users should be filtered based on the selected "<user role>"

    Examples:
    | user role |
    | Admin     |
    | ESS       |

  @test
  Scenario: Passing data table
    Given the below data table
    | column 1 | column 2 | column 3 |
    | asfa     | sdfsd    | sfsd     |
    | aw43fs   | jhgj     | wsw45s   |

