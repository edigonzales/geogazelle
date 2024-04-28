package org.geogazelle.components.map;

import org.geogazelle.MapManager;
import org.geogazelle.ViewManager;
import org.jboss.elemento.IsElement;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import ol.Coordinate;
import ol.OLFactory;
import ol.View;
import ol.layer.LayerOptions;
import ol.layer.Tile;
import ol.proj.Projection;
import ol.source.Wmts;
import ol.source.WmtsOptions;
import ol.tilegrid.TileGrid;
import ol.tilegrid.WmtsTileGrid;
import ol.tilegrid.WmtsTileGridOptions;

public class MapComponent implements IsElement<HTMLElement> {
    private MapManager mapManager;
    
    private ViewManager viewManager;
    
    private ol.Map olMap;
    
    private HTMLDivElement mapTarget;
    
    public MapComponent() {
        mapManager = MapManager.getInstance();
        viewManager = ViewManager.getInstance();
        
        olMap = mapManager.getInstance().getMap();
        
        olMap.setTarget("ol-map");
        
        View view = viewManager.getView();
        olMap.setView(view);
        
               
        double resolutions[] = new double[] { 4000.0, 2000.0, 1000.0, 500.0, 250.0, 100.0, 50.0, 20.0, 10.0, 5.0, 2.5, 1.0, 0.5, 0.25, 0.1 };

        WmtsOptions wmtsOptions = OLFactory.createOptions();
        wmtsOptions.setUrl("https://geo.so.ch/api/wmts/1.0.0/{Layer}/default/2056/{TileMatrix}/{TileRow}/{TileCol}");
        wmtsOptions.setLayer("ch.so.agi.hintergrundkarte_sw");
        wmtsOptions.setRequestEncoding("REST");
        wmtsOptions.setFormat("image/png");
        wmtsOptions.setMatrixSet("EPSG:2056");
        wmtsOptions.setStyle("default");
        wmtsOptions.setProjection(view.getProjection());
        wmtsOptions.setWrapX(true);
        wmtsOptions.setTileGrid(createWmtsTileGrid(view.getProjection(), resolutions));

        Wmts wmtsSource = new Wmts(wmtsOptions);

        LayerOptions wmtsLayerOptions = OLFactory.createOptions();
        wmtsLayerOptions.setSource(wmtsSource);

        Tile wmtsLayer = new Tile(wmtsLayerOptions);
        wmtsLayer.setOpacity(1);
        
        
        olMap.addLayer(wmtsLayer);
//        olMap.updateSize();
        

        
    }
    
    @Override
    public HTMLElement element() {
        return null;
    }
    
    private static TileGrid createWmtsTileGrid(Projection projection, double[] resolutions) {
        WmtsTileGridOptions wmtsTileGridOptions = OLFactory.createOptions();
        
        String[] matrixIds = new String[resolutions.length];

        for (int z = 0; z < resolutions.length; ++z) {
            matrixIds[z] = String.valueOf(z);
        }

        Coordinate tileGridOrigin = projection.getExtent().getTopLeft();
        wmtsTileGridOptions.setOrigin(tileGridOrigin);
        wmtsTileGridOptions.setResolutions(resolutions);
        wmtsTileGridOptions.setMatrixIds(matrixIds);

        return new WmtsTileGrid(wmtsTileGridOptions);
    }


}
