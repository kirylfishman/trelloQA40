package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddBoardTests extends BaseTest{

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        loginHelper.login(user);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        logoutHelper.logout();
    }

    // after method navigate to page ???

    boolean flagNeedBack = false;
    @AfterMethod
    public void afterMethod() {
        if (flagNeedBack) {
            flagNeedBack = false;
            boardsHelper.navigateBack();
        }
    }

    @Test
    public void addBoardPositiveTest() {
        String name = randomUtils.createString(4);
        boardsHelper.createNewBoard(name);
        boardsHelper.pause(10000);
        flagNeedBack = true;
        Assert.assertTrue(boardsHelper.validateBoardNameOnPageOfBoardCorrect(name));
    }

}