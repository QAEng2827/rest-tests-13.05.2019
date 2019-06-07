How to switch rest-assured project to Serenity'

1. Open pom.xml and replace io.rest-assured dependency to serenity-bdd.rest-assured 
(https://mvnrepository.com/artifact/net.serenity-bdd/serenity-junit/2.0.50)
2. To change RestAssured.given() to SerenityRest.given(), add for logging
 SerenityRest.enableLoggingOfRequestAndResponseIfValidationFails();

3. To enable defoult Serenity logging add dependency org.slf4 
          (https://mvnrepository.com/artifact/org.slf4j/slf4j-simple)

4. For JavaObj To JSON serialisation add dependency 
          https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind 
5.  Add @Step annotation marks above methods  in test units
6.   You should add Serenity annotation @RunWith(SerenityRunner.class) above test class. 
     It let you run the JUnit test using the Serenity test runner.
7. Add @Steps annotation marks a Serenity step library, above the instanse test page class.
8. Change dependency java-unit  to  serenity-junit 
(https://mvnrepository.com/artifact/net.serenity-bdd/serenity-junit)
9.