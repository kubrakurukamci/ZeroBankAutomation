
Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given the user is logged in
    When the user clicks on Savings link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Savings" selected

  Scenario: Brokerage account redirect
    Given the user is logged in
    When the user clicks on Brokerage link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Brokerage" selected

  Scenario: Checking account redirect
    Given the user is logged in
    When the user clicks on Checking link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Checking" selected

  Scenario: Credit Card account redirect
    Given the user is logged in
    When the user clicks on Credit card link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Credit Card" selected

  Scenario: Loan account redirect
    Given the user is logged in
    When the user clicks on Loan link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Loan" selected

  Scenario: Checking all accounts
    Given the user is logged in
    When the user clicks on "Checking" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down shows "Checking" selected

  Scenario: Verifying title
    Given the user is logged in
    When the user clicks on Account Activity module
    Then the title should be "Zero - Account Activity"
  #Snenario should give an error
  Scenario:Verifying the dropdown selected option
    Given the user is logged in
    When the user clicks on Account Activity module
    Then Account drop down default option should be "Savings"

  Scenario: Verifying the dropdown options
    Given the user is logged in
    When the user clicks on Account Activity module
    Then Account dropdown should have the following options
    |Savings|
    | Checking|
    | Loan|
    | Credit Card|
    |Brokerage|
    And Transactions table should have column names
    |Date|
    |Description|
    |Deposit|
    |Withdrawal|



