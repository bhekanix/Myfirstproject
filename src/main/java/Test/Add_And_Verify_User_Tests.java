package Test;

import Functionality.Add_New_User;
import Setup.Setup_Class;
import freemarker.ext.jsp.TaglibFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.plugin.dom.core.Comment;
import sun.plugin.dom.core.Document;

import java.io.FileInputStream;
import java.io.IOException;

public class Add_And_Verify_User_Tests {
    private WebDriver driver = Setup_Class.startBrowserOfChoice("http://www.way2automation.com/angularjs-protractor/webtables/", "chrome");
    private static String dir = System.getProperty("user.dir");
    private static final String excel = dir + "/src/main/java/Test_data/testdata.xlsx";

    public Add_And_Verify_User_Tests() throws InterruptedException {
    }

    @Test()
    public void Save_User() throws IOException {
        for (int i = 1; i < 10; i++) {

            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            String first_name = sheet.getRow(i).getCell(0).getStringCellValue();
            String Last_name = sheet.getRow(i).getCell(1).getStringCellValue();
            String User_name = sheet.getRow(i).getCell(2).getStringCellValue();
            String Password = sheet.getRow(i).getCell(3).getStringCellValue();
            String Company = sheet.getRow(i).getCell(4).getStringCellValue();
            String Role = sheet.getRow(i).getCell(5).getStringCellValue();
            String Email = sheet.getRow(i).getCell(6).getStringCellValue();
            String Cell_phone = sheet.getRow(i).getCell(7).getStringCellValue();
            Add_New_User saveuser = PageFactory.initElements(driver, Add_New_User.class);
            Add_New_User myuser = PageFactory.initElements(driver, Add_New_User.class);
            myuser.Add_User_Button();
            saveuser.Enter_Name(first_name);
            saveuser.Enter_Lastname(Last_name);
            saveuser.Enter_Username(User_name);
            saveuser.Enter_Password(Password);
            saveuser.Select_Company(Company);
            saveuser.Select_Role(Role);
            saveuser.Enter_Email(Email);
            saveuser.Enter_Cellphone(Cell_phone);
            saveuser.Save_New_user();
            saveuser.Verify_Added_User(first_name);


        }


    }
//    @Test()
//    public void Edit_Button(){
//        Add_New_User edituser = PageFactory.initElements(driver,Add_New_User.class);
//        Add_New_User saveuser = PageFactory.initElements(driver, Add_New_User.class);
//        Add_New_User lockuser = PageFactory.initElements(driver, Add_New_User.class);
//        edituser.Edit_User_Button();
//        lockuser.Locked_Button();
//        saveuser.Save_New_user();
//
//    }

    @AfterTest()
    public void Quit()
    {
        driver.quit();
    }
    @Test()
    public void Close_Form() {
        Add_New_User closeuser = PageFactory.initElements(driver, Add_New_User.class);
        Add_New_User myuser = PageFactory.initElements(driver, Add_New_User.class);
        myuser.Add_User_Button();
        closeuser.Close_User_Button();


    }
}












