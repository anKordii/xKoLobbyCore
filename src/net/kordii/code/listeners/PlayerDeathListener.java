package net.kordii.code.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDead(PlayerDeathEvent e){
        if(e.getEntity().getKiller() instanceof Player) {
            e.setDeathMessage("");
        }
    }
}
