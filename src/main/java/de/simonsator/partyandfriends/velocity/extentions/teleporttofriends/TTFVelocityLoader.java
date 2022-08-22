package de.simonsator.partyandfriends.velocity.extentions.teleporttofriends;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import de.simonsator.partyandfriends.velocity.VelocityExtensionLoadingInfo;
import de.simonsator.partyandfriends.velocity.main.PAFPlugin;


import java.nio.file.Path;

@Plugin(id = "teleport-to-friend-paf-extension", name = "TeleportToFriendsAddon", version = "1.0.3-RELEASE",
		url = "https://www.spigotmc.org/resources/51060/", description = "Loads Teleport To Friend PAF Extension", authors = {"JT122406", "Simonsator"}, dependencies = {@Dependency(id = "partyandfriends")})

public class TTFVelocityLoader {
	public static ProxyServer server = null;
	private final Path folder;

	@Inject
	public TTFVelocityLoader(@DataDirectory final Path folder, ProxyServer server) {
		TTFVelocityLoader.server = server;
		this.folder = folder;
	}

	@Subscribe
	public void onProxyInitialization(ProxyInitializeEvent event) {
		PAFPlugin.loadExtension(new VelocityExtensionLoadingInfo(new TTFVelocityPlugin(folder),
				"teleport-to-friend-paf-extension",
				"An add-on for party and friends extended to teleport players to their friend when they jump to them",
				"1.0.3-RELEASE", "JT122406"));
	}
}
