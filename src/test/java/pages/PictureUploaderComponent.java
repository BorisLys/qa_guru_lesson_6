package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

public class PictureUploaderComponent {

    public void uploadPicture(SelenideElement element, String filePath) {
        element.uploadFile(new File(filePath));
    }

}
