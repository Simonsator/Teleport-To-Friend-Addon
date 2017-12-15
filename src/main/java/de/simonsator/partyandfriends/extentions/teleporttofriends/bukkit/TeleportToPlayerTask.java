package de.simonsator.partyandfriends.extentions.teleporttofriends.bukkit;

import com.google.gson.JsonObject;
import de.simonsator.partyandfriendsgui.communication.tasks.CommunicationTask;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportToPlayerTask extends CommunicationTask {
	protected TeleportToPlayerTask() {
		super("TeleportToPlayer");
	}

	@Override
	public void executeTask(Player pPlayer, JsonObject jsonObject) {
		Player toTeleportTo = Bukkit.getServer().getPlayer(jsonObject.get("toTeleportTo").getAsString());
		if (toTeleportTo != null)
			pPlayer.teleport(toTeleportTo);
	}
}
