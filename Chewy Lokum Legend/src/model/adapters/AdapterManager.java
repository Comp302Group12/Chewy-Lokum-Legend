package model.adapters;

import model.*;
import model.adapters.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class AdapterManager {

	private static AdapterManager instance;
	private DrawingAdapter currentDrawingAdapter;
	private LokumSwapperAdapter currentLokumSwapperAdapter;

	public static AdapterManager getInstance(){
		if (instance == null) {
			instance = new AdapterManager();
		}
		return instance;
	}

	private AdapterManager() {
		// TODO Auto-generated constructor stub
		currentDrawingAdapter = new SimpleGraphicsDrawingAdapter();
		currentLokumSwapperAdapter = new RegularLokumSwapperAdapter();
	}

	public DrawingAdapter getCurrentDrawingAdapter() {
		return currentDrawingAdapter;
	}

	public LokumSwapperAdapter getCurrentLokumSwapperAdapter() {
		return currentLokumSwapperAdapter;
	}

}
