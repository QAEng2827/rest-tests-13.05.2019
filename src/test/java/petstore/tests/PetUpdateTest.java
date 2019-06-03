package petstore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndpoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

@RunWith(SerenityRunner.class)
public class PetUpdateTest {
    @Steps
    private PetEndpoint petEndpoint = new PetEndpoint();
    private PetModel petModel;

    @Before
    public void preCondition() {
        petModel = new PetModel(
                28,
                new CategoryModel(),
                "Urus",
                new String[]{"www.zoo2019.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE"
        );
        petEndpoint
                .createPet(petModel)
                .statusCode(200);
    }

    @After
    public void postCondition() {
        petEndpoint
                .deletePet(petModel.getId())
                .statusCode(200);

    }

    @Test
    public void updatePetTest() {
      petModel.setName("Urban");
      petModel.setStatus("SOLD");


        petEndpoint
                .updatePet(petModel)
                .statusCode(200);

petEndpoint
        .getPetById(petModel.getId())
        .statusCode(200);
    }
}
