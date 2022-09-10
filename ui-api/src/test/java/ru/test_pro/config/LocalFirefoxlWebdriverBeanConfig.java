package ru.test_pro.config;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan(lazyInit = true, basePackages = "ru.test_pro")
@Profile("local-firefox")
@Import({DBBeanConfig.class, PropertiesConfig.class})
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class LocalFirefoxlWebdriverBeanConfig {

    private WebDriver webDriver;


    @Bean
    @Qualifier("webDriver")
    public WebDriver webDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("w3c", true);
        webDriver = new ChromeDriver(opt);

        return webDriver;


    }
}