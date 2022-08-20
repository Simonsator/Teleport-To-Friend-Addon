package de.simonsator.partyandfriends.extentions.teleporttofriends.velocity;

import de.simonsator.partyandfriends.velocity.api.PAFExtension;
import de.simonsator.partyandfriends.velocity.api.adapter.BukkitBungeeAdapter;
import de.simonsator.partyandfriends.velocity.friends.commands.Friends;
import de.simonsator.partyandfriends.velocity.friends.subcommands.Jump;
import de.simonsator.partyandfriends.velocity.utilities.ConfigurationCreator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


public class TTFVelocityPlugin extends PAFExtension {

	public TTFVelocityPlugin(Path folder) {
		super(folder);
	}

	@Override
	public void onEnable() {
		try {
			ConfigurationCreator config = new TTFVelocityConfig(new File(getConfigFolder(), "config.yml"), this);
			BukkitBungeeAdapter.getInstance().registerListener(new SendTeleportTask(config.getLong("TeleportDelay"),
					this, config.getString("Permission")), this);
			for (String server : config.getStringList("TeleportToPlayerServers")) {
				TTFVelocityLoader.server.getServer(server).ifPresent(registeredServer ->
						((Jump) Friends.getInstance().getSubCommand(Jump.class)).
								doNotCheckForSameServer(registeredServer.getServerInfo()));
			}
			registerAsExtension();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return "Teleport-To-Friend-PAF-Extension";
	}


}
