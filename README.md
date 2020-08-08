Requirements:
Below dependencies needs to be installed/configured

Java 8 or higher (JAVA_HOME and PATH in environmental variables)
Maven (M2, MAVEN_HOME and PATH in environmental variables)
IDE (IntelliJ is preferred)

Execution:
1. Run via TestNG

Click on the run button on your IDE or right click on your testNG file and click RUN

2. Run via terminal

mvn clean test 

3. Run via circleci pipeline ()

mvn clean test 

##Important points to remember:

Test Report: Test Report is saved in location - TestReport

.gitignore: reports/, .idea/, log/, target/ are covered in .gitignore file
