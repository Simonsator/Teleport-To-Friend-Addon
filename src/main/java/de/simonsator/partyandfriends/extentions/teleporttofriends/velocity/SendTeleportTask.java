package de.simonsator.partyandfriends.extentions.teleporttofriends.velocity;

import com.google.gson.JsonObject;
import com.velocitypowered.api.event.Subscribe;
import de.simonsator.partyandfriends.velocity.api.PAFExtension;
import de.simonsator.partyandfriends.velocity.api.events.command.JumpToFriendEvent;
import de.simonsator.partyandfriends.velocity.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.velocity.communication.communicationtasks.SpigotCommunicationTask;

import java.util.concurrent.TimeUnit;

public class SendTeleportTask extends SpigotCommunicationTask {
    private final long DELAY;
    private final PAFExtension PLUGIN;
    private final String PERMISSION;

    protected SendTeleportTask(long pDelay, PAFExtension pPlugin, String pPermission) {
        super("SendTeleportTask");
        DELAY = pDelay;
        PLUGIN = pPlugin;
        PERMISSION = pPermission;
    }

    @Subscribe
    public void onJumpToFriend(JumpToFriendEvent pEvent) {
        if (!pEvent.isCancelled()) {
            OnlinePAFPlayer player = pEvent.getExecutor();
            OnlinePAFPlayer friend = pEvent.getFriendToJumpTo();
            if (player.hasPermission(PERMISSION))
                if (!player.getServer().equals(friend.getServer()))
                    TTFVelociyLoader.server.getScheduler().buildTask(PLUGIN, () -> sendTeleportToPlayer(player, friend)).delay(DELAY, TimeUnit.SECONDS).schedule();

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

