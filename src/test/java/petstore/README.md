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
6.  Add Serenity annotation @RunWith(SerenityRunner.class) above test class. 
     It let you run the JUnit test using the Serenity test runner.
7. Add @Steps annotation marks a Serenity step library, above the instanse test page class.
8. Change dependency java-unit  to  serenity-junit 
(https://mvnrepository.com/artifact/net.serenity-bdd/serenity-junit)
9. Add plagin serenity-maven-plugin (net.serenity-bdd.maven.plugins serenity-maven-plugin 2.0.50 )
10.  Add @RunWith(SerenityParametrizedRunner.class) for using  data-driven Serenity test.
(http://thucydides.info/docs/serenity-staging/#_data_driven_tests)
11. Add @TestData annotation and input test Data.
     @TestData
      public static Collection<Object[]> testData() {
          return Arrays.asList(new Object[][]{
                  // { name, statusCode},
                    {"Urba", 200},
                {" ", 400},
                  {15, 200},
     
  
          });
      }
12.  Then you need to inject The test data into member variables     
    private  String petName;
       private  int codeStatus;  
        
13. Create a constructor with the parameters in the correct order for this to work.
 public PetVerifyCreationTest(String namePet, int codeStatus){
      this.namePet = namePet;
       this.codeStatus = codeStatus;
    }
    
    or 
    
     public void setPetName(String petName) {
      this.petName = petName;
        }
    
        public void setCodeStatus(int codeStatus) {
            this.codeStatus = codeStatus;
        }
       
14. Use these member variables to perform your test/

15. For using test data from CSV files:
    a) create CSV file, by default with columns separated by commas;
    b)add annotation @UseTestDataFrom(value="path/nameOfFile.csv") 
      to indicate where to find the CSV file;
    c)  create a test class containing properties that match the columns in the test data;
    d) The test class will typically contain one or more tests that use these properties 
       as parameters to the test step or Page Object methods.