package utils;

import pageObjects.PageObjectManager;

public class TestContextSetup {
    private final PageObjectManager pageObjectManager;
    private final TestBase testBase;
    private final GenericUtils genericUtils;

    public TestContextSetup() {
        this.testBase = new TestBase();
        this.pageObjectManager = new PageObjectManager(testBase.webDriverManager());
        this.genericUtils = new GenericUtils(testBase.webDriverManager());
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public TestBase getTestBase() {
        return testBase;
    }

    public GenericUtils getGenericUtils() {
        return genericUtils;
    }
}
