import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotationIssueTitleTest extends TestBase {

    private static final String annotation = "annotation";
    private static final String issue = "ignores extra closing brackets";

    @Test
    public void AnnotationIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        AnnotationSteps steps = new AnnotationSteps();

        steps.openMainPage();
        steps.searchForRepository(annotation);
        steps.clickOnRepositoryLink(annotation);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithText(issue);
    }
}