package com.shiftedtech.qa.scripts.testng;

import com.shiftedtech.qa.framework.scriptbase.ScriptBaseTestNG;
import com.shiftedtech.qa.framework.utils.ExcelReader;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ShiftTeacher on 2/10/2018.
 */
public class SpreeTestngFunctionalTest2 extends ScriptBaseTestNG{

    @Test(dataProvider = "loginDataProviderFromExcel")
    public void validLoginDataDriven(LoginData loginData){

        System.out.println("Running test:" + loginData.getId());

        if(loginData.isSkiped()){
            throw new SkipException("This test is skiping");
        }

        homePage().navigetToLoginPage();
        loginPage().Login(loginData.getEmail().trim(), loginData.getPassword());

        if(loginData.getDescription().contains("Invalid")){
            loginPage().verifyLoginNotSuccess();
        }else
        {
            homePage().verifyLoginSuccess();
        }


    }

    @DataProvider
    public static Object[][] loginDataProviderAsArray() {
        Object[][] data = new Object[4][1];

        data[0][0] = new LoginData("TC001","Basic data","shiftqa01@gmail.com","shiftedtech");
        data[1][0] = new LoginData("TC002","Basic data","debajyoti1990@gmail.com","deb0119");

            LoginData data1 = new LoginData();
            data1.setId("TC003");
            data1.setDescription("Test case 3");
            data1.setEmail("hema0ahmad@gmail.com");
            data1.setPassword("hema123");
            data1.setSkiped(true);
        data[2][0] = data1;

        data[3][0] = new LoginData("TC004","Invalid user","invalid@gmail.com","deb0119");

        return data;
    }
    @DataProvider
    public static Object[][] loginDataProviderFromExcel() {
        Object[][] data = null;
        String dataFile = System.getProperty("user.dir") + "/src/test/resources/SpreeLoginData.xls";
        ExcelReader excelReader = new ExcelReader(dataFile);
        data = excelReader.getExcelSheetData("Sheet2",true);

        Object[][] dataObj = new Object[data.length][1];
        for(int i = 0; i < data.length; i++){
            LoginData loginData = new LoginData();
            loginData.setId(data[i][0].toString());
            loginData.setDescription(data[i][1].toString());
            loginData.setEmail(data[i][2].toString());
            loginData.setPassword(data[i][3].toString());
            if(data[i][4].toString().toUpperCase().contentEquals("Y")){
                loginData.setSkiped(true);
            }
            else
            {
                loginData.setSkiped(false);
            }

            dataObj[i][0] = loginData;
        }
        return dataObj;
    }

}
