package MbTestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resource\\MbFeatures\\MbAdvice.feature",
glue="MbStepDefinition",
tags="@compareLocalities")

//plugin= {"pretty", 
//		"html:target/HTMLReports/MagicBricksReport.html",	
//		"json:target/JSONReports/MagicBricksReport.json",
//		"junit:target/JUNITReports/MagicBricksReport.xml",
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class MbRunner extends AbstractTestNGCucumberTests {
	

}
