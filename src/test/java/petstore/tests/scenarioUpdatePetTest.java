package petstore.tests;

import io.restassured.RestAssured;
import org.junit.Test;
import petstore.endpoints.Config;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

import static org.hamcrest.Matchers.equalTo;

public class scenarioUpdatePetTest extends BasePetStoreTest {

    @Test
    public void updatePetScenarioTest() {
        PetModel petModel = new PetModel(
                newPetId,
                new CategoryModel(),
                newPetName,
                new String[]{"www.zoo2019.com"},
                new TagModel[]{new TagModel()},
                "SOLD"
                // "PENDING"
        );

        petEndpoint
                .updatePet(petModel)
                .statusCode(200);

        petEndpoint
                .getPetById(petId)
                .statusCode(200)
                .assertThat()
                .body("status", equalTo(newStatus));//  проверяет статус


    }

}
