FROM openjdk:17


#Exposes port 8080, which is the port that the Spring Boot application listens on.
EXPOSE 8000

# copy the file customerApp.jar from the target directory of your local project to
#a file named appimg.jar in the root directory of the container file system.
ADD target/customerApp.jar /appimg.jar


#Set the command to run the Spring Boot application when the container starts.
#This command runs the JAR file using the java command.
ENTRYPOINT ["java","-jar","/appimg.jar"]