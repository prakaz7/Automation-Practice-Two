Feature: Feature file for login HR portal
	
	Scenario Outline:Login to the CRM HR portal
		Given A user can login to the HR CRM Portal
		When the "<Username>" and "<Password>" is entered
		Then the user can click on the login button
		And can see the dashboard screen.

		Examples:
			| Username | Password |
			| Admin    | admin123 |
			| test     | test213  |
