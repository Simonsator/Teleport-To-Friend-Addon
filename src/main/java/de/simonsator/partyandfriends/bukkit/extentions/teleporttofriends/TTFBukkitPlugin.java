package de.simonsator.partyandfriends.bukkit.extentions.teleporttofriends;

import de.simonsator.partyandfriendsgui.communication.BungeecordCommunication;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class TTFBukkitPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		BungeecordCommunication.getInstance().registerTask(new TeleportToPlayerTask());
	}
}
