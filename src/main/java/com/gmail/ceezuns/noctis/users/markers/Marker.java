package com.gmail.ceezuns.noctis.users.markers;

import org.bukkit.Location;

public class Marker {

	private String name;
	private Location location;

	public Marker(String name, Location location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
