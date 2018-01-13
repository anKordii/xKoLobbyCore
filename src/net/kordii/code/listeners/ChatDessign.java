package net.kordii.code.listeners;

import net.kordii.code.config.ConfigMenager;
import net.kordii.code.utils.fixColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatDessign implements Listener{


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        if (ConfigMenager.getConfig().getBoolean("chat_format"))
        {
            Player p = e.getPlayer();
            String s = fixColor.fix(ConfigMenager.getConfig().getString("format_chat")).replace("{player}", p.getName());
            e.setFormat(s.replace("{message}", e.getMessage()));
        }
    }
}
