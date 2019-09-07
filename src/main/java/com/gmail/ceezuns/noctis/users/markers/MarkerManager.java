package com.gmail.ceezuns.noctis.users.markers;

import com.gmail.ceezuns.noctis.Noctis;
import com.gmail.ceezuns.noctis.utilities.ConfigurationFile;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashSet;

public class MarkerManager {

	private static Noctis instance = Noctis.getInstance();

	private HashSet<Marker> markers;
	private ConfigurationFile configurationFile;

	public MarkerManager(ConfigurationFile configurationFile) {
		this.markers = new HashSet<>();
		this.configurationFile = configurationFile;
	}

	public void load() {
		ConfigurationSection section = this.configurationFile.getConfiguration().getConfigurationSection("markers");
		if (section == null) {
			return;
		} else {
			section.getKeys(false).forEach(marker -> {
				this.markers.add(new Marker(marker, new Location(instance.getServer().getWorld(section.getString(marker + ".world")), section.getInt(marker + ".x"), section.getInt(marker + ".y"), section.getInt(marker + ".z"))));
			});
		}
	}

	public void save() {
		ConfigurationSection section = this.configurationFile.getConfiguration().getConfigurationSection("markers");
		if (section == null) {
			return;
		} else {
			this.markers.forEach(marker -> {
				section.set(marker.getName() + ".world", marker.getLocation().getWorld().getName());
				section.set(marker.getName() + ".x", marker.getLocation().getBlockX());
				section.set(marker.getName() + ".y", marker.getLocation().getBlockY());
				section.set(marker.getName() + ".z", marker.getLocation().getBlockZ());
			});
			section.getKeys(false).forEach(marker -> {
				if (this.getMarker(marker) == null) {
					section.set(marker, null);
				}
			});
		}

		this.configurationFile.save();
		this.clearMarkers();
	}

	public void addMarker(Marker marker) {
		this.markers.add(marker);
	}

	public void removeMarker(Marker marker) {
		this.markers.remove(marker);
	}

	public void clearMarkers() {
		this.markers.clear();
	}

	public Marker getMarker(String name) {
		return this.markers.stream().filter(marker -> marker.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
	}

	public HashSet<Marker> getMarkers() {
		return this.markers;
	}
}