package net.kordii.code.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocessListner
        implements Listener {
    @EventHandler
    public void playerCmdPre(PlayerCommandPreprocessEvent event) {
        String command = event.getMessage().toLowerCase();
        Player player = event.getPlayer();
        if (!player.hasPermission("lc-plugins")) {
            if ((command.matches("/pl")) || (command.matches("/plugins")) || (command.matches("/ver")) ||
                    (command.matches("/version")) || (command.equals("/?")) || (command.equals("/help"))) {
                event.setCancelled(true);
                player.sendMessage("§cBrak Uprawnien! lc-plugins");
            }
            if ((command.startsWith("/bukkit")) || (command.startsWith("/spigot")) || (command.startsWith("/minecraft")) || (command.startsWith("//calculate")) || (command.startsWith("//calc")) || (command.startsWith("//eval")) || (command.startsWith("//evaluate")) || (command.startsWith("//solve")) || (command.startsWith("/worldedit:/eval")) || (command.startsWith("/worldedit:/evaluate")) || (command.startsWith("/worldedit:/calculate")) || (command.startsWith("/worldedit:/calc")) || (command.startsWith("/worldedit:/solve")) || (command.startsWith("/about")) || (command.startsWith("/icanhasbukkit"))) {
                event.setCancelled(true);
                player.sendMessage("§cBrak Uprawnien! lc-plugins");
            }
        }
    }
}
