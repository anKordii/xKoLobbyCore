package net.kordii.code.Cmd;

import net.kordii.code.Main;
import net.kordii.code.config.ConfigMenager;
import net.kordii.code.utils.Particle;
import net.kordii.code.utils.fixColor;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.awt.*;
import java.util.HashMap;
import java.util.UUID;

public class CmdVanish implements CommandExecutor{

    private Plugin plugin = Main.getPlugin();

    private HashMap<UUID, BukkitTask> list = new HashMap<UUID, BukkitTask>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("lc-vanish")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                UUID uuid = p.getUniqueId();
                if (args.length == 0) {
                    if(!list.containsKey(uuid)) {
                        BukkitTask id;
                        id = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
                            @Override
                            public void run() {
                                for(Player player : Bukkit.getOnlinePlayers()){
                                    player.hidePlayer(p);
                                }
                            }
                        },20, 20);
                        list.put(uuid, id);
                        Particle.giveParticle(p, EnumParticle.EXPLOSION_HUGE, p.getLocation(), 5, 5, 5, 1, 50);
                        p.sendMessage(fixColor.fix(ConfigMenager.getConfig().getString("vanish_poof")));
                    } else {
                        Particle.giveParticle(p, EnumParticle.EXPLOSION_HUGE, p.getLocation(), 5, 5, 5, 1, 50);
                        list.get(uuid).cancel();
                        list.remove(uuid);
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            player.showPlayer(p);
                        }
                        p.sendMessage(fixColor.fix(ConfigMenager.getConfig().getString("vanish")));
                    }
                } else {
                    String nick = args[0].toString();
                    if(Bukkit.getPlayer(nick) != null) {
                        Player player = Bukkit.getPlayer(nick);
                        if(!list.containsKey(uuid)) {
                            BukkitTask id;
                            id = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
                                @Override
                                public void run() {
                                    for(Player player : Bukkit.getOnlinePlayers()){
                                        player.hidePlayer(p);
                                    }
                                }
                            },20, 20);
                            list.put(uuid, id);
                            player.sendMessage(fixColor.fix(ConfigMenager.getConfig().getString("vanish_poof")));
                            Particle.giveParticle(player, EnumParticle.EXPLOSION_HUGE, p.getLocation(), 5, 5, 5, 1, 50);
                        } else {
                            list.get(uuid).cancel();
                            list.remove(uuid);
                            for (Player d : Bukkit.getOnlinePlayers()) {
                                d.showPlayer(player);
                            }
                            player.sendMessage(fixColor.fix(ConfigMenager.getConfig().getString("vanish")));
                            Particle.giveParticle(player, EnumParticle.EXPLOSION_HUGE, p.getLocation(), 5, 5, 5, 1, 50);
                        }
                    } else {
                        p.sendMessage(fixColor.fix(ConfigMenager.getConfig().getString("no_player")));
                    }
                }
            } else {
                sender.sendMessage("§8» §cPamietaj! aby uzyc tej komendy musisz byc §cGraczem!");
            }
        } else {
            sender.sendMessage("§cBrak Uprawnien! lc-time");
        }
        return false;
    }
}
