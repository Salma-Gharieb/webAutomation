Feature: Automated End2End Test
  Scenario Outline: Admin login and add new record and delete the new record
    Given User is on login screen
    When he inserts his credentials "<username>" and "<password>" and login
    And navigates to dashboard
    And navigates to Admin page and check the records
    And navigate to add role page and insert user info "<empName>","<usrName>","<usrPass>"
    Then verify that number of records increased by 1
    And search for newly added user
    Then delete the new user
    And verify that number of records decreased by 1

    Examples:
      |username | password | empName | usrName  | usrPass      |
      |Admin    | admin123 |Org     | testuser | Password@123 |

