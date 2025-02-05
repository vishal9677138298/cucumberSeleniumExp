package org.vishal.selenium;

public enum Browser {
    CHROME, FIREFOX, SAFARI;

    public static Browser getRuntimeBrowser(){
        String requestedBrowser = System.getProperty("browser");
        if(requestedBrowser == null){
            return CHROME;
        }

        Browser browser = null;

        switch (requestedBrowser) {
            case "chrome":
                browser = CHROME;
                break;
            case "firefox":
                browser = FIREFOX;
                break;
            case "safari":
                browser = SAFARI;
                break;
        }
        return browser;
    }
}
