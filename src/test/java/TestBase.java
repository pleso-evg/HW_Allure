import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;


    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
