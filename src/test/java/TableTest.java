import org.junit.jupiter.api.Test;
import pages.RowPage;
import pages.TablePage;

public class TableTest extends BaseTest {


    @Test
    public void WorkOnTable() {
        driver.get("http://www.seleniumui.moderntester.pl/table.php");
        TablePage tablePage = new TablePage(driver);

        for (RowPage mountain:tablePage.getMountains()) {
            mountain.printInfo();
        }
    }


}
