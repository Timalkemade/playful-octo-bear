package nl.sest.gamejam.model.impl;

import nl.sest.gamejam.events.*;
import nl.sest.gamejam.model.Event;

public interface EventListener {

	public abstract void onEvent(Event event);
	public abstract void onEvent(HeartbeatEvent event);
	public void onEvent(VirusKillEvent event);
	public void onEvent(CellKillEvent event);
	public void onEvent(CellPassEvent event);
	public void onEvent(VirusPassEvent event);


}
