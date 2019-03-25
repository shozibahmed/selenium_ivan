package com.shiftedtech.qa.scripts;

import com.shiftedtech.qa.framework.scriptbase.ScriptBase;
import org.junit.*;

/**
 * Created by ShiftTeacher on 2/3/2018.
 */
public class SpreeLoginFunctionalityWithScriptBase extends ScriptBase {

    @Test
    public void validLoginTest(){
        Login("shiftqa01@gmail.com", "shiftedtech");
        verifyLoginSuccess();
    }

    @Test
    public void invalidLoginTest(){
        Login("shiftqa01@gmail.com", "invalidpassword");
        verifyLoginNotSuccess();
    }

    @Test
    public void invalidEmailTest(){
        Login("shiftqa01_invalid@gmail.com", "shiftedtech");
        verifyLoginNotSuccess();
    }



}
