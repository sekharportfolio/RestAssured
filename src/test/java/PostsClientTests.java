import Clients.CommonClient;
import Utilities.ReportHelper;
import Utilities.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostsClientTests  extends ReportHelper {

    @Test(description = "verify post id for valid user")
    public void verifyPostIDForValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostId(TestData.VALIDUSERID),81,"posts count are not matched");
    }
    @Test(description = "verify post count for valid user")
    public void verifyPostCountForValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostCount(TestData.VALIDUSERID),10,"posts count are not matched");
    }
    @Test(description = "verify post client status code for valid user")
    public void verifyPostClientStatusCodeForValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostClientStatusCode(TestData.VALIDUSERID),200,"wrong status code");
    }

    @Test(description = "verify post count for invalid user")
    public void verifyPostCountForInValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostCount(TestData.INVALIDUSERID),0,"posts count are not matched");
    }
    @Test(description = "verify post client status code for invalid user")
    public void verifyPostClientStatusCodeForInValidUser() {
        Assert.assertEquals(new CommonClient().postsClient.getPostClientStatusCode(TestData.INVALIDUSERID),200,"wrong status code");
    }
}
