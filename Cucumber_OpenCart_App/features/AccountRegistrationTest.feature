Feature: Account Registration Test

  @Regression
  Scenario: Successful Account Registration
    Given user clicks on register link on the home page
    When user navigates to the Account Registration page
    And user enters the details into below fields
      | firstName | John       |
      | lastName  | Kenedy     |
      | telephone | 1234567890 |
      | password  | test@123   |
    And user accepts the privacy policy
    And user clicks on continue button
    Then the user Account Registers successfully
