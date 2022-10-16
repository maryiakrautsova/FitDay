package drivermanager;

public class DriverFactory {

    public DriverManager getManager(DriverType driverType) {

        DriverManager driverManager;

        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case OPERA:
                driverManager = new OperaDriverManager();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            default:
                throw new IllegalStateException("Unexpected driver type " + driverType);
        }
        return driverManager;
    }
}
