package model.adapter;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class AdapterManager {

	private static AdapterManager instance;
	private DrawingAdapter currentDrawingAdapter;

	public static AdapterManager getInstance(){
		if (instance == null) {
			instance = new AdapterManager();
		}
		return instance;
	}

	private AdapterManager() {
		// TODO Auto-generated constructor stub
		currentDrawingAdapter = new SimpleGraphicsDrawingAdapter();
	}

	public DrawingAdapter getCurrentDrawingAdapter() {
		return currentDrawingAdapter;
	}
	
}
