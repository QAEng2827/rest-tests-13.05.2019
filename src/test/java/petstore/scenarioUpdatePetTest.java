package petstore;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Test;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

import static org.hamcrest.Matchers.equalTo;

public class scenarioUpdatePetTest extends BasePetStoreTest{
    int newPetId=12827;
    String newPetName="Umertvie";
    String newStatus="SOLD";//;

    @Test
    public void  updatePetScenarioTest(){
        PetModel petModel = new PetModel(
                newPetId,
                new CategoryModel(),
                newPetName,
                new String[]{"www.zoo2019.com"},
                new TagModel[]{new TagModel()},
               "SOLD"// "PENDING"
        );

        RestAssured.given()
                .log().uri()
                .contentType("application/json")//  равнозначна предыдущей
                .body(petModel)
                .post(Config.CREATE_PET)//одинаковый путь с create
                .then()
                .log().all()
                .statusCode(200);

        RestAssured.given()

                .log().uri()
                .get(Config.GET_PET_BY_ID, newPetId)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat().body("status", equalTo(newStatus));//  проверяет статус


    }

}
