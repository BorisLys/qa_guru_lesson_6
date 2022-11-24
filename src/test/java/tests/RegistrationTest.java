package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTest extends CommonTest {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Male";
    String number = faker.phoneNumber().subscriberNumber(10);
    String dayBirth = "23";
    String monthBirth = "February";
    String yearBirth = "1990";
    String subject = "Math";
    String hobbie = "Sports";
    String pictureDirectory = "src/test/resources/me.jpg";
    String adress = faker.address().fullAddress();
    String state = "Uttar Pradesh";
    String city = "Agra";

    @Test
    void fillFormTest() {
        registrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setEmail(email).
                setGender(gender).
                setUserNumber(number).
                setBDate(dayBirth, monthBirth, yearBirth).
                setSubject(subject).
                setHobbies(hobbie).
                uploadPicture(pictureDirectory).
                setAdress(adress).
                setState(state).
                setCity(city).
                clickSubmit().
                verifyResultsModalAppears().
                verifyResult("Student Name", firstName+" "+ lastName).
                verifyResult("Student Email", email).
                verifyResult("Gender", gender).
                verifyResult("Mobile", number).
                verifyResult("Date of Birth", dayBirth+" "+ monthBirth+","+yearBirth).
                verifyResult("Subjects", subject).
                verifyResult("Hobbies", hobbie).
                verifyResult("Picture", pictureDirectory.replaceAll("src/test/resources/","")).
                verifyResult("Address", adress).
                verifyResult("State and City", state+ " "+city).
                clickClose();
    }

}
