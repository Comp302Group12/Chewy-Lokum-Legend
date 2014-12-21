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
	private LokumSwapperAdapter currentLokumSwapperAdapter;
	private LokumCombinationAdapter currentLokumCombinationAdapter;
	private LokumDestroyerAdapter currentLokumDestroyerAdapter;
	private LokumFallerAdapter currentLokumFallerAdapter;
	private ScoreCalculatorAdapter currentScoreCalculatorAdapter;
	private SaveAndLoadAdapter currentSaveAndLoadAdapter;

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
		currentLokumCombinationAdapter = new LokumCombinationAdapter();
		currentLokumDestroyerAdapter = new LokumDestroyerAdapter();
		currentLokumFallerAdapter = new LokumFallerAdapter();
		currentScoreCalculatorAdapter = new ScoreCalculatorAdapter();
		currentSaveAndLoadAdapter = new SaveAndLoadAdapter();
	}

	public DrawingAdapter getCurrentDrawingAdapter() {
		return currentDrawingAdapter;
	}

	public LokumSwapperAdapter getCurrentLokumSwapperAdapter() {
		return currentLokumSwapperAdapter;
	}

	public LokumCombinationAdapter getCurrentLokumCombinationAdapter() {
		return currentLokumCombinationAdapter;
	}

	public LokumDestroyerAdapter getCurrentLokumDestroyerAdapter() {
		return currentLokumDestroyerAdapter;
	}

	public LokumFallerAdapter getCurrentLokumFallerAdapter() {
		return currentLokumFallerAdapter;
	}

	public ScoreCalculatorAdapter getCurrentScoreCalculatorAdapter() {
		return currentScoreCalculatorAdapter;
	}

	public SaveAndLoadAdapter getCurrentSaveAndLoadAdapter() {
		return currentSaveAndLoadAdapter;
	}

}
