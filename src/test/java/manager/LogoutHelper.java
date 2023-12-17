package manager;

import org.openqa.selenium.By;

public class LogoutHelper extends BaseHelper{

    By btnMenuAvatar = By.xpath("//div[@data-testid='header-member-menu-avatar']/span");
    By btnLogoutInMenuAvatar = By.xpath("//button[@data-testid='account-menu-logout']");
    By btnLogout = By.xpath("//button[@data-testid='logout-button']");


    public void logout() {
        clickBase(btnMenuAvatar);
        clickBase(btnLogoutInMenuAvatar);
        clickBase(btnLogout);
    }
}