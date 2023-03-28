package pages;

import enums.Genders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;


public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstNameImput;
    @FindBy(id = "inputLastName3")
    private WebElement lastNameImput;
    @FindBy(id = "inputEmail3")
    private WebElement emailImput;

    @FindBy(id = "inputAge3")
    private WebElement ageImput;


    @FindBy(name = "gridRadiosSex")
    private List<WebElement> genders;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experienceRadioButtons;

    @FindBy(id = "gridCheckAutomationTester")
    private WebElement automationTesterCheckbox;


    @FindBy(id = "selectContinents")
    private WebElement selectContinents;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement selectSeleniumCommands;

    @FindBy(id = "chooseFile")
    private WebElement uploadFile;

    @FindBy(id = "validator-message")
    private WebElement validationMsgLabel;

    @FindBy(css = "button[type='submit")
    private WebElement sendFormBtn;



    public FormPage setFirstNameImput(String firstName) {
        firstNameImput.sendKeys(firstName);
        return this;

    }

    public FormPage setLastNameImput(String lastName) {
        lastNameImput.sendKeys(lastName);
        return this;
    }

    public FormPage setEmailImput(String email) {
        emailImput.sendKeys(email);
        return this;

    }

    public FormPage setageImput(int age) {
        ageImput.sendKeys(String.valueOf(age));
        return this;

    }

    public FormPage selectFemale() {
        genders.get(1).click();
        return this;

    }

    public FormPage selectMale() {
        genders.get(0).click();
        return this;

    }

    public FormPage selectOther() {
        genders.get(2).click();
        return this;

    }

    public FormPage selectGender(Genders genders) {
        switch (genders) {
            case MALE -> {
                selectMale();
            }
            case FEMALE -> {
                selectFemale();
            }
            case OTHER -> {
                selectOther();
            }
        }
        return this;
    }

    public FormPage selectRandomExperience() {
        Random random = new Random();
        int index = random.nextInt(experienceRadioButtons.size());
        WebElement yearOfExperience = experienceRadioButtons.get(index);
        yearOfExperience.click();
        return this;
    }

    public FormPage selectAutomationTester() {
        automationTesterCheckbox.click();
        return this;
    }

    public FormPage selectContinents(String continentValue) {
        Select selectContinentsElement = new Select(selectContinents);
        selectContinentsElement.selectByVisibleText(continentValue);
        return this;
    }

    public FormPage selectSeleniumCommands(String... commands) {
        Select dropdown = new Select(selectSeleniumCommands);
        for (String command : commands) {
            dropdown.selectByVisibleText(command);
        }
        return this;

    }

    public FormPage uploadFile(String filePath) {
        uploadFile.sendKeys(filePath);
        return this;
    }

    public String getValidationMgsLabel() {
        return validationMsgLabel.getText();
    }
    public FormPage sendForm() {
        sendFormBtn.click();
        return this;

    }
}
