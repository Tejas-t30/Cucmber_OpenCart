Feature: Login functionality test

	Scenario: Login test with one valid user
	Given User clicks on login button on home page
	When user enters email is as "Johnathan@gmail.com" and password as "John@123"
	And clicks on login button 
	Then user lands on MyAccount page