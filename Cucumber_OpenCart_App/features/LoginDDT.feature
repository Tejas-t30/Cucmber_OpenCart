Feature: Testing Login Functionality using excel data

  @regression
  Scenario Outline: Login Data Driven Excel
    Given User clicks on login button on home page
    Then the user should be redirected to the MyAccount Page by passing email and password with excel row "<row_index>"

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
      