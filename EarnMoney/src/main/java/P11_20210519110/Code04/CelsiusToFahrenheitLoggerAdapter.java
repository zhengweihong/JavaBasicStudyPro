package P11_20210519110.Code04;

public class CelsiusToFahrenheitLoggerAdapter extends CelsiusLogger {
    private FahrenheitLogger fahrenheitLogger;
    public CelsiusToFahrenheitLoggerAdapter() {
        fahrenheitLogger = new FahrenheitLogger();
    }

    @Override
    public void setTemperature(double aCelsiusTemp) {
        fahrenheitLogger.setTemperature((aCelsiusTemp * 9/5 + 32));
    }

    @Override
    public double getTemperature() {
        return (((fahrenheitLogger.getTemperature()) - 32) * 5/9);
    }
}
