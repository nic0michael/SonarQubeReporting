# SonarQubeReporting

This project was written to be able to extract data from a SonarQube Server into a MySQL database  
providing our own additional fields for reporting purposes.   

In this project we provide links to manually download the :   

  * SonarQube Projects List
  * SonarQube Issues for a project  

The project  [RabbitMQProducerMicroservice ](https://github.com/nic0michael/RabbitMQProducerMicroservice/blob/master/SonarQubeInstallationAndTesting.md)  was built using Industry Best Practices.  
This project is used to provide a test report for that project


## SonarQube Installation both Server and Docker installations
For installation procedures please refer to our document :   
[SonarQubeInstallationAndTesting in our RabbitMQProducerMicroservice project](https://github.com/nic0michael/RabbitMQProducerMicroservice/blob/master/SonarQubeInstallationAndTesting.md)

## What we are testing here
In this project we are testing our [RabbitMQProducerMicroservice project](https://github.com/nic0michael/RabbitMQProducerMicroservice).   
Running in a docker container with SonarQube also running in a Docker Container.   
We are using Portainer to manage and launch our Docker containers.     
Information on how to install [Portainer is available here](https://github.com/nic0michael/RabbitMQProducerMicroservice/blob/master/Portainer.md).   
You should be able to edit the page SonarQubeReporting/src/main/resources/templates/upload.html   
and add your own links to your project

## Manual Upload is working
The  Manual Upload is working.     

We were not able to figure out  how to create a WsClient or a Client to call the SonarQube API .   

**Using credentials :**   
	private final String TOKEN="2ce06b3585c34141beeeb4005235337ba2bd135d";   
	private final String USERNAME="admin";   
	private final String PASSWORD="admin";   
This is in class :  SonarQubeReporting/src/main/java/za/co/nico/poc/services/SonarServiceImpl.java

If you know how to do that please send us an email to :  nicomichael2018 AT yahoo DOT COM.

## We have 12 other projects in Github  
[https://github.com/nic0michael?tab=repositories](https://github.com/nic0michael?tab=repositories)

## Free Open Source FOS with the License based on GPL Version 3
This project is Free Open Source code FOS.
We provide this Project as free of charge and subject to the terms and license of this project is GPL Version 3.
As this is Free Open Source Project you are welcome to make a fork of this project for commercial use.
In return for that please give the author of this project credit in your MD keeping the next line:
The Source of this project if Forked from GitHub and is Free for Commercial use.

## No Warranty is provided or implied
This software is provided in terms of South African law as : "VOETS TOETS" "AS IS" (in English) with no warranty and no Guarantee provided or implied That the user shall agree to comply with these terms when using this software.

## Tools used :
[https://jsonformatter.curiousconcept.com/#](https://jsonformatter.curiousconcept.com/#).   
[https://mariadb.com/kb/en/installing-mariadb-msi-packages-on-windows/](https://mariadb.com/kb/en/installing-mariadb-msi-packages-on-windows/).   
[https://www.youtube.com/watch?v=s39ENZ9mLmA](https://www.youtube.com/watch?v=s39ENZ9mLmA).   



