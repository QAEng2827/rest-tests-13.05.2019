package petstore;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

public class BasePetStoreTest {
    static {
        RestAssured.baseURI = Config.BASE_URI;
    }

    @Before
    public void before(){

        int petId=2728;
        String petName="Upir";

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

        // проверяем, создан ли

        RestAssured.given()

            //    .log().uri()
                .get(Config.GET_PET_BY_ID, petId)
                .then()
           //     .log().all()
                .statusCode(200);//  проверяет возвращаемій код, прошел ли запрос, если поставить 300 или 400, то тест упадет

    }


    @After
    public void after(){
       int newPetId=12827;

            // newPetId = petId ;
            RestAssured.given()
                    .log().uri()
                    .delete(Config.DELETE_PET_BY_ID, newPetId)
                    .then()
                    .log().all()
                    .statusCode(200);

        // проверяем, удален ли

        RestAssured.given()

                .log().uri()
                .get(Config.GET_PET_BY_ID, newPetId)
                .then()
                .log().all()
                .statusCode(404);//  проверяет возвращаемій код, прошел ли запрос, если поставить 300 или 400, то тест упадет
        }
    }

