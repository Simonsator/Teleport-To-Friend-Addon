package de.simonsator.partyandfriends.extentions.teleporttofriends.bungee;

import com.google.gson.JsonObject;
import de.simonsator.partyandfriends.api.events.command.JumpToFriendEvent;
import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.communication.communicationtasks.SpigotCommunicationTask;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

import java.util.concurrent.TimeUnit;

public class SendTeleportTask extends SpigotCommunicationTask implements Listener {
	private final long DELAY;
	private final Plugin PLUGIN;
	private final String PERMISSION;

	protected SendTeleportTask(long pDelay, Plugin pPlugin, String pPermission) {
		super("SendTeleportTask");
		DELAY = pDelay;
		PLUGIN = pPlugin;
		PERMISSION = pPermission;
	}

	@EventHandler
	public void onJumpToFriend(JumpToFriendEvent pEvent) {
		if (!pEvent.isCancelled()) {
			OnlinePAFPlayer player = pEvent.getExecutor();
			OnlinePAFPlayer friend = pEvent.getFriendToJumpTo();
			if (player.hasPermission(PERMISSION))
				if (!player.getServer().equals(friend.getServer()))
					ProxyServer.getInstance().getScheduler().schedule(PLUGIN, () -> sendTeleportToPlayer(player, friend), DELAY, TimeUnit.MILLISECONDS);
				else sendTeleportToPlayer(player, friend);
		}
	}

	private void sendTeleportToPlayer(OnlinePAFPlayer pPlayer, OnlinePAFPlayer pFriend) {
		JsonObject toSend = new JsonObject();
		toSend.addProperty("task", "TeleportToPlayer");
		toSend.addProperty("toTeleportTo", pFriend.getName());
		sendMessage(toSend, pPlayer);

	}
}
