import Clients.CommonClient;
import Utilities.ReportHelper;
import Utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostsClientTests  extends ReportHelper {

    @Test(description = "verify post id for valid user")
    public void verifyPostIDForValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostId(TestData.VALIDUSERID),81,"post ids are not matched");
    }
    @Test(description = "verify post count for valid user")
    public void verifyPostCountForValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostCount(TestData.VALIDUSERID),10,"post count are not matched");
    }
    @Test(description = "verify post client status code for valid user")
    public void verifyPostClientStatusCodeForValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostClientStatusCode(TestData.VALIDUSERID),200,"status code did not match");
    }

    @Test(description = "verify post count for invalid user")
    public void verifyPostCountForInValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostCount(TestData.INVALIDUSERID),0,"post counts are not matched");
    }
    @Test(description = "verify post client status code for invalid user")
    public void verifyPostClientStatusCodeForInValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostClientStatusCode(TestData.INVALIDUSERID),200,"status code did not match");
    }
}
