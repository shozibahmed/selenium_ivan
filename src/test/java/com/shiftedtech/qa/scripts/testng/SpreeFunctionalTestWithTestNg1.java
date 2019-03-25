package com.shiftedtech.qa.scripts.testng;

import com.shiftedtech.qa.framework.scriptbase.ScriptBaseTestNG;
import org.testng.annotations.*;

/**
 * Created by ShiftTeacher on 2/10/2018.
 */
public class SpreeFunctionalTestWithTestNg1 extends ScriptBaseTestNG{
    @Test
    public void validLogin1(){
        homePage().navigetToLoginPage();
        loginPage().Login("shiftqa01@gmail.com", "shiftedtech");
        homePage().verifyLoginSuccess();
    }
}
