package PageObjectModel;

import Baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookAHotel extends BaseClass {
    private WebDriver driver;

    //constructor
     public BookAHotel(WebDriver driver){
         this.driver = driver;
     }
     //locators
    private final String firstName = "//input[@name='first_name']";
    private final String lastName  = "//input[@name='last_name']";
    private final String billingAddress = "//textarea[@name='address']";
    private final String creditCardNumber = "//input[@name='cc_num']";
    private final String creditCardType = "//select[@name='cc_type']";
    private final String expiryMonth = "//select[@name='cc_exp_month']";
    private final String expiryYear = "//select[@name='cc_exp_year']";
    private final String cvv = "//input[@name='cc_cvv']";
    private final String bookNowButton = "//input[@id='book_now']";

    //getters

    public WebElement getFirstName(){
        return driver.findElement(By.xpath(firstName));
    }
    public WebElement getLastName(){
        return driver.findElement(By.xpath(lastName));
    }
    public WebElement getBillingAddress(){
        return driver.findElement(By.xpath(billingAddress));
    }
    public WebElement getCreditCardNumber(){
        return driver.findElement(By.xpath(creditCardNumber));
    }
    public WebElement getCreditCardType(){
        return driver.findElement(By.xpath(creditCardType));
    }
    public WebElement getExpiryMonth(){
        return driver.findElement(By.xpath(expiryMonth));
    }
    public WebElement getExpiryYear(){
        return driver.findElement(By.xpath(expiryYear));
    }
    public WebElement getCvv(){
        return driver.findElement(By.xpath(cvv));
    }
    //setter

    public void setFirstName(String Text){

        waitForVisibility(firstName,10);
        enterText(firstName,Text);
    }
    public void setLastName(String Text){
        waitForVisibility(lastName,10);
        enterText(lastName,Text);
    }
    public void setBillingAddress(String Text){
        waitForVisibility(billingAddress,10);
        enterText(billingAddress,Text);
    }
    public void setCreditCardNumber(String Text){
        waitForVisibility(creditCardNumber,10);
        enterText(creditCardNumber,Text);
    }
    public void setCreditCardType(String Text){
        waitForVisibility(creditCardType,10);
        selectDropdown(creditCardType,"index", Text);
    }
    public void setExpiryMonth(String Text){
        waitForVisibility(expiryMonth,10);
        selectDropdown(expiryMonth,"index",Text);
    }
    public void setExpiryYear(String Text){
        waitForVisibility(expiryYear,10);
        selectDropdown(expiryYear,"value", Text);
    }
    public void setCvv(String Text){
        waitForVisibility(cvv,10);
        enterText(cvv,Text);
    }
    public void setBookNowButton(){
        waitForVisibility(bookNowButton,10);
        clickElement(bookNowButton);
    }

}
