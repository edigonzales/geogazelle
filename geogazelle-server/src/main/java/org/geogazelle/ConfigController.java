package org.geogazelle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ConfigController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${app.configFile}")
    private String configFile;   

    @RequestMapping(value = "/config.json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getConfig() throws IOException, InterruptedException {
        String content = Files.readString(Paths.get(configFile));
        
        //Thread.sleep(5000);
        
        return content;
    }
}
