package stepDefinition;

import Baseclass.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;


public class Hooks extends BaseClass {


    @Before
    public  void setUp(){
        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("url");
        BaseClass.launchBrowser(browser);
        BaseClass.openUrl(url);
    }

    @After
    public  void tearDown(){
        BaseClass.closeBrowser();
    }
}
