package de.simonsator.partyandfriends.extentions.teleporttofriends.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import de.simonsator.partyandfriends.velocity.VelocityExtensionLoadingInfo;
import de.simonsator.partyandfriends.velocity.main.PAFPlugin;

import java.nio.file.Path;

@Plugin(id = "Teleport-To-Friend-PAF-Extension", name = "TeleportToFriendsAddon", version = "1.0.2-RELEASE",
        url = "https://www.spigotmc.org/resources/teleport-jump-extension-for-party-and-friends-extended-edition-for-bungeecord.51060/", description = "Velocity Port", authors = {"JT122406"})
public class TTFVelociyLoader {
    private final Path folder;
    public static ProxyServer server = null;

    @Inject
    public TTFVelociyLoader(@DataDirectory final Path folder, ProxyServer server) {
        TTFVelociyLoader.server = server;
        this.folder = folder;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        PAFPlugin.loadExtension(new VelocityExtensionLoadingInfo(new TTFVelocityPlugin(folder),
                "Teleport-To-Friend-PAF-Extension", "Loads Teleport To Friend PAF Extension", "1.0.2", "JT122406"));
    }
}
