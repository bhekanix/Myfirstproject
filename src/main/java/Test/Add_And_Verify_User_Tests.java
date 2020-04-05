package Test;

import Functionality.Add_New_User;
import Setup.Setup_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Add_And_Verify_User_Tests {
    private WebDriver driver = Setup_Class.startBrowserOfChoice("http://www.way2automation.com/angularjs-protractor/webtables/","chrome");
    private static String dir = System.getProperty("user.dir");
    public Add_And_Verify_User_Tests() throws InterruptedException {
    }

    @Test()
    public void Add_User(){
        Add_New_User myuser = PageFactory.initElements(driver,Add_New_User.class);
        myuser.Add_User_Button();
    }


}