package de.simonsator.partyandfriends.extentions.teleporttofriends.bungee;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.friends.commands.Friends;
import de.simonsator.partyandfriends.friends.subcommands.Jump;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.config.Configuration;

import java.io.File;
import java.io.IOException;

public class TTFBungeePlugin extends PAFExtension {
	@Override
	public void onEnable() {
		try {
			Configuration config = new TTFBungeeConfig(new File(getConfigFolder(), "config.yml"), this).getCreatedConfiguration();
			ProxyServer.getInstance().getPluginManager().registerListener(this,
					new SendTeleportTask(config.getLong("TeleportDelay"), this, config.getString("Permission")));
			for (String server : config.getStringList("TeleportToPlayerServers")) {
				((Jump) Friends.getInstance().getSubCommand(Jump.class)).doNotCheckForSameServer(ProxyServer.getInstance().getServerInfo(server));
			}
			registerAsExtension();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
