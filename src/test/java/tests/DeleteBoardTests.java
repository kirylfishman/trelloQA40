package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteBoardTests extends BaseTest{

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        loginHelper.login(user);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logoutHelper.logout();
    }

    @Test
    public void deleteOneBoardPositive() {
        String name = randomUtils.createString(4);
        boardsHelper.createNewBoard(name);
        boardsHelper.deleteBoardByName(name);
        Assert.assertFalse(boardsHelper.validateBoardExistByName(name));
    }

    // after method navigate to page ???
}