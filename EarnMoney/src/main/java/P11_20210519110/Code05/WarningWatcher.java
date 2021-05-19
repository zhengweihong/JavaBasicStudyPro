package P11_20210519110.Code05;

public class WarningWatcher extends WeatherObserver {

  private String countryWatched;
  private WeatherRecorder theRecorder;

  public WarningWatcher(WeatherRecorder aWeatherRecorder, String countryToWatch) {
    theRecorder = aWeatherRecorder;
    countryWatched = countryToWatch;
    theRecorder.attach(this);
  }

  public void update() {
  // Modify this so that it only prints out the update text if the update is a "Warning" for the country being watched
    if (countryWatched==theRecorder.getUpdateCountry() && "Warning".equals(theRecorder.getUpdateType()))
      System.out.println("The WarningWatcher watching for Warnings for " +
                         countryWatched +
                         "\nhas noticed a new warning:\n\"" +
                         theRecorder.getUpdateText() + "\"\n");
  }
}
