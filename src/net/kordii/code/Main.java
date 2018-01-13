package net.kordii.code;

import net.kordii.code.Cmd.*;
import net.kordii.code.listeners.*;
import net.kordii.code.config.ConfigMenager;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.List;
import java.util.ArrayList;

public class Main extends JavaPlugin implements Listener {
    private static Main plugin;
    private static Main instance;

    @Override
    public void onEnable() {
        plugin = this;
        instance = this;
        ConfigMenager config = new ConfigMenager();
        config.check();
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new onJQ(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new ServerListPingListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerCommandPreprocessListner(), this);
        getServer().getPluginManager().registerEvents(new PlayerBlockPlace(), this);
        getServer().getPluginManager().registerEvents(new ChatDessign(), this);

        getCommand("gm").setExecutor(new CmdGamemode());
        getCommand("bc").setExecutor(new CmdBroadcast());
        getCommand("czas").setExecutor(new CmdTime());
        getCommand("pogoda").setExecutor(new CmdPogoda());
        getCommand("reverse").setExecutor(new CmdPvP());
        getCommand("list").setExecutor(new CmdList());
        getCommand("v").setExecutor(new CmdVanish());
        getLogger().warning("This version is a non-licenced and not full operational plugin");
        getServer().getPluginManager().registerEvents(this, this);

    }

    public static Main getPlugin() {
        return plugin;
    }


    @Override
    public void onDisable(){
        Bukkit.getServer().getScheduler().cancelAllTasks();
    }
    public static Main getInst(){
        return instance;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        try
        {
            sendTitle(event.getPlayer(), fixColor(getConfig().getString("Title")), fixColor(getConfig().getString("subTitle")));
        }
        catch (Exception e)
        {
            getLogger().info("Nastapil blod w wysylaniu titlesow!");
        }
    }

    private void sendTitle(Player player, String messageA, String messageB)
    {
        IChatBaseComponent Title = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + messageA + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");
        IChatBaseComponent subTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + messageB + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, Title);
        PacketPlayOutTitle subtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subTitle);

        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(title);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(subtitle);
    }

    public static String fixColor(String s)
    {
        return ChatColor.translateAlternateColorCodes('&', s);
    }


}
