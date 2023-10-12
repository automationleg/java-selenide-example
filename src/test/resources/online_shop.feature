Feature: Online shoping scenarios

  Scenario: Buy a mobile phone
    Given Browser open with page www.demoblaze.com
    When Select product "Sony xperia z5" from product card
    Then Product Page is opened with displayed title "Sony xperia z5"
    When Add product to Cart
    And Click on "Cart" button from Navigation panel
    Then Cart Page is opened with 1 product in shopping cart

  Scenario: Buy a laptop
    Given Browser open with page www.demoblaze.com
    When Select "Laptops" from Categories
    And Select product "MacBook air" from product card
    Then Product Page is opened with displayed title "MacBook air"
    When Add product to Cart
    And Click on "Cart" button from Navigation panel
    Then Cart Page is opened with 1 product in shopping cart