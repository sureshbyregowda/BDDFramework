Feature: Account Registration
  As a customer
  In order to use the application
  He/She wants to register first with the deatils Name, Email address, Phone number, Date of birth and password details.

  @Registration
  Scenario: User successfully creates a fego vemos account
		Given User is on the Registration page
		When User enters all required registration details
				 | Name   | Email Address | country code | Phone Number | Day | Month | Year | Password   |
				 | suresh | suresh.byregowda@gmail.com | India +91		 |  9591647572  | 24  | May    | 1982 | xxxxxyyyyy |				 
		Then a fego vemos account is created 