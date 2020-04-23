package Adapters;

public interface LokumDestroyerAdapter {
	
	public boolean checkDestroyableLokums();
	public void destroySwappedLokums();
	public void destroyLokums();
	public void destroyStreakLokums();
	public void destroySpecialCombinationLokum(int typeOfCombination);
	
}
