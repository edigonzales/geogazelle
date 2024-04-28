package org.geogazelle;

import static elemental2.dom.DomGlobal.console;

import ol.MapOptions;
import ol.OLFactory;
import ol.interaction.DefaultInteractionsOptions;
import ol.interaction.Interaction;
import ol.interaction.MouseWheelZoom;

public class MapManager {
    private static MapManager INSTANCE;
        
    private static ol.Map olMap;
    
    public static MapManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MapManager();
            
            MapOptions mapOptions = OLFactory.createOptions();
            
            DefaultInteractionsOptions interactionOptions = new ol.interaction.DefaultInteractionsOptions();
            interactionOptions.setPinchRotate(false);
            
//            MouseWheelZoom mwz = new MouseWheelZoom();
//            mwz.set("constrainResolution", true);
            interactionOptions.setConstrainResolution(true);
            interactionOptions.setDoubleClickZoom(false);
            mapOptions.setInteractions(Interaction.defaults(interactionOptions));
            
//            console.log(mwz.getProperties());
            
            olMap = new ol.Map(mapOptions);
//            olMap.addInteraction(mwz);
        }
        
        return INSTANCE;
    }
    
    public ol.Map getMap() {
        return olMap;
    }
}
