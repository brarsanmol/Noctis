package com.gmail.ceezuns.noctis.utilities;

import com.gmail.ceezuns.noctis.Noctis;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigurationFile {

	private static Noctis instance = Noctis.getInstance();

	private File file;
	private YamlConfiguration configuration;

	public ConfigurationFile(String name) {
		this.file = new File(instance.getDataFolder(), name + ".yml");

		if (!this.file.exists()) {
			this.file.getParentFile().mkdirs();
			instance.saveResource(name + ".yml", false);
		}

		this.configuration = new YamlConfiguration();
		try {
			this.configuration.load(this.file);
		} catch (IOException | InvalidConfigurationException exception) {
			exception.printStackTrace();
		}
	}

	public void save() {
		try {
			this.configuration.save(this.file);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public File getFile() {
		return this.file;
	}

	public YamlConfiguration getConfiguration() {
		return this.configuration;
	}
}
