package PageObjectModel;

import Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bookedtinerary extends BaseClass {
    private WebDriver driver;

   //Constructor

    public Bookedtinerary(WebDriver driver){
        this.driver = driver;
    }
    //locators
    private final String checkOrderId ="//input[@name='check_all']";
    private final String cancelSelected ="//input[@name='cancelall']";
    private final String logoutButton = "//input[@value='Logout']";

    //getters
    public WebElement getOrderId(){
        return driver.findElement(By.xpath(checkOrderId));
    }
    public WebElement getCancelSelected(){
        return driver.findElement(By.xpath(cancelSelected));
    }
    public WebElement getLogoutButton(){
        return driver.findElement(By.xpath(logoutButton));
    }

    //setters
    public  void setOrderId(){
        clickElement(checkOrderId);
    }
    public void setCancelSelected(){
        clickElement(cancelSelected);
    }
    public void confirmAlert(){
        handleAlert(true,null);
    }
    public void setLogoutButton(){
        clickElement(logoutButton);
    }
}