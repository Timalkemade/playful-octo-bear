package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.events.HeartbeatEvent;
import nl.sest.gamejam.model.Event;

public interface EventListener {

	public abstract void onEvent(Event event);
	public abstract void onEvent(HeartbeatEvent event);
	

}
