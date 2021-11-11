@login
Feature:


  Scenario: Login with valid credentials
    Given the user is on the login page
   When the user enters username and password
   Then the user should see the Account Summary page

  Scenario: Login with invalid credentials
    Given the user is on the login page
    When the user enters wrong username and password
    Then the user should see the error message

  Scenario: Login with blank credentials
    Given the user is on the login page
    When the user do not enter username and password
    Then the user should see the error message


