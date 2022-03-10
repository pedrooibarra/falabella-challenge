package com.falabella.challenge.Utils.BrowserStack;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class BrowserStackBase {

    protected static void setProjectCapabilities(DesiredCapabilities capabilities){
        capabilities.setCapability("name", System.getProperty("project.name", "Falabella Automation"));
        capabilities.setCapability("project", System.getProperty("project.project", "Falabella Challenge"));
        capabilities.setCapability("build", System.getProperty("project.build", "Testing"));
    }

    protected static void setDefaultCapabilities(DesiredCapabilities desiredCapabilities){

        String browserStackLocal = System.getProperty("browserstack.local", "true");
        String browserStackLocalIdentifier = System.getProperty("browserstack.localIdentifier");

        String so = System.getProperty("browserstack.os");
        desiredCapabilities.setCapability("browserstack.localIdentifier", browserStackLocalIdentifier);
        desiredCapabilities.setCapability("browserstack.local", browserStackLocal);
        desiredCapabilities.setCapability("browserstack.debug", System.getProperty("browserstack.debug", "false"));
        desiredCapabilities.setCapability("browserstack.networkLogs", System.getProperty("browserstack.networkLogs", "true"));
        desiredCapabilities.setCapability("browserstack.video", System.getProperty("browserstack.video", "true"));
        desiredCapabilities.setCapability("browserstack.console", "errors");
        desiredCapabilities.setCapability("browserstack.idleTimeout", System.getProperty("browserstack.idleTimeout", "90"));
        desiredCapabilities.setCapability("browserstack.timezone", System.getProperty("browserstack.timezone", "Santiago"));
        desiredCapabilities.setCapability("acceptSslCerts", true);
        desiredCapabilities.setCapability("acceptInsecureCerts", true);
        desiredCapabilities.setCapability("autoAcceptAlerts", true);
        desiredCapabilities.setCapability("resolution", so.equals("Windows") ? "1366x768" : "1280x960");
    }

    protected static URL getURL() throws MalformedURLException{
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        return new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");
    }

    public static void markAs(String status, String sessionId) throws URISyntaxException, IOException {
        String testStatus = "Failed";
        if(status.equals("PASSED")){
            testStatus = "Passed";
        }

        URI uri = new URI("https://" + System.getenv("BROWSERSTACK_USERNAME") + ":"+ System.getenv("BROWSERSTACK_ACCESS_KEY") + "@api.browserstack.com/automate/sessions/" + sessionId + ".json");

        HttpPut putRequest = new HttpPut(uri);
        ArrayList<BasicNameValuePair> nameValuePairs = new ArrayList();
        nameValuePairs.add(new BasicNameValuePair("status", testStatus));
        if(status.equals("FAILED")){
            nameValuePairs.add(new BasicNameValuePair("reason", testStatus));
        }

        putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(putRequest);
    }

    protected static void setChromeOptionsCapabilities(DesiredCapabilities desiredCapabilities){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("-lang=es-cl");
        desiredCapabilities.setCapability("goog:chromeOptions", chromeOptions);
    }
}
