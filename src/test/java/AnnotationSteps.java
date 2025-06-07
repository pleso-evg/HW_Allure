
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AnnotationSteps extends TestBase {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("/");
    }

    @Step("Ищем репозиторий {annotation}")
    public void searchForRepository(String annotation) {
        $(".search-input").click();
        $("#query-builder-test").setValue("annotation").pressEnter();
    }

    @Step("Кликаем по ссылке репозитория {annotation}")
    public void clickOnRepositoryLink(String annotation) {
        $(linkText("doctrine/annotations")).click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с текстом {issue}")
    public void shouldSeeIssueWithText(String issue) {
        $("#issues-tab").shouldHave(text("issue"));
    }
}
