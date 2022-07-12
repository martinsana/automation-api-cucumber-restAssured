package suport.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/${ENV}.properties", "classpath:properties/local.properties"})
public interface ServerConfig extends Config {

    @Key("api.base.uri")
    String baseUri();

    @Key("api.base.path")
    String basePath();

    int port();

}
