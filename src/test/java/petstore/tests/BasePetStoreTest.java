package petstore.tests;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import petstore.endpoints.Config;
import petstore.endpoints.PetEndpoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

public class BasePetStoreTest {
    PetEndpoint petEndpoint=new PetEndpoint();

    public int petId = 2728;
    public String petName = "Upir";

    public int newPetId = 12827;
    public String newPetName = "Umertvie";
    public String newStatus = "SOLD";

    @Before
    public void before() {

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


    @After
    public void after() {
        petEndpoint
                .deletePet(newPetId)
                .statusCode(200);



        // проверяем, удален ли

        petEndpoint
                .getPetById(petId)
                .statusCode(200);
    }
}

