Feature: Login swag labs mobile app Feature

#  Scenario Outline:  Login with invalid credentials
#    Given Navigate to login Screen
#    When I enter "<username_scenario>" username "<username>" and "<password_scenario>" password "<password>"
#    And I click the login button
#    Then I should see an error message with error message is "<Message>"
#Examples:
#



  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    Then I should be logged in successfully