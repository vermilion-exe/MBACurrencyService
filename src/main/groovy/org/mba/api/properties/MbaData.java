package org.mba.api.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mba.currency-rates")
public class MbaData {

    private String azn;
    private String usd;
    private String eur;

}
