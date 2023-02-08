package guru.qa.tests.ios;

import guru.qa.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;

@Tag("ios")
public class IOSSearchTests extends TestBase {

    @DisplayName("Проверка функции поиска (ios)")
    @Test
    void checkOutputTextTest() {
        step("Click Text Button", () -> {
            $(id("Text Button")).click();
        });

        step("Check initial state Output text", () -> {
            assertEquals("Waiting for text input.", $(id("Text Output")).getText());
        });

        step(format("Set value %s in the input field and press enter", "Selenium"), () -> {
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys("Selenium");
            $(id("Text Input")).pressEnter();
        });

        step("Check Output text", () -> {
            assertEquals("Selenium", $(id("Text Output")).getText());
        });
    }
}

/*
public class FirstTest extends BrowserStackJUnitTest{

  @ParameterizedTest
  @MethodSource("devices")
  void testCalcOne(int taskId) throws IOException, InterruptedException {

    createConnection(taskId);

//    IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30).until(
//        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
//    textButton.click();
    IOSElement textInput = (IOSElement) new WebDriverWait(driver, 30).until(
        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
    textInput.sendKeys("hello@browserstack.com"+"\n");

    Thread.sleep(5000);

    IOSElement textOutput = (IOSElement) new WebDriverWait(driver, 30).until(
        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Output")));

    assertEquals(textOutput.getText(),"hello@browserstack.com");
  }
}
 */
