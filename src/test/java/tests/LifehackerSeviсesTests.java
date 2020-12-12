package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("QA.GURU automation course")
@Story("Lifehacker services tests with video")
@Tag("lifechacker")
public class LifehackerSeviсesTests {

    @Test
    @Description("Lifehacker services test, we check the opening of service pages")
    @DisplayName("Successful opening of the cost calculator page")
    void shouldOpenCostCalculatorPage() {
        step("01. Open Lifehacker main page", () ->
                open("https://lifehacker.ru"));

        step("02. Click the 'Калькуляторы' link", () ->
                $(byText("Калькуляторы")).click());
        step("03. Click the 'Сколько тратить в день' section", () ->
                $(byText("Сколько тратить в день")).click());
                switchTo().window(1);

        step("04. Check if the title of the page contains text 'Сколько тратить в день'", () ->
                $(".banner__title").shouldHave(text("Сколько тратить в день")));
        step("05. Check the transition to the 'Сколько тратить в день' page", () ->
        assertEquals("https://lifehacker.ru/special/planirovanie-bjudzheta-na-den/", WebDriverRunner.url()));
    }

    @Test
    @Description("Lifehacker services test, we check the opening of service pages")
    @DisplayName("Unsuccessful opening of the calorie calculator page")
    void shouldOpenCalorieCalculatorPage() {
        step("01. Open Lifehacker main page", () ->
                open("https://lifehacker.ru"));

        step("02. Click the 'Калькуляторы' link", () ->
                $(byText("Калькуляторы")).click());
        step("03. Click the 'Калькулятор нормы калорий' section", () ->
                $(byText("Калькулятор нормы калорий")).click());
        switchTo().window(1);

        step("04. Check if the title of the page contains text 'Как рассчитать норму калорий'", () ->
                $(".banner__title").shouldHave(text("Как рассчитать норму калорий")));
        step("05. Check the transition to the 'Как рассчитать норму калорий' page", () ->
        assertEquals("https://lifehacker.ru/special/rasschitat-normu-kalorij", WebDriverRunner.url()));
    }

}
