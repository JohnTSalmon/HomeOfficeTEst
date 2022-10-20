Feature: Cazoo Website

  Scenario Outline: Car details correlate to registration
    Given The car '<registration>' and '<make>' and '<model>' and '<colour>' and '<year>'
    When I access the Cazoo Website
    Then Cazoo displays the correct details
    Examples:
      | registration | make       | model                      | colour | year |
      | SG18HTN      | Volkswagen | Golf Se Navigation Tsi Evo | White  | 2018 |
      | BW57BOF      | Toyota     | Yaris T2                   | Red    | 2008 |
      | KT17DLX      | Skoda      | Superb Sportline Tdi S-A   | White  | 2017 |
