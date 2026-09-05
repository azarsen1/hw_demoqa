package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserSize = System.getProperty("browserSize");
        String remoteHost = System.getProperty("remoteHost", "selenoid.qa.guru");
        Configuration.remote = "https://user1:1234@" + remoteHost + "/wd/hub";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "151.0"); // Или "100.0"

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";

    }
    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @AfterEach
    void afterEach() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            Attach.screenshotAs("Last screenshot");
            Attach.attachAsText("Тест", "Проверка вложений");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }

        Selenide.closeWebDriver();
    }


}
