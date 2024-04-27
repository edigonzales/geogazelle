package org.geogazelle;

import static elemental2.dom.DomGlobal.console;

import java.util.List;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;

import elemental2.core.Global;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType(isNative=true, namespace=JsPackage.GLOBAL, name="Object")
public class GazelleConfig {
    //public String foo = "123";
    
    @JsProperty
    public Basemap[] basemaps;

//    public GazelleConfig(Object jsonConfig) {        
//        JsPropertyMap<Object> configMap = Js.asPropertyMap(jsonConfig);
//        
//        console.log(configMap.get("basemaps"));
//        
//        console.log(Global.JSON.parse(jsonConfig.toString()));
//        
//        Any[] basemaps = Js.asArray(configMap.get("basemaps"));
//        for (int i=0; i<basemaps.length; i++) {
//            JsPropertyMap<?> basemap = Js.asPropertyMap(basemaps[i]);
//        }
//    }

    @JsType(isNative=true, namespace=JsPackage.GLOBAL, name="Object")
    public class Basemap {
        @JsProperty
        public String id;

        @JsProperty
        public String title;
        
        @JsProperty
        public String url;

        @JsProperty
        public String layer;

        @JsProperty
        public boolean active;

        @JsProperty
        public String thumbnail;
    }
}



