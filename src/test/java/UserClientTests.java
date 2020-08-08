import Clients.CommonClient;
import Clients.UserClient;
import Utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserClientTests {

    @Test(description = "verify valid the user")
    public void verifyValidUser() {
        Assert.assertTrue(new CommonClient().userClient.isUserExists(TestData.VALIDUSER),"user is not exist");
        Assert.assertEquals(new CommonClient().userClient.getStatusCode(TestData.VALIDUSER),200,"status code did not match");
    }

    @Test(description = "verify invalid user")
    public void verifyInValidUser() {
        Assert.assertFalse(new CommonClient().userClient.isUserExists(TestData.INVALIDUSER),"user exist");
        Assert.assertEquals(new CommonClient().userClient.getStatusCode(TestData.INVALIDUSER),200,"status code did not match");
    }

    @Test(description = "verify user service for invalid numeric user")
    public void testUserId()  {
        Assert.assertEquals(new CommonClient().userClient.getUserId(TestData.VALIDUSER),TestData.VALIDUSERID,"status code did not match");

    }
}
