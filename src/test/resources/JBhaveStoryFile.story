Narrative: While Sending messages to the RabbitMQ Server
As a external service
I want to receive data from the SonarQube API.
  
Scenario: 1 the data received from the SonarQube is valid persist project list data to database
Given the request has all fields populated with valid values
When I receive a valid request from the other service
Then the GET response and persist project list data to database
    
     
Scenario: 2 the sent requests received from another service has missing fields dont send a message to the rabbitmq server
Given the request does not have all needed fields populated
When I receive an invalid request from another service
Then I should return an error message 