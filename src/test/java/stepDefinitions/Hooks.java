package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    private final TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @After
    public void closeBrowser(){
        testContextSetup.getTestBase().webDriverManager().quit();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            File file = ((TakesScreenshot)testContextSetup.getTestBase().webDriverManager()).getScreenshotAs(OutputType.FILE);
            byte[] content = FileUtils.readFileToByteArray(file);
            scenario.attach(content, "image/png", "image");
        }
    }
}
