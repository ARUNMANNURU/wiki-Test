package com.arun.serenitytests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by ArunMannuru on 2/23/17.
 */
@RunWith(SerenityRunner.class)
public class WhenBrowsingWikipedia {

    static WebDriver driver;

    WikipediaPage wikipediaPage;

    @Test
    public void englishPageIsInEnglish() {
        wikipediaPage = new WikipediaPage(driver);

        wikipediaPage.open();
        wikipediaPage.gotoEnglishPage();

        assertThat(wikipediaPage.getTitle()).isEqualTo("Wikipedia, the free encyclopedia");
    }

    @Test
    public void spanishPageIsInSpanish() {
        wikipediaPage = new WikipediaPage(driver);

        wikipediaPage.open();
        wikipediaPage.gotoSpanishPage();

        assertThat(wikipediaPage.getTitle()).isEqualTo("Wikipedia, la enciclopedia libre");
    }

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDownClass(){
        driver.quit();
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
