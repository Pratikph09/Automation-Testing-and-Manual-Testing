Feature: Login, PunchIn, and Add Customer Automation

  Scenario Outline: Automate Login and verify PunchIn message
    Given the user is on the login page
    When the user enters username "<username>" and password "<password>"
    And the user clicks the login button
    Then the user should be redirected to the dashboard
    When the user clicks the PunchIn button
    Then the toast message should display "PunchIn successful"

    Examples:
      | username   | password   |
      | validUser  | validPass  |
      | invalidUser| invalidPass|

  Scenario Outline: Add Customer and validate
    Given the user is on the dashboard
    When the user navigates to add customer page
    And the user enters customer name "<customerName>" and details "<customerDetails>"
    And the user clicks the add customer button
    Then the customer should be added successfully with message "Customer added successfully"

    Examples:
      | customerName | customerDetails |
      | TestCustomer | TestDetails     |
