package com.shiftedtech.qa.scripts.testng;

import com.shiftedtech.qa.framework.scriptbase.ScriptBaseTestNG;
import org.testng.annotations.Test;

/**
 * Created by ShiftTeacher on 2/10/2018.
 */
public class SpreeFunctionalTestWithTestNg3 extends ScriptBaseTestNG{
    @Test
    public void validLogin3(){
        homePage().navigetToLoginPage();
        loginPage().Login("hema0ahmad@gmail.com", "hema123");
        homePage().verifyLoginSuccess();
    }
}
