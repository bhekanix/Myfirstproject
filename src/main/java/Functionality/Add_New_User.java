package Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Add_New_User {
    private WebDriver driver;
    public  Add_New_User (WebDriver driver)
    {
        this.driver = driver;

    }
    @FindBy(xpath = "//button[contains(.,'Add User')]")
    WebElement AddUserButton;
    public void Add_User_Button(){
        WebDriverWait adduserbutton = new WebDriverWait(driver,20);
        adduserbutton.until(ExpectedConditions.visibilityOf(AddUserButton));
        AddUserButton.click();

    }
}
