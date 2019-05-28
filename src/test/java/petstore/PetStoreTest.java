package petstore;

import io.restassured.RestAssured;
import org.junit.Test;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

import java.util.ArrayList;

public class PetStoreTest {
    static {
        RestAssured.baseURI = Config.BASE_URI;
    }

    private enum Status {
        AVALABLE,
        PENDING,
        SOLD
    }

    @Test
    public void getPetIdTest() {

        int petId = 27;

        //составляем запрос, парметры берем из строки, котоая была в постмене. используем паттерн-билдер
        RestAssured.given()

                .log().uri()
                .get(Config.GET_PET_BY_ID, petId)
                .then()
                .log().all()
                .statusCode(200);//  проверяет возвращаемій код, прошел ли запрос, если поставить 300 или 400, то тест упадет
    }

    @Test
    public void getPetByStatusTest() {
        for (Status status : Status.values()) {
            RestAssured.given()
                    .log().uri()
                    .param("status", status)
                    .get(Config.GET_PET_BY_STATUSE)
                    .then()
                    .log().all()
                    .statusCode(200);
        }
    }

    @Test
    public void createPetTest() {
        //int id, CategoryModel categoy, String name, String[] photoUrls, TagModel[] tags, String status
        PetModel petModel = new PetModel(
                27,
                new CategoryModel(),
                "Umertvie",
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
    public void uddatePetTest(){
        /*
        * {
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}*/
        PetModel petModel = new PetModel(
                27,
                new CategoryModel(),
                "Umertvie27",
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
        int petId = 27;
        RestAssured.given()
                .log().uri()
                .delete(Config.DELETE_PET_BY_ID, petId)
                .then()
                .log().all()
                .statusCode(200);
    }

}
