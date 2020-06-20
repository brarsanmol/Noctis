package com.gmail.ceezuns.noctis.users.graves;

import org.bukkit.Location;
import org.bukkit.event.entity.EntityDamageEvent;

import java.time.LocalDateTime;
import java.util.Date;

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
