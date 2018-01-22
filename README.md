# marketplace
Technology:
	 Spring boot  - Mircroservices
	 H2 database
	 
Flow:
	 Due to time constraint i could not create user interface. gone ahead with swagger url as the user interface for REST API.
	 also written test case for one flow. 
	 
	 User will be provided with Swagger URL(http://localhost:8080/swagger-ui.html)
	 
	 Project will be created with /project resource
	 User will be created with /user resource
	 Project will be bid by /project/bid resource.
	 
	 A Job will be configured in rundeck that runs at 12.05 AM and picks the lowest bid against the project.
	 user will be notified with an email.
 
 
Design Considerations:
	1.  When a project is created. It is created with OPEN status.
	2.	When a auction is completed it will be moved to CLOSED status
	3.	Users cannot bid for a project in CLOSED status.
	4.	A job will run to assign the project to user.

When the server boots up sample data will be inserted in DB through data.sql.


