import Clients.CommonClient;
import Utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommentsClientTests {

    @Test(description = "verify valid email ids count for valid post id")
    public void verifyValidEmailCountForValidPostId() {
        Assert.assertEquals(new CommonClient().commentClient.getValidEmailCount(TestData.VALIDPOSTID),5,"email count is not matched");
    }
    @Test(description = "verify invalid email ids count for valid post id")
    public void verifyInValidEmailCountForValidPostId() {
        Assert.assertEquals(new CommonClient().commentClient.getInvalidEmailCount(TestData.VALIDPOSTID),0,"email count is not matched");
    }

    @Test(description = "verify valid email ids count for invalid post id")
    public void verifyValidEmailCountForInValidPostId() {
        Assert.assertEquals(new CommonClient().commentClient.getValidEmailCount(TestData.INVALIDPOSTID),0,"email count is not matched");
    }
    @Test(description = "verify invalid email ids count for invalid post id")
    public void verifyInValidEmailCountForINValidPostId() {
        Assert.assertEquals(new CommonClient().commentClient.getInvalidEmailCount(TestData.INVALIDPOSTID),0,"email count is not matched");
    }
}
