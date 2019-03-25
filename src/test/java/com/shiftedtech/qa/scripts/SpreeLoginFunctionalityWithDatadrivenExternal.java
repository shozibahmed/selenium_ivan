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
public class SpreeLoginFunctionalityWithDatadrivenExternal extends ScriptBaseComposite {

    @Test
    //@UseDataProvider(value = "loginDataProviderAsArray" )
    @UseDataProvider(location = JunitDataProvider.class, value = " " )
    public void validLoginDataDriven(String email, String password){
        homePage.navigetToLoginPage();
        loginPage.Login(email.trim(), password);
        homePage.verifyLoginSuccess();
    }
}
