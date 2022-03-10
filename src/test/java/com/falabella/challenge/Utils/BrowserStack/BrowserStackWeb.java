package com.falabella.challenge.Utils.BrowserStack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class BrowserStackWeb extends BrowserStackBase {
    public BrowserStackWeb(){
    }

    public static WebDriver buildBrowserStackWeb(String browser, String version, String os, String osVersion) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browser", browser);
        desiredCapabilities.setCapability("browser_version", version);
        desiredCapabilities.setCapability("os", os);
        desiredCapabilities.setCapability("os_version", osVersion);

        if("chrome".equals(browser)){
            setChromeOptionsCapabilities(desiredCapabilities);
        }

        setProjectCapabilities(desiredCapabilities);
        setDefaultCapabilities(desiredCapabilities);
        return new RemoteWebDriver(getURL(), desiredCapabilities);
    }
}
