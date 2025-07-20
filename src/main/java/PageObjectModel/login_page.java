package PageObjectModel;

import Baseclass.baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login_page extends baseclass {
    private WebDriver driver;

    //constructor

    public login_page(WebDriver driver){
        this.driver=driver;
    }

    //locators

    private final String userNameField = "//input[@name='username']";
    private final String passWordField = "//input[@name='password']";
    private final String loginButton = "//input[@name='login']";

    //getters

    public WebElement getUserName(){
        return driver.findElement(By.xpath(userNameField));
    }
    public WebElement getPassword(){
        return driver.findElement(By.xpath(passWordField));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.xpath(loginButton));
    }

    //setters

    public void enterUserName (String username){
        enterText(userNameField, username);
    }
    public void enterPassword(String password){
        enterText(passWordField,password);
    }
    public void clickLoginButton(){
        clickElement(loginButton);
    }
}
