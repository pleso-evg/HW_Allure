import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideIssueTitleTest extends TestBase {

    @Test
    public void SelenideIssueSearch () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/");
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $(linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(withText("Conditions for SelenideProxy")).should(Condition.exist);
    }
}
