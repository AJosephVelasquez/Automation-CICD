@tag
Feature: Purchase the order from E-commerce website
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce page

  @tag2
  Scenario Outline: Positive test of Submitting the order
    Given that the user is logged in with email <email> and password <password>
    When user adds product <desiredProduct> to his Cart
    And checks out with <desiredProduct>
    And submits the order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation Page.

    Examples: 
      |       email            |      password     |   desiredProduct     |
      | viktormagnus@gmail.com |     Password123   |     ZARA COAT 3      |
      | magnusviktor@gmail.com |     Password123   |   ADIDAS ORIGINAL    |
