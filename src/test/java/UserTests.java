import Clients.CommonClient;
import Clients.UserClient;
import Utilities.TestData;
import org.testng.annotations.Test;

public class UserTests {

    @Test(description = "valid the user")
    public void verifyValidUser() {
        new CommonClient().userClient.isUserExists(TestData.VALIDUSER);
    }

}
