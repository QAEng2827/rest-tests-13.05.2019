package petstore.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import petstore.endpoints.PetImageEndpoint;

@RunWith(SerenityRunner.class)
public class PetUploadImageTest {
    @Steps
   private PetImageEndpoint petImageEndpoint;
@Test
    public  void petUploadImageTest() {
        String fileImageName="testSample1.gif";

        petImageEndpoint

                .uploadImagePet(1, fileImageName)
                .statusCode(200);
    }
}
