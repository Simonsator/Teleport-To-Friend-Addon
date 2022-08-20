package de.simonsator.partyandfriends.extentions.teleporttofriends.velocity;


import de.simonsator.partyandfriends.velocity.api.PAFExtension;
import de.simonsator.partyandfriends.velocity.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;

public class TTFVelocityConfig extends ConfigurationCreator {

	protected TTFVelocityConfig(File file, PAFExtension pPlugin) throws IOException {
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
