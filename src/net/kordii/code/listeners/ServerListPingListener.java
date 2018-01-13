package net.kordii.code.listeners;

import net.kordii.code.config.ConfigMenager;
import net.kordii.code.utils.fixColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e){
        if(ConfigMenager.getConfig().getBoolean("motd")){
            e.setMotd(fixColor.fix(fixColor.fix(ConfigMenager.getConfig().getString("motd_lines"))));
        }
    }
}
