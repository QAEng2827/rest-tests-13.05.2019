package petstore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndpoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

import static petstore.endpoints.PetEndpoint.*;

@Concurrent(threads = "2")
@RunWith(SerenityRunner.class)
public class PetStoreTest {
    @Steps
    private PetEndpoint petEndpoint;
    private PetModel petModel;

    @Test
    public void getPetByIdTest() throws InterruptedException {
        Thread.sleep(3000);
        int petId = 2;
        petEndpoint
                .getPetById(petId)
                .statusCode(200);
    }

    @Test
    public void getPetByStatusTest() throws InterruptedException {
        Thread.sleep(3000);
        for (Status status : Status.values()) {
            petEndpoint
                    .getPetByStatus(status)
                    .statusCode(200);
        }
    }

    @Test
    public void createPetTest() throws InterruptedException {
        Thread.sleep(3000);
        PetModel petModel = new PetModel(
                13,
                new CategoryModel(),
                "Zombie",
                new String[]{"www.zoo.com"},
                new TagModel[]{new TagModel()},
                "AVAILABLE");

        petEndpoint
                .createPet(petModel)
                .statusCode(200);
        petEndpoint
                .deletePet(petModel.getId())
               .statusCode(200);
    }
//    @Test
//    public void deletePetIdTest() throws InterruptedException {
//
//        Thread.sleep(5000);
//        petEndpoint
//                .deletePet(petModel.getId())
//                .statusCode(200);
//    }


}
