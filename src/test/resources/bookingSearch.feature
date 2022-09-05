Feature: Booking search
  Scenario Outline: Checking the name and rating of the hotel
    Given Word for search is "<searchWord>"
    When I navigate to booking.com
    And I enters search word
    And I press search button
    Then There is a hotel with this name
    And Hotel rating "<expected rating>"
    Examples:
      | searchWord            | expected rating |
      | Willing Hotel         | 8.9             |
      | Fitzrovia Hotel       | 7.9             |


