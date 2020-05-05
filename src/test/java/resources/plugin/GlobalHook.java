package resources.plugin;


import com.codeborne.selenide.Configuration;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import resources.config.ConfigPropertyReader;
import resources.config.ConfigReader;

public class GlobalHook implements ConcurrentEventListener {


    private ConfigReader configReader = new ConfigPropertyReader();
        EventHandler testRunStartHandler =  (EventHandler<TestRunStarted>)event -> setDriver();

         @Override
         public void setEventPublisher(EventPublisher publisher) {
             publisher.registerHandlerFor(TestRunStarted.class, e -> setDriver());
    }


    public void setDriver() {
            Configuration.browser = (configReader.getValue("default.driver"));
            Configuration.clickViaJs = true;

    }
}
