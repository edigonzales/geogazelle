package org.geogazelle;

import elemental2.core.Global;
import elemental2.dom.DomGlobal;
import elemental2.promise.Promise;
import jsinterop.base.Js;

import static elemental2.dom.DomGlobal.console;
import static elemental2.dom.DomGlobal.fetch;

public class ConfigManager {
    private static ConfigManager INSTANCE;
    
    private GazelleConfig config = null;
    
    private Promise<GazelleConfig> loadingPromise = null; 
    
    public static ConfigManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ConfigManager();
        }
        
        return INSTANCE;
    }
    
    public GazelleConfig getConfig() {
        return config;
    }
    
    public Promise<GazelleConfig> loadConfig() {
        if (loadingPromise != null) {
            // There's already a promise for loading the configuration
            // => return it instead of starting another request
            console.log("There's already a promise for loading the configuration.");
            return loadingPromise;
        }

        if (config != null) {
            // Config was already loaded.
            // => stop here
            console.log("Config was already loaded.");
            return Promise.resolve(config);
        }

        console.log("Loading Application Configuration...");
        loadingPromise = fetch("config.json")
                .then(response -> {
                    if (!response.ok) {
                        DomGlobal.window.alert(response.statusText + ": " + response.body);
                        return null;
                    }
                    return response.text();
                }).then(textConfig -> {
                    config = Js.cast(Global.JSON.parse(textConfig));
                    
                    String id = config.basemaps[0].id;
                    console.log(id);
                                       
                    return null;
                }).catch_(error -> {
                    console.log(error);
                    DomGlobal.window.alert(error.toString());
                    return null;
                });
        return loadingPromise;
    }
}
