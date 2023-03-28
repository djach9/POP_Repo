import enums.Genders;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormPage;



public class FormTest extends BaseTest {

    FormPage formPage;

    @BeforeEach
    public void setUpTest (){
        formPage = new FormPage(driver);
        driver.get("http://www.seleniumui.moderntester.pl/form.php");

    }

        @Test
        public void FillFormWithSuccess() {
            formPage.setFirstNameImput("John")
            .setLastNameImput("Doe")
            .setEmailImput("johndoe@example.com")
            .setageImput(30)
            .selectGender(Genders.MALE)
            .selectRandomExperience()
            .selectAutomationTester()
            .selectContinents("Europe")
            .selectSeleniumCommands("Switch Commands", "Wait Commands")
            .uploadFile("C:\\Users\\djach\\Desktop\\test.txt")
            .sendForm()
            .getValidationMgsLabel();

            Assertions.assertThat(formPage.getValidationMgsLabel()).isEqualTo("Form send with success");
        }
    }

