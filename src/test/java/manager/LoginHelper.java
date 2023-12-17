package manager;

import dto.UserDTO;
import dto.UserDTOLombok;
import dto.UserDTOWith;
import org.openqa.selenium.By;

public class LoginHelper extends BaseHelper{

    /*
            clickBase(By.xpath("//a[contains(@data-uuid, 'login')]"));
        sendKeysBase(By.xpath("//input[@id='username']"), "juliagordyin@gmail.com");
        clickBase(By.xpath("//button[@id='login-submit']"));
        sendKeysBase(By.xpath("//input[@id='password']"), "123456Aa$");
        clickBase(By.xpath("//button[@id='login-submit']"));
        String boardText = driver.findElement(By.xpath("//span[text()='Boards']")).getText();
        Assert.assertEquals(boardText, "Boards", "text not Boards");
     */

    By btnLoginMainPage = By.xpath("//a[contains(@data-uuid, 'login')]");
    By inputEmail = By.xpath("//input[@id='username']");
    By btnSubmitEmailPassword = By.xpath("//button[@id='login-submit']");
    By inputPassword = By.xpath("//input[@id='password']");
    By textBoards = By.xpath("//span[text()='Boards']");
    By textH5SignUp = By.xpath("//h5");

    public void login(UserDTOLombok user) {
        //  clickBase(btnLoginMainPage);
        clickBtnLoginMainPage();
        //    sendKeysBase(inputEmail, user.getEmail());
        printEmailForLogin(user.getEmail());
        //    clickBase(btnSubmitEmailPassword);
        clickBtnSubmitEmailForLogin();
        //    sendKeysBase(inputPassword, user.getPassword());
        printPasswordForLogin(user.getPassword());
        //    clickBase(btnSubmitEmailPassword);
        clickBtnSubmitEmailPassword();
    }

    public void clickBtnLoginMainPage() {
        clickBase(btnLoginMainPage);
    }

    public void printEmailForLogin(String email) {
        sendKeysBase(inputEmail, email);
    }

    public void clickBtnSubmitEmailForLogin() {
        clickBase(btnSubmitEmailPassword);
    }

    public void printPasswordForLogin(String password) {
        sendKeysBase(inputPassword, password);
    }

    public void clickBtnSubmitEmailPassword() {
        clickBase(btnSubmitEmailPassword);
    }

    public boolean validateTextBoardsExist() {
        return isTextActualEqualToExpected(textBoards, "Boards");
    }
    public boolean validateTextSignUpH5Displays(){
        return isTextActualEqualToExpected2Strings(textH5SignUp, "Sign up to continue", "LOG IN TO CONTINUE");
    }

//    public void loginUserDtoWith(UserDTOWith user) {
//        clickBase(btnLoginMainPage);
//        sendKeysBase(inputEmail, user.getEmail());
//        clickBase(btnSubmitEmailPassword);
//        sendKeysBase(inputPassword, user.getPassword());
//        clickBase(btnSubmitEmailPassword);
//    }

    //    public void loginUserDto(UserDTO user) {
//        clickBase(btnLoginMainPage);
//        sendKeysBase(inputEmail, user.getEmail());
//        clickBase(btnSubmitEmailPassword);
//        sendKeysBase(inputPassword, user.getPassword());
//        clickBase(btnSubmitEmailPassword);
//    }
}