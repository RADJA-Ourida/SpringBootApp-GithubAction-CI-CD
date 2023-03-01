# SpringBootApp-GithubAction-CI-CD
This small application to perform the CI/CD and the deployement to Google Cloud Registry and Google Kubernetes Engine. 
# Requirments : 
 - Any IDE, Intellij for example
 - JDK 17
 -  Docker 
 - PostgreSql
 - Git
 - An account in Google cloud Plateform, create a project and activate the invoicing
 - Have a cluster on Google Kubernetes Engine
 


## To run this application in local machine: 
 - clone the project and run it
 - On the btowser past this :   http://localhost:8000/customer/age 


## To dockerise this application in Local: 
  Two ways to do this : 
  - With Docker-compose, run this on terminal :  
        ./mvnw clean package -Dskiptest
        docker compose up  
  - with Dockerfile only : 
      ./mvnw clean package -Dskiptest
      docker build -t appimg .  //To create the image and store it in Docker 
      docker run -p 9090:8000 appimg
      
      
## The end pointes of the application on Docker : 
   http://localhost:9090/customer/age
   http://localhost:9090/customer/hello/Dani
   http://localhost:9090/customer/newCustomer //Perform this from postman
   
   
   
## TO Deploy in Google Cloud Platform 

The workflow is trigerred automaticly on each push to the main branch. 
If the deployement is successfuly done, we find in GKE -> services & Ingres the URL to our application

   
  
      
       
 
