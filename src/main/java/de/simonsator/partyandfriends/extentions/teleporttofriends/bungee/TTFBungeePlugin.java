package de.simonsator.partyandfriends.extentions.teleporttofriends.bungee;

import de.simonsator.partyandfriends.api.PAFExtension;
import de.simonsator.partyandfriends.api.adapter.BukkitBungeeAdapter;
import de.simonsator.partyandfriends.friends.commands.Friends;
import de.simonsator.partyandfriends.friends.subcommands.Jump;
import de.simonsator.partyandfriends.utilities.ConfigurationCreator;
import net.md_5.bungee.api.ProxyServer;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class TTFBungeePlugin extends PAFExtension {
	@Override
	public void onEnable() {
		try {
			ConfigurationCreator config = new TTFBungeeConfig(new File(getConfigFolder(), "config.yml"), this);
			BukkitBungeeAdapter.getInstance().registerListener(new SendTeleportTask(config.getLong("TeleportDelay"), this, config.getString("Permission")),
					this);
			for (String server : config.getStringList("TeleportToPlayerServers")) {
				((Jump) Friends.getInstance().getSubCommand(Jump.class)).doNotCheckForSameServer(ProxyServer.getInstance().getServerInfo(server));
			}
			registerAsExtension();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
