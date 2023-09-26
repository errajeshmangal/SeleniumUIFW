package utils;

import org.aeonbits.owner.Config;

import java.util.concurrent.TimeUnit;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
                "system:env",
                "file:./src/test/resources/ConfigReader.properties",
})
public interface ConfigReader extends Config {

   @DefaultValue("qa")
    @Key("env")
    String environment();

    @Key("${env}.url")
    String url();

    @Key("${env}.browser")
    @DefaultValue("CHROME")
    String browser();

    @DefaultValue("SECONDS")
    TimeUnit value();

    @DefaultValue("30")
    Long timeout();

}