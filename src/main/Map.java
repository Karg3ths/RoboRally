package main;

import com.jme3.tmx.TiledMapAppState;
import com.jme3.tmx.TmxLoader;
import com.jme3.tmx.core.TiledMap;

import javafx.stage.Stage;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.app.state.AppStateManager;

public class Map {
	public Stage mapNumber1;

	public class MapNumberOne {

		AssetManager.registerLoader(TmxLoader.class,"tmx","tsx");

		TiledMap map = (TiledMap) AssetManager.loadAsset("../Layout/Barrens.tmx");
		assert map!=null;

		StateManager.attach(new TiledMapAppState());

		TiledMapAppState tiledMap = AppStateManager.getState(TiledMapAppState.class);tiledMap.setMap(map);
	}

	public Stage getMapLoader() {
		return mapNumber1;
	}
}}
