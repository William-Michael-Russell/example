package com.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selophane.elements.factory.api.ElementFactory;

/**
 * Created by william.russell on 12/16/16.
 */
public class GooglePage {

    @FindBy(id = "lst-ib")
    public WebElement searchBox;


    public GooglePage(WebDriver driver){
        ElementFactory.initElements(driver, this);
    }
}
