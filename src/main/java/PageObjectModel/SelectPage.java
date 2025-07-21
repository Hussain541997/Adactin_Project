package PageObjectModel;

import Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectPage extends BaseClass {
    private WebDriver driver;

    //constructor
    public SelectPage(WebDriver driver){
        this.driver=driver;
    }
    //locators
    private final String selectHotel ="//input[@id='radiobutton_1']";
    private final String continueButton ="//input[@id='continue']";

    //getters
    public WebElement getSelectHotel(){
        return driver.findElement(By.xpath(selectHotel));
    }
    public WebElement getContinueButton(){
        return driver.findElement(By.xpath(continueButton));
    }

    //Action by using setters

    public void setSelectHotel(){
        clickElement(selectHotel);
    }
    public void setContinueButton(){
        waitForVisibility(continueButton, 10);
        clickElement(continueButton);
    }
}
