package com.shiftedtech.qa.scripts.testng;

import com.shiftedtech.qa.framework.scriptbase.ScriptBaseTestNG;
import org.testng.annotations.Test;

/**
 * Created by ShiftTeacher on 2/10/2018.
 */
public class SpreeFunctionalTestWithTestNg extends ScriptBaseTestNG{

    @Test
    public void validLogin1(){
        homePage().navigetToLoginPage();
        loginPage().Login("shiftqa01@gmail.com", "shiftedtech");
        homePage().verifyLoginSuccess();
    }
    @Test
    public void validLogin2(){
        homePage().navigetToLoginPage();
        loginPage().Login("steveemmet@yahoo.com", "Pickles123");
        homePage().verifyLoginSuccess();
    }
    @Test
    public void validLogin3(){
        homePage().navigetToLoginPage();
        loginPage().Login("hema0ahmad@gmail.com", "hema123");
        homePage().verifyLoginSuccess();
    }
}
