package tests;

import dto.UserDTOLombok;
import manager.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import utils.RandomUtils;

import java.lang.reflect.Method;

@Listeners(TestNGListener.class)
public class BaseTest {

    LoginHelper loginHelper = new LoginHelper();
    LogoutHelper logoutHelper = new LogoutHelper();
    BoardsHelper boardsHelper = new BoardsHelper();
    Logger logger = LoggerFactory.getLogger(BaseTest.class);
RandomUtils randomUtils = new RandomUtils();
    UserDTOLombok user = UserDTOLombok.builder()
            .email("fishmank89@gmail.com")
            .password("Mad5610isr")
            .build();

    boolean flagNeedLogout = false;
    boolean flagNeedOpenMainPage = false;

    @BeforeSuite(alwaysRun = true)
    public void preconditions() {
        logger.info("open browser and navigate to main page");
        ApplicationManager.init();
    }

    @AfterSuite(alwaysRun = true)
    public void postConditions() {
        logger.info("close browser");
        ApplicationManager.tearDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeEachMethod(Method method) {
        logger.info("started method: " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachMethod(Method method) {
        logger.info("stopped method: " + method.getName());
    }
}