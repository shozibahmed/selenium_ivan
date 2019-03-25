package com.shiftedtech.qa.scripts.testng;

import com.shiftedtech.qa.framework.scriptbase.ScriptBaseTestNG;
import org.testng.annotations.Test;

/**
 * Created by ShiftTeacher on 2/10/2018.
 */
public class SpreeFunctionalTestWithTestNg2 extends ScriptBaseTestNG{
    @Test
    public void validLogin2(){
        homePage().navigetToLoginPage();
        loginPage().Login("steveemmet@yahoo.com", "Pickles123");
        homePage().verifyLoginSuccess();
    }

}
