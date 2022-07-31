package de.simonsator.partyandfriends.extentions.teleporttofriends.bukkit;

import de.simonsator.partyandfriendsgui.communication.BungeecordCommunication;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class TTFBukkitPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		BungeecordCommunication.getInstance().registerTask(new TeleportToPlayerTask());
	}
}
