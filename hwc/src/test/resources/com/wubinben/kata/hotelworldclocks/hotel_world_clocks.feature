Feature: Kata Hotel World Clocks
  In order to adjust the time of clocks of different cities in the lobby of a hotel as easily as possible,
  As a employee of the hotel,
  I want to adjust the time of any one clock and the time of all other clocks will be adjusted automatically.

  Scenario: Adjust the incorrect time of Beijing
    Given a hotel lobby has five clocks
    And "London" is in the DST period
    And "New York" is in the DST period
    And "Beijing" does not use the DST
    And "Moscow" does not use the DST
    And "Sydney" does not use the DST
    When I adjust the incorrect time of the clock of "Beijing" to be 9
    Then the time of the clock of "Beijing" should be 9
    And the time of the clock of "London" should be 2
    And the time of the clock of "Moscow" should be 5
    And the time of the clock of "Sydney" should be 11
    And the time of the clock of "New York" should be 21

  Scenario: The daylight saving period of London ends
    Given a hotel lobby has five clocks
    And the DST period of "London" ends
    And the DST period of "New York" does not end
    And "Beijing" does not use the DST
    And "Moscow" does not use the DST
    And "Sydney" does not use the DST
    When I adjust the time of the clock of "London" to be 0 due to the end of DST
    Then the time of the clock of "Beijing" should be 8
    And the time of the clock of "London" should be 0
    And the time of the clock of "Moscow" should be 4
    And the time of the clock of "Sydney" should be 10
    And the time of the clock of "New York" should be 20

