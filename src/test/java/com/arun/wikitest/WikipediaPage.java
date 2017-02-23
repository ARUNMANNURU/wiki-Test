package com.arun.serenitytests;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

/**
 * Created by ArunMannuru on 2/23/17.
 */
@DefaultUrl("https://www.wikipedia.org")
public class WikipediaPage extends PageObject {
    @FindBy(id="js-link-box-en")
    WebElement englishLink;

    @FindBy(id="js-link-box-es")
    WebElement spanishLink;

    public WikipediaPage(WebDriver driver){
        super(driver);
    }

    public void gotoEnglishPage(){
        englishLink.click();
    }

    public void gotoSpanishPage(){
        spanishLink.click();
    }

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        element(englishLink).waitUntilVisible();
    }
}
