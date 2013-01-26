package nl.sest.gamejam.events;

import nl.sest.gamejam.model.Event;
import nl.sest.gamejam.model.impl.Heartbeat;

public class HeartbeatEvent implements Event {

	private long timestamp = 0;
	private Heartbeat heartbeat;
	
	public HeartbeatEvent(Heartbeat hb, long timestamp) {
		this.timestamp = timestamp;
		this.heartbeat = hb;
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}
	
	/**
	 * Get the Heartbeat of the event.
	 * @return
	 */
	public Heartbeat getHeartbeat() {
		return heartbeat;
	}

}
