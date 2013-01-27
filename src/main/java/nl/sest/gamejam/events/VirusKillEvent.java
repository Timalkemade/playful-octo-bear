package nl.sest.gamejam.events;

import nl.sest.gamejam.model.Event;
import nl.sest.gamejam.model.impl.Bob;

public class VirusKillEvent implements Event{

	private long timestamp = 0;
	private Bob bob;
	
	public VirusKillEvent (long timestamp, Bob bob) {
		this.timestamp = timestamp;
		this.bob = bob;
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}
	
	public Bob getBob() {
		return bob;
	}

}
