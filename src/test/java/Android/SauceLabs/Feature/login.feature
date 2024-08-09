Feature: Login swag labs mobile app Feature

#  Scenario Outline:  Login with invalid credentials
#    Given Navigate to login Screen
#    When I enter "<username_scenario>" username "<username>" and "<password_scenario>" password "<password>"
#    And I click the login button
#    Then I should see an error message with error message is "<Message>"
#Examples:
#



  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I enter username "<UserName>"
    And I enter password "<Password>"
    When I tap on the login button
    Then I should be logged in successfully

    Examples:
      |UserName|Password|
    |standard_user|secret_sauce|


  Scenario Outline: Successful login with invalid credentials
    Given I am on the login page
    When I enter username "<UserName>"
    And I enter password "<Password>"
    When I tap on the login button
    Then i Have To Get Error Message "<Message>"

    Examples:
      |UserName|Password|Message|
      |standard_user|secret_sauce|
      |standard_user|secret_saucedd|