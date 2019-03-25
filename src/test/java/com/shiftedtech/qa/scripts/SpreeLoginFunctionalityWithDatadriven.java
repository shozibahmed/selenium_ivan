package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.framework.scriptbase.ScriptBaseComposite;
import com.shiftedtech.qa.framework.utils.ExcelReader;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */

@RunWith(DataProviderRunner.class)
public class SpreeLoginFunctionalityWithDatadriven extends ScriptBaseComposite {


    @Test
    //@UseDataProvider(value = "loginDataProviderAsArray" )
    @UseDataProvider(value = "loginDataProviderAsExcelPOI" )
    public void validLoginDataDriven(String email, String password){
        homePage.navigetToLoginPage();
        loginPage.Login(email.trim(), password);
        homePage.verifyLoginSuccess();
    }


    @DataProvider
    public static Object[][] loginDataProviderAsArray() {
        Object[][] data = {
                            {"shiftqa01@gmail.com","shiftedtech"},
                            {"debajyoti1990@gmail.com", "deb0119"},
                            {"hema0ahmad@gmail.com", "hema123"}
                          };

        return data;
    }
    @DataProvider
    public static Object[][] loginDataProviderAsExcel() {
        Object[][] data = null;

        String dataFile = System.getProperty("user.dir") + "/src/test/resources/SpreeLoginData.xls";
        File dFile = new File(dataFile);
        if(dFile.exists()){
            try {
                Workbook workbook = Workbook.getWorkbook(dFile);
                Sheet sheet = workbook.getSheet("Sheet1");
                data = new Object[sheet.getRows() - 1][sheet.getColumns()];
                String cellData = null;
                for(int j = 0; j < sheet.getColumns(); j++){
                    for(int i = 1; i < sheet.getRows(); i++){
                        Cell cell = sheet.getCell(j,i);
                        CellType cellType = cell.getType();
                        if(cellType == CellType.LABEL){
                            cellData = cell.getContents();
                        }
                        else if(cellType == CellType.NUMBER){
                            cellData = cell.getContents().toString();
                        }
                        else {
                            System.out.println("Unknown cell type");
                        }
                        data[i - 1][j] = cellData;
                    }
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return data;
    }
    @DataProvider
    public static Object[][] loginDataProviderAsExcelPOI() {
        Object[][] data = null;

        String dataFile = System.getProperty("user.dir") + "/src/test/resources/SpreeLoginData.xls";
        ExcelReader excelReader = new ExcelReader(dataFile);

        data = excelReader.getExcelSheetData("Sheet1",true);

        return data;
    }

    /*
    @Test
    public void validLoginTest1(){
        homePage.navigetToLoginPage();
        loginPage.Login("shiftqa01@gmail.com", "shiftedtech");
        homePage.verifyLoginSuccess();
    }
    @Test
    public void validLoginTest2(){
        homePage.navigetToLoginPage();
        loginPage.Login("debajyoti1990@gmail.com", "deb0119");
        homePage.verifyLoginSuccess();
    }
    @Test
    public void validLoginTest3(){
        homePage.navigetToLoginPage();
        loginPage.Login("hema0ahmad@gmail.com", "hema123");
        homePage.verifyLoginSuccess();
    }
    */
}
