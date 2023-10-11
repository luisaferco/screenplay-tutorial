Feature: Booking flight

  Scenario: Booking a flight with departure and destination
    Given Jenkins navigates to the Flights sections
    When he searches for flights from "Bogota" to "Boston"
    Then he should see information trips
    And he should see the selected departure flight