Feature: Car Tax Check Website

Scenario: Test car details correlate to registration
  Given I have a file of car registrations
  When I access the Car Tax Check Website
  Then Car Tax Check displays the correct details