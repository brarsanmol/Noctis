package ca.anmolbrar.users.graves;

import org.bukkit.Location;

public class Grave {

    private String timestamp;
    private String deathCause;
    private Location location;

    public Grave(String timestamp, String deathCause, Location location) {
        this.timestamp = timestamp;
        this.deathCause = deathCause;
        this.location = location;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getDeathCause() {
        return this.deathCause;
    }

    public Location getLocation() {
        return this.location;
    }
}
