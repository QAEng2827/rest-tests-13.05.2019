package petstore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetEndpoint;
import petstore.endpoints.PetImageEndpoint;
import petstore.models.CategoryModel;
import petstore.models.PetModel;
import petstore.models.TagModel;

@RunWith(SerenityRunner.class)
public class PetUploadImageTest {
    @Steps
    private PetImageEndpoint petImageEndpoint;
   // private PetEndpoint petEndpoint;
    private PetModel petModel;
@Test
    public  void petUploadImageTest() {

    String fileImageName="testSample1.gif";

    petModel = new PetModel(
            28,
            new CategoryModel(),
            "Urus",
            new String[]{"www.zoo2019.com"},
            new TagModel[]{new TagModel()},
            "AVAILABLE"
    );


        petImageEndpoint
                .uploadImagePet(petModel.getId(), fileImageName)
                .statusCode(200);
    }
}
