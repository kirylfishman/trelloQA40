package tests;

import data.DataProviderLogin;
import dto.UserDTOLombok;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTests extends BaseTest{

    @AfterMethod(alwaysRun = true)
    public void postCondAfterMethod(Method method) {
        if(flagNeedLogout) {
            logoutHelper.logout();
            flagNeedLogout = false;
            logger.info("flagNeedLogout = " + flagNeedLogout);
            logger.info("method info: " + method.getName());
        } else if (flagNeedOpenMainPage) {
            ApplicationManager.navigateToMainPage();
            flagNeedOpenMainPage = false;
            logger.info("flagNeedOpenMainPage = " + flagNeedOpenMainPage);
        }
        // if login todo logout
        //if error sign up - just go to main page
    }

    @Test(groups = {"smoke"},dataProvider = "usersPositiveData",dataProviderClass = DataProviderLogin.class)
    public void positiveLoginTest(UserDTOLombok userD) {
        loginHelper.login(userD);
        flagNeedLogout = true;
        logger.info("flagNeedLogout = " + flagNeedLogout);
        Assert.assertTrue(loginHelper.validateTextBoardsExist());
    }
    @Test(groups = {"smoke"},dataProvider = "loginCSV",dataProviderClass = DataProviderLogin.class)
    public void positiveLoginTest2(UserDTOLombok userD) {
        loginHelper.login(userD);
        flagNeedLogout = true;
        logger.info("flagNeedLogout = " + flagNeedLogout);
        Assert.assertTrue(loginHelper.validateTextBoardsExist());
    }

    @Test(dataProvider = "usersNegativeData",dataProviderClass = DataProviderLogin.class)
    public void negativeEmailValidNotExistTest(UserDTOLombok userB) {
        loginHelper.clickBtnLoginMainPage();
        loginHelper.printEmailForLogin("fishmank89@gmail.com");
        loginHelper.clickBtnSubmitEmailForLogin();
        flagNeedOpenMainPage = true;
        logger.info("flagNeedOpenMainPage = " + flagNeedOpenMainPage);
        Assert.assertTrue(loginHelper.validateTextSignUpH5Displays());
    }

//    @Test
//    public void LoginPositiveUserDto() {
//        UserDTO user =
//                new UserDTO("juliagordyin@gmail.com",
//                        "123456Aa$");
//        loginHelper.loginUserDto(user);
//        Assert.assertTrue(loginHelper.validateTextBoardsExist());
//    }

//    @Test
//    public void LoginTestPositiveUserDtoWith() {
////        UserDTO user =
////                new UserDTO("juliagordyin@gmail.com",
////                        "123456Aa$");
////        user.setEmail("dfgbjkhfb");
////        UserDTO user2 = new UserDTO();
////
////
////        UserDTOWith u1 = new UserDTOWith();
////        UserDTOWith u2 = new UserDTOWith().withEmail("email");
////        u1.withEmail("email").withPassword("djfnr");
////        UserDTOWith u3 = new UserDTOWith().withPassword("ppp");
//        UserDTOWith userWith = new UserDTOWith()
//                .withEmail("juliagordyin@gmail.com")
//                .withPassword("123456Aa$");
//        loginHelper.loginUserDtoWith(userWith);
//        Assert.assertTrue(loginHelper.validateTextBoardsExist());
//    }
}