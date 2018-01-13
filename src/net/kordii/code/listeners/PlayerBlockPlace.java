package net.kordii.code.listeners;

import net.kordii.code.config.ConfigMenager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBlockPlace
        implements Listener
{
    @EventHandler
    public void onPlace(BlockPlaceEvent e)
    {
        if (ConfigMenager.getConfig().getBoolean("protection_blocks"))
        {
            if ((!e.getPlayer().getName().equals("KordiiOfficial"))) {
                e.setCancelled(true);
            } else{

            }
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e)
    {
        if (ConfigMenager.getConfig().getBoolean("protection_blocks"))
        {
            if ((!e.getPlayer().getName().equals("KordiiOfficial"))) {
                e.setCancelled(true);
            } else{

            }
        }
    }
}
