package nl.sest.gamejam.model.impl;

public class Train {

	protected TrainDestination destination;
	protected int numBobs = 0;
	protected boolean isUnloaded = false;
	
	public Train(TrainDestination destination, int numBobs) {
		this.destination = destination;
	}
	
	public TrainDestination getDestination() {
		return destination;
	}
	
	/**
	 * Get the number of Bobs on this train
	 * @return
	 */
	public int getNumBobs() {
		return numBobs;
	}
	
	/**
	 * Check if this train was already marked as unloaded.
	 * @return
	 */
	public boolean isUnloaded() {
		return isUnloaded;
	}
	
	/**
	 * Mark this Train as unloaded
	 * @param unloaded
	 */
	public void setUnloaded(boolean unloaded) {
		isUnloaded = unloaded;
	}

}
