package de.simonsator.partyandfriends.extentions.teleporttofriends.bungee;

import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class TTFBungeeConfig extends ConfigurationCreator {

	protected TTFBungeeConfig(File file, Plugin pPlugin) throws IOException {
		super(file, pPlugin);
		copyFromJar();
		readFile();
		loadDefaults();
		saveFile();
	}

	private void loadDefaults() {
		set("TeleportDelay", 150);
		set("TeleportToPlayerServers", "lobby", "survival");
		set("Permission", "");
	}
}
