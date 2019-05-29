package petstore;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

public class PetStoreTest {
    static {
        RestAssured.baseURI = Config.BASE_URI;
    }

    private enum Status {
        AVALABLE,
        PENDING,
        SOLD
    }
    int petId = 2728;
    int newPetId=12827;
    String petName="Umertvie";
    String newPetName = "Upir";
    String responseStatusUpPet;

    @Test
    public void getPetIdTest() {

      //  int petId = 27;

        //составляем запрос, парметры берем из строки, котоая была в постмене. используем паттерн-билдер
        ValidatableResponse responseStatus = RestAssured.given()

                .log().uri()
                .get(Config.GET_PET_BY_ID, newPetId)
                .then()
                .log().all()
                .statusCode(200);//  проверяет возвращаемій код, прошел ли запрос, если поставить 300 или 400, то тест упадет

        responseStatusUpPet = responseStatus.extract().asString();
        System.out.println(responseStatusUpPet);
    }

    @Test
    public void getPetByStatusTest() {
        for (Status status : Status.values()) {
            RestAssured.given()
                    .log().uri()
                    .param("status", status)
                    .get(Config.GET_PET_BY_STATUSE)
                    .then()
//                    .log().all()
                    .statusCode(200);


        }
    }

    @Test
    public void createPetTest() {
        //int id, CategoryModel categoy, String name, String[] photoUrls, TagModel[] tags, String status
        PetModel petModel = new PetModel(
                petId,
                new CategoryModel(),
                petName,
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVALABLE"
        );

        RestAssured.given()
                .log().uri()
                .contentType("application/json")//  равнозначна предыдущей
                .body(petModel)
                .post(Config.CREATE_PET)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updatePetTest(){

        PetModel petModel = new PetModel(
                newPetId,
                new CategoryModel(),
                newPetName,
                new String[]{"www.zoo2019.com"},
                new TagModel[]{new TagModel()},
                "SOLD"
        );

        RestAssured.given()
                .log().uri()
                .contentType("application/json")//  равнозначна предыдущей
                .body(petModel)
                .post(Config.CREATE_PET)
                .then()
                .log().all()
                .statusCode(200);



    }

    @Test
    public void deletePetIdTest() {
      // newPetId = petId ;
        RestAssured.given()
                .log().uri()
                .delete(Config.DELETE_PET_BY_ID, newPetId)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void scenarioUpdatePet(){
        createPetTest();
        updatePetTest();
        getPetIdTest();
        deletePetIdTest();

    }
}
