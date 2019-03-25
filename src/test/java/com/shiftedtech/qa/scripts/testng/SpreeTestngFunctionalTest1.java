package com.shiftedtech.qa.scripts.testng;

import com.shiftedtech.qa.framework.scriptbase.ScriptBaseTestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by ShiftTeacher on 2/10/2018.
 */
public class SpreeTestngFunctionalTest1 extends ScriptBaseTestNG{

    @Test(dataProvider = "loginDataProviderAsArray")
    public void validLoginDataDriven(String email, String password){
        homePage().navigetToLoginPage();
        loginPage().Login(email.trim(), password);
        homePage().verifyLoginSuccess();
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

}
