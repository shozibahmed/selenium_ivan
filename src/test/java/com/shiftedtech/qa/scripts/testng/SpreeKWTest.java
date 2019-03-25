package com.shiftedtech.qa.scripts.testng;

import com.shiftedtech.qa.framework.scriptbase.KeywordDrivenScriptBase;
import com.shiftedtech.qa.framework.scriptbase.ScriptBaseTestNG;
import com.shiftedtech.qa.framework.utils.ExcelReader;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ShiftTeacher on 2/17/2018.
 */
public class SpreeKWTest extends KeywordDrivenScriptBase {
    private static String dataFile = System.getProperty("user.dir") + "/src/test/resources/KWScript1.xlsx";

    @Test(dataProvider = "kwTestSuite", description = "Keyword driven test")
    public void keywordDriver(String tcid, String description, String sheetName, String run){
        System.out.println("TestCase Id: " + tcid);
        System.out.println("Description: " + description);
        if(run.contentEquals("N")){
            throw new SkipException("TestCase Id: " + tcid + " skipped" );
        }
        kwDriver(dataFile,sheetName);
    }

    @DataProvider
    public static Object[][] kwTestSuite() {
        Object[][] data = null;
        ExcelReader excelReader = new ExcelReader(dataFile);
        data = excelReader.getExcelSheetData("TestCase", true);
        return data;
    }

}
