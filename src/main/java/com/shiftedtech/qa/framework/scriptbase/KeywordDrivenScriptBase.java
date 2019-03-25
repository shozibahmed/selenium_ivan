package com.shiftedtech.qa.framework.scriptbase;

import com.paxovision.execution.reporter.listener.ReporterTestListener;
import com.paxovision.execution.reporter.service.ReporterService;
import com.shiftedtech.qa.framework.utils.ExcelReader;
import org.testng.annotations.*;

import java.util.HashMap;

/**
 * Created by ShiftTeacher on 2/17/2018.
 */

public class KeywordDrivenScriptBase extends ScriptBaseTestNG {
    private static String KW_OBJECT_REPOSITORY = System.getProperty("user.dir") + "/src/test/resources/ObjectRepo.xlsx";
    private HashMap<String,TestObject> objectRepository = null;

    @BeforeClass
    public void beforeClass() throws Exception {
        super.beforeClass();
        objectRepository = new HashMap<String, TestObject>();
        loadObjectRepo(KW_OBJECT_REPOSITORY);
    }

    @BeforeMethod
    @Parameters({"browserName"})
    public void setUp(@Optional(value = "chrome") String browserName) throws Exception {
        super.setUp(browserName);
    }

    @AfterMethod
    public void teamDown() {
        super.teamDown();
    }

    public void kwDriver(String dataFile, String sheetName){
        Object[][] data = null;
        ExcelReader excelReader = new ExcelReader(dataFile);
        data = excelReader.getExcelSheetData(sheetName, true);
        for(int i = 0; i < data.length; i++) {
            TestStep ts = new TestStep(data[i][0].toString(),
                                       data[i][1].toString(),
                                       data[i][2].toString(),
                                       data[i][3].toString(),
                                       data[i][4].toString());
            System.out.println(ts.toString());

            reporter.logInfo(ts.getStep() + " - " + ts.getKeyword(), ts.toString());
            //extentManager.log(ts.getStep() + " - " + ts.getKeyword());

            if (ts.isMatchingKeyword("Click")) {
                TestObject to = getTestObjectFromObjectRepo(ts.getPage(),ts.getTestObjectName());
                homePage().click(to.by());
            } else if (ts.getKeyword().toUpperCase().contentEquals("TypeText".toUpperCase())) {
                TestObject to = getTestObjectFromObjectRepo(ts.getPage(),ts.getTestObjectName());
                homePage().typeText(to.by(),ts.getData());
            } else if (ts.getKeyword().toUpperCase().contentEquals("verifyText".toUpperCase())) {
                TestObject to = getTestObjectFromObjectRepo(ts.getPage(),ts.getTestObjectName());
                homePage().verifyText(to.by(),ts.getData());
            }else if (ts.getKeyword().toUpperCase().contentEquals("verifyPageTitle".toUpperCase())) {
                homePage().verifyPageTitle(ts.getData());
            } else if (ts.getKeyword().toUpperCase().contentEquals("navigateToLoginPage".toUpperCase())) {
                homePage().navigetToLoginPage();
            } else if (ts.getKeyword().toUpperCase().contentEquals("login".toUpperCase())) {
                String[] dp = ts.getData().split("\\|");
                loginPage().Login(dp[0], dp[1]);
            } else if (ts.getKeyword().toUpperCase().contentEquals("verifyLoginSuccess".toUpperCase())) {
                homePage().verifyLoginSuccess();
            } else {
                System.out.println("Unknown keyword");
                throw new RuntimeException("Unknown keyword: " + ts.getKeyword());
            }
        }
    }

    public TestObject getTestObjectFromObjectRepo(String page, String name){
        String KEY = page.toUpperCase() + "." + name.toUpperCase();
        TestObject to = null;
        if(objectRepository.containsKey(KEY)) {
             to = objectRepository.get(KEY);
        }
        else
        {
            throw new RuntimeException("Key: " + KEY + " does not exist");
        }
        return to;
    }
    public void loadObjectRepo(String... fineNames) throws Exception {

        for(String file : fineNames){

            ExcelReader reader = new ExcelReader(file);
            String[][] data = reader.getExcelSheetData("OR",true);
            for(int i = 0; i < data.length; i++){
                System.out.println("**************** TestObject [ " + i + " ]**********************");

                TestObject to = new TestObject();
                to.setId(data[i][0]);
                to.setPage(data[i][1]);
                to.setName(data[i][2]);
                to.setDescription(data[i][3]);
                to.setFindBy(data[i][4]);
                to.setUsing(data[i][5]);

                System.out.println(to.toString());

                String KEY = to.getPage().toUpperCase() + "." + to.getName().toUpperCase();

                if(!objectRepository.containsKey(KEY)) {
                    objectRepository.put(KEY, to);
                }
            }
        }
    }


}
