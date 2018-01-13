package net.kordii.code.Cmd;

import net.kordii.code.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdPogoda implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("lc-pogoda")){
            ChatUtil.sendM(sender, "§cBrak Uprawnien! lc-pogoda");
            return false;
        }
        if(cmd.getName().equalsIgnoreCase("pogoda")){
            if(args.length == 1){
                if(sender instanceof Player){
                    World w = ((Player)sender).getWorld();
                    if(args[0].equalsIgnoreCase("sun")){
                        Player p = (Player) sender;
                        w.setStorm(false);
                        w.setThundering(false);
                        p.sendMessage("§8» §7Pogoda ustawiona na §cbez chmurna");
                        return true;
                    }
                    if(args[0].equalsIgnoreCase("storm")){
                        Player p = (Player) sender;
                        w.setStorm(true);
                        w.setThundering(false);
                        p.sendMessage("§8» §7Pogoda ustawiona na §cDeszczowa");
                        return true;
                    } else {
                        sender.sendMessage("§8» §cPoprawne uzycie §c/pogoda <sun/storm>");
                    }
                }
            }
            if(args.length == 2){
                String nazwa = args[1];
                if(Bukkit.getWorld(nazwa) !=null){
                    World w = Bukkit.getWorld(nazwa);
                    if(args[0].equalsIgnoreCase("storm")){
                        Player p = (Player) sender;
                        w.setStorm(true);
                        w.setThundering(false);
                        p.sendMessage("§8» §7Pogoda ustawiona na §cDeszczowa");
                        return true;
                    } else {
                        sender.sendMessage("§8» §cPoprawne uzycie §c/pogoda <sun/storm>");
                    }
                } else{
                    sender.sendMessage("§cNie ma takiego swiata!");
                }
            }
            else{
            }
        }
        return false;
    }
}

