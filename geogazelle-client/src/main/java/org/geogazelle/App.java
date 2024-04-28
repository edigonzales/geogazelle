package org.geogazelle;

import static elemental2.dom.DomGlobal.console;
import static org.jboss.elemento.Elements.*;

import com.google.gwt.core.client.EntryPoint;

import ol.Collection;
import ol.Coordinate;
import ol.Extent;
import ol.MapOptions;
import ol.OLFactory;
import ol.View;
import ol.ViewOptions;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.proj.ProjectionOptions;
import ol.source.Wmts;
import ol.source.WmtsOptions;
import ol.tilegrid.TileGrid;
import ol.tilegrid.WmtsTileGrid;
import ol.tilegrid.WmtsTileGridOptions;
import proj4.Proj4;

import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.geogazelle.components.map.MapComponent;
import org.dominokit.domino.ui.themes.DominoThemeAccent;
import org.dominokit.domino.ui.themes.DominoThemeLight;

import org.dominokit.domino.ui.forms.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        ConfigManager configManager = ConfigManager.getInstance();
        configManager.loadConfig();
        console.log("Hallo Config");
        
        DominoThemeManager.INSTANCE.apply(DominoThemeLight.INSTANCE);
        DominoThemeManager.INSTANCE.apply(DominoThemeAccent.RED); 

        console.log("Hallo Stefan.");

//        body().add(TextBox.create().setLabel("User name")
//                                .setPlaceholder("Username").element());
//        
//        
//        BasemapElement basemapElement = new BasemapElement();
//        body().add(basemapElement);
//        
//        LineElement lineElement = new LineElement();
//        body().add(lineElement);
        
        body().add(div().id("ol-map"));
        MapComponent mapComponent = new MapComponent();
        

    }
}