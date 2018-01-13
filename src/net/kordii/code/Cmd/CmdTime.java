package net.kordii.code.Cmd;

import net.kordii.code.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdTime implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("lc-time")){
            ChatUtil.sendM(sender, "§cBrak Uprawnien! lc-time");
            return false;
        }
        if(cmd.getName().equalsIgnoreCase("czas")){
                if(args.length == 2){
                    String nazwa = args[1];
                    if(Bukkit.getWorld(nazwa) !=null){
                        World w = Bukkit.getWorld(nazwa);
                        Long l = Long.parseLong(args[0]);
                        w.setTime(l);
                    } else{
                        sender.sendMessage("§8» §cPoprawne uzycie §c/czas <czas> <swiat>");
                    }
                }
            }
        return false;
    }
}

