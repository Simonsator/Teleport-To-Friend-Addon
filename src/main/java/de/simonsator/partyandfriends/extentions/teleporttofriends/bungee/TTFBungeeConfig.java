package de.simonsator.partyandfriends.extentions.teleporttofriends.bungee;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class TTFBungeeConfig extends ConfigurationCreator {

	protected TTFBungeeConfig(File file, PAFExtension pPlugin) throws IOException {
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
