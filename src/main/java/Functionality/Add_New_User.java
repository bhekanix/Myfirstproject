package Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Add_New_User {
    private WebDriver driver;
    public Add_New_User(WebDriver driver) {
        this.driver = driver;

    }

    @FindBy(xpath = "//button[contains(.,'Add User')]")
    WebElement AddUserButton;
    @FindBy(xpath = "//button[contains(.,'Save')]")
    WebElement SaveUserButton;
    @FindBy(xpath = "//input[@name='FirstName']")
    WebElement FirstName;
    @FindBy(xpath = "//input[@name='LastName']")
    WebElement LastName;
    @FindBy(xpath = "//input[contains(@name,'UserName')]")
    WebElement UserName;
    @FindBy(xpath = "//input[contains(@type,'password')]")
    WebElement Password;
    @FindBy(xpath = "//input[@value='15']")
    WebElement CompanyA;
    @FindBy(xpath = "//input[contains(@value,'16')]")
    WebElement CompanyB;
    @FindBy(xpath = "//select[contains(@name,'RoleId')]")
    WebElement Role;
    @FindBy(xpath = "//input[contains(@type,'email')]")
    WebElement Email;
    @FindBy(xpath = "//input[contains(@name,'Mobilephone')]")
    WebElement CellPhone;
    @FindBy(xpath = "(//td[@class='smart-table-data-cell'])[1]")
    WebElement SavedFirstname;
    @FindBy(xpath = "//button[contains(.,'Close')]")
    WebElement CloseUserButton;
    @FindBy(xpath = "(//button[contains(.,'Edit')])[1]")
    WebElement EditButton;
    @FindBy(xpath = "(//input[@name='IsLocked'])[8]")
    WebElement IsLocked;

    public void Add_User_Button() {
        WebDriverWait adduserbutton = new WebDriverWait(driver, 20);
        adduserbutton.until(ExpectedConditions.visibilityOf(AddUserButton));
        AddUserButton.click();


    }
//    public void Edit_User_Button() {
//        WebDriverWait edituserbutton = new WebDriverWait(driver, 20);
//        edituserbutton.until(ExpectedConditions.visibilityOf(EditButton));
//        EditButton.click();
//
//
//    }
//    public void Locked_Button() {
//        WebDriverWait lockbutton = new WebDriverWait(driver, 20);
//        lockbutton.until(ExpectedConditions.visibilityOf(IsLocked));
//        IsLocked.click();
//
//
//    }



    public void Enter_Name(String _firstname) {
        WebDriverWait adduserbutton = new WebDriverWait(driver, 20);
        adduserbutton.until(ExpectedConditions.visibilityOf(FirstName));
        FirstName.clear();
        FirstName.sendKeys(_firstname);


    }

    public void Enter_Lastname(String _lastname) {
        WebDriverWait adduserbutton = new WebDriverWait(driver, 20);
        adduserbutton.until(ExpectedConditions.visibilityOf(LastName));
        LastName.clear();
        LastName.sendKeys(_lastname);
    }

    public void Enter_Username(String _username) {
        WebDriverWait adduserbutton = new WebDriverWait(driver, 20);
        adduserbutton.until(ExpectedConditions.visibilityOf(UserName));
        UserName.clear();
        UserName.sendKeys(_username);

    }

    public void Enter_Password(String _password) {
        WebDriverWait adduserbutton = new WebDriverWait(driver, 20);
        adduserbutton.until(ExpectedConditions.visibilityOf(Password));
        Password.sendKeys(_password);
    }

    public void Enter_Email(String _email) {
        WebDriverWait adduserbutton = new WebDriverWait(driver, 20);
        adduserbutton.until(ExpectedConditions.visibilityOf(Email));
        Email.clear();
        Email.sendKeys(_email);
    }

    public void Enter_Cellphone(String _cellphone) {
        WebDriverWait adduserbutton = new WebDriverWait(driver, 20);
        adduserbutton.until(ExpectedConditions.visibilityOf(CellPhone));
        CellPhone.clear();
        CellPhone.sendKeys(_cellphone);
    }

    public void Select_Role(String _role) {
        WebDriverWait adduserbutton = new WebDriverWait(driver, 20);
        adduserbutton.until(ExpectedConditions.visibilityOf(Role));
        Select drp = new Select(Role);
        drp.selectByVisibleText("Customer");
    }

    public void Select_Company(String _Company) {
        WebDriverWait adduserbutton = new WebDriverWait(driver, 20);
        adduserbutton.until(ExpectedConditions.visibilityOf(CompanyA));
        if (_Company.equalsIgnoreCase("CompanyAAA")) {
            CompanyA.click();

        } else if (_Company.equalsIgnoreCase("CompanyBBB")) {
            CompanyB.click();
        }

    }

    public void Save_New_user() {
        WebDriverWait saveuserbutton = new WebDriverWait(driver, 20);
        saveuserbutton.until(ExpectedConditions.visibilityOf(SaveUserButton));
        SaveUserButton.click();
    }

    public void Verify_Added_User(String _name) {
        WebDriverWait verifyaddeduser = new WebDriverWait(driver, 20);
        verifyaddeduser.until(ExpectedConditions.visibilityOf(SavedFirstname));
        Assert.assertEquals(SavedFirstname.getText(), _name);
    }

    public void Close_User_Button() {
        WebDriverWait closeuserbutton = new WebDriverWait(driver, 20);
        closeuserbutton.until(ExpectedConditions.visibilityOf(CloseUserButton));
        CloseUserButton.click();

    }

}



