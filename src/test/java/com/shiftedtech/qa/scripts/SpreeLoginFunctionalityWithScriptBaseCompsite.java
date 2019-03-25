package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.framework.scriptbase.ScriptBaseComposite;
import org.junit.Test;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class SpreeLoginFunctionalityWithScriptBaseCompsite extends ScriptBaseComposite {

    @Test
    public void validLoginTest(){
        homePage.navigetToLoginPage();
        loginPage.Login("shiftqa01@gmail.com", "shiftedtech");
        homePage.verifyLoginSuccess();
    }

    @Test
    public void invalidLoginTest(){
        spree.Login("shiftqa01@gmail.com", "invalidpassword");
        spree.verifyLoginNotSuccess();
    }

    @Test
    public void invalidEmailTest(){
        spree.Login("shiftqa01_invalid@gmail.com", "shiftedtech");
        spree.verifyLoginNotSuccess();
    }



}
