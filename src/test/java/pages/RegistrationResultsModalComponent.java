package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationResultsModalComponent {

    public void verifyModalAppears() {
        $x("//div[text()='Thanks for submitting the form']").shouldBe(Condition.visible);
    }

    public void verifyResults(String key, String value) {
        $x("//div[@class='table-responsive']").$(byText(key)).parent().shouldHave(text(value));

    }

}
