package petstore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndpoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

import static petstore.endpoints.PetEndpoint.*;

@RunWith(SerenityRunner.class)
public class PetStoreTest {
    @Steps
    private PetEndpoint petEndpoint ;


    int petId = 2728;
    int newPetId = 12827;
    String petName = "Umertvie";
    String newPetName = "Upir";
    String responseStatusUpPet;

    @Test
    public void getPetIdTest() {

       // int petId = 2;
        petEndpoint
                .getPetById(petId)
                .statusCode(200);
    }

    @Test
    public void getPetByStatusTest() {

        for (Status status : Status.values()) {
            petEndpoint
                    .getPetByStatus(status)
                    .statusCode(200);
        }
    }

    @Test
    public void createPetTest() {
        PetModel petModel = new PetModel(
                petId,
                new CategoryModel(),
                petName,
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVALABLE"
        );
        petEndpoint
                .createPet(petModel)
                .statusCode(200);

    }



    @Test
    public void deletePetIdTest() {
        petEndpoint
                .deletePet(petId)
                .statusCode(200);
    }


}
