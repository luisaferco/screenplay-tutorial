Feature: Add new items

  @solo
  Scenario: Add items to an empty list
    Given Toby starts with an empty list
    When he adds Buy some milk to his list
    Then the todo list should contain the following items:
      | Buy some milk|



    Scenario: map input
      Given parameters are collected as map
        |header1|header2|header3|header4|
        |"value1" |"value2" |"value3" | "" |
      And parameters are collected as list
        |header1|
        |value1 |
        |value2 |
        |value3 |
      When parameters are transposed in a list
       |header12|value4 |value5 |value6 |
