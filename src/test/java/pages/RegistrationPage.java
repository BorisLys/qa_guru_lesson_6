package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.CalendarComponent;
import pages.PictureUploaderComponent;
import pages.RegistrationResultsModalComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    PictureUploaderComponent pictureUploaderComponent = new PictureUploaderComponent();
    RegistrationResultsModalComponent registrationResultsModalComponent = new RegistrationResultsModalComponent();


    private final String tittleText = "Student Registration Form";
    private SelenideElement firstNameInput = $x("//input[@id='firstName']");
    private SelenideElement lastNameInput = $x("//input[@id='lastName']");
    private SelenideElement userEmailInput = $x("//input[@id='userEmail']");
    private SelenideElement genderRadioButtons = $x("//div[@id='genterWrapper']");
    private SelenideElement userNumberInput = $x("//input[@id='userNumber']");
    private SelenideElement userBDayInput = $x("//input[@id='dateOfBirthInput']");
    private SelenideElement subjectsInput = $x("//input[@id='subjectsInput']");
    private SelenideElement hobbiesCheckBoxes = $x("//div[@id='hobbiesWrapper']");
    private SelenideElement uploadPictureButton = $x("//input[@id='uploadPicture']");
    private SelenideElement adressField = $x("//textarea[@id='currentAddress']");
    private SelenideElement stateList = $x("//div[text()='Select State']");
    private SelenideElement cityList = $x("//div[text()='Select City']");
    private SelenideElement submitButton = $x("//button[@id='submit']");
    private SelenideElement closeButton = $x("//button[@id='closeLargeModal']");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $x("//div[@class='practice-form-wrapper']").shouldHave(Condition.text(tittleText));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderRadioButtons.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBDate(String day, String month, String year) {
        userBDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesCheckBoxes.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureUploaderComponent.uploadPicture(uploadPictureButton, value);
        return this;
    }

    public RegistrationPage setAdress(String value) {
        adressField.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateList.click();
        $x("//div[text()='" + value + "']").click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityList.click();
        $x("//div[text()='" + value + "']").click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModalComponent.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModalComponent.verifyResults(key, value);
        return this;
    }

    public RegistrationPage clickClose() {
        closeButton.click();
        return this;
    }

}
