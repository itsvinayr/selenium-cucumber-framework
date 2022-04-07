Feature: Product Search
  @Functional
  Scenario Outline: Get Product Price
    Given user lands on home page
    When user search for <value>
    Then open first one from the product list and get the price
    Examples:
    |value|
    |macbook|
    |dell   |
    |asus   |