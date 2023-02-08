package guru.qa.tests.android;

import guru.qa.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

@Tag("android")
public class AndroidSearchTests extends TestBase {

    @DisplayName("Проверка функции поиска (android)")
    @Test
    void searchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
    @DisplayName("Проверка элементов навигационного меню")
    @Test
    void checkNavBarMenuButtons() {

        String buttonFirst = "Log in to Wikipedia",
                buttonSecond = "Settings",
                buttonThird = "Support Wikipedia";

        step("Click on the NavBar Menu button", () -> {
            $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Check button: " + buttonFirst, () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text(buttonFirst));
        });
        step("Check button: " + buttonSecond, () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_settings")).shouldHave(text(buttonSecond));
        });
        step("Check button: " + buttonThird, () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_donate")).shouldHave(text(buttonThird));
        });
    }
}
