package com.gmail.ceezuns.noctis.users.cobble;

import com.gmail.ceezuns.noctis.utilities.ConfigurationFile;

public class CobbleManager {

	private CobbleStatus cobbleStatus;
	private ConfigurationFile configurationFile;

	public CobbleManager(ConfigurationFile configurationFile) {
		this.configurationFile = configurationFile;
	}

	public void load() {
		if (this.configurationFile.getConfiguration().getString("cobble") == null) {
			this.cobbleStatus = CobbleStatus.PICKUP;
			return;
		} else {
			this.cobbleStatus = CobbleStatus.valueOf(this.configurationFile.getConfiguration().getString("cobble"));
		}
	}

	public void save() {
		this.configurationFile.getConfiguration().set("cobble", this.cobbleStatus.name());
		this.configurationFile.save();
		this.cobbleStatus = null;
	}

	public CobbleStatus getCobbleStatus() {
		return cobbleStatus;
	}

	public void setCobbleStatus(CobbleStatus cobbleStatus) {
		this.cobbleStatus = cobbleStatus;
	}
}
