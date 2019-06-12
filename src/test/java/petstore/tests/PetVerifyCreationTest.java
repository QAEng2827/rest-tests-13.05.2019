package petstore.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import petstore.endpoints.PetEndpoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="C:\\Users\\nakopyuk_i\\IdeaProjects\\rest-tests-13.05.2019\\src\\test\\java\\petstore\\tests\\petNameCodeStatus.csv")
public class PetVerifyCreationTest {
 //   @TestData
//    public static Collection<Object[]> testData() {
//        return Arrays.asList(new Object[][]{
//                // { name, statusCode},
//                {"Urus"}
////                {"Urba", 200},
////                {" ", 400},// swagger допускает, но я хочу, чтоб моя программа не допускала
////                {15, 200},
////                {"", 400},
////                {"Длинное_предлиноеИмяПитомца", 200},
////                {"АААААААААААААААААААААААААААААААААААААААААА! Какое Длинное_предлиноеИмяПитомца", 500},
////                // { LongNameOfPetWithoutQuotes,400}
//
//        });
//    }

    private  String petName;
    private  int codeStatus;
//    public PetVerifyCreationTest(){
//        this.namePet = new  namePet;
//        this.codeStatus = codeStatus;
//    }

//    public PetVerifyCreationTest(String namePet, int codeStatus){
//        this.namePet = namePet;
//        this.codeStatus = codeStatus;
//    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setCodeStatus(int codeStatus) {
        this.codeStatus = codeStatus;
    }


//    }


    @Steps
    private PetEndpoint petEndpoint;

    private PetModel petModel;

// @Before
//    public void preCondition() {
//        petModel = new PetModel(
//                2828,
//                new CategoryModel(),
//
//                //"Urus",
//                namePet,
//                new String[]{"www.zoo2019.com"},
//                new TagModel[]{new TagModel()},
//                "AVAILABLE"
//        );
//
//    }
//
//    @After
//    public void postCondition() {
//        petEndpoint
//                .deletePet(petModel.getId())
//                .statusCode(codeStatus);
//
//    }

    @Test
    public void veryfyCreationPetTest(){
        petModel = new PetModel(
                2728,
                new CategoryModel(),
                petName,
                new String[]{"www.zoo2019.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE"
        );

        petEndpoint
                .createPet(petModel)
                .statusCode(codeStatus);

    }


//    public void updatePetTest() {
//        petModel.setName("Urban");
//        petModel.setStatus("SOLD");
//
//
//        petEndpoint
//                .updatePet(petModel)
//                .statusCode(200);
//
//        petEndpoint
//                .getPetById(petModel.getId())
//                .statusCode(200);
//    }
}
