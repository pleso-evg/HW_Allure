
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class LambdaIssueTitleTest extends TestBase {

    private static final String lambda = "lambda";
    private static final String issue = "Question about unification parameter";

    @Test
    public void lambdaIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("/");
        });
        step("Ищем репозиторий " + lambda, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(lambda).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + lambda, () -> {
            $(linkText("palatable/lambda")).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с текстом " + issue, () -> {
            $("#issues-tab").shouldHave(text("issue"));
        });
    }
}
