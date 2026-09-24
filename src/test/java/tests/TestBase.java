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
        String remoteHost = System.getProperty("remoteHost", "selenoid.qa.guru");
        Configuration.remote = "https://user1:1234@" + remoteHost + "/wd/hub";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "152.0");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");

    }
    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }



    @AfterEach
    void afterEach() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            String sessionId = Selenide.sessionId().toString();

            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();

            // 1. Сначала забираем видео, пока контейнер еще жив на Селеноиде
            Attach.addVideo(sessionId);

            // 2. И только потом гасим драйвер
            Selenide.closeWebDriver();
        }
    }


}
