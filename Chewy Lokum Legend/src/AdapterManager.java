
public class AdapterManager {

	private DrawingAdapter currentDrawingAdapter;
	private static AdapterManager instance;

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
