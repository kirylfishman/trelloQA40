package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BoardsHelper extends BaseHelper{

    By btnCreateNewBoard = By.xpath("//*[@data-testid='create-board-tile']/div");
    By inputBoardName = By.xpath("//input[@data-testid='create-board-title-input']");
    By btnCreateNewBoardForm = By.xpath("//button[@data-testid='create-board-submit-button']");
    By textBoardNameBoardPage = By.xpath("//h1[@data-testid='board-name-display']");
By openMenuOneBoardPage = By.xpath("//button[@aria-label='Show menu']//span[@data-testid='OverflowMenuHorizontalIcon']");
By menuInCloseBoard = By.xpath("//a[contains(@class,'js-close-board')]");
By menuInBtnCloseBoard = By.xpath("//input[@value='Close']");
By textDeleteBoard = By.xpath("//button[@data-testid='close-board-delete-board-button']");
By btnDeleteBoard = By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']");
By allBoardNamesText = By.xpath("//h3[@class='boards-page-section-header-name']/..//div[@class='board-tile-details-name']//div");
    public void clickBtnCreateNewBoard() {
        clickBase(btnCreateNewBoard);
    }

    public void inputBoardName(String name) {
        sendKeysBase(inputBoardName, name);
    }

    public void clickBtnCreateNewBoardForm() {
        clickBase(btnCreateNewBoardForm);
    }

    public void createNewBoard(String name) {
        clickBtnCreateNewBoard();
        inputBoardName(name);
        clickBtnCreateNewBoardForm();
    }

    public boolean validateBoardNameOnPageOfBoardCorrect(String name) {
        return isTextActualEqualToExpected(textBoardNameBoardPage, name);
    }

    public void deleteBoardByName(String name) {
clickBase(openMenuOneBoardPage);
clickBase(menuInCloseBoard);
clickBase(menuInBtnCloseBoard);
clickBase(textDeleteBoard);
clickBase(btnDeleteBoard);

    }

    public boolean validateBoardExistByName(String name) {
        List<WebElement> list = findElementsBase(allBoardNamesText);
        boolean flag = false;
        for (WebElement element : list){
          if (getTextBase(element).equals(name.toUpperCase())){
flag = true;
return true;
          }
        }
        return flag;
    }
}