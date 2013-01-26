package nl.sest.gamejam.model;

public class Train {

	protected TrainDestination destination;
	
	public Train(TrainDestination destination) {
		this.destination = destination;
	}
	
	public TrainDestination getDestination() {
		return destination;
	}

}
