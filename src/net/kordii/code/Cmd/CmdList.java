package net.kordii.code.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdList implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String l , String args[]){
        if(sender.hasPermission("lc-list")) {
            if (args.length == 0) {
                int online = Bukkit.getOnlinePlayers().size();
                sender.sendMessage("§8»  §7Aktualna liczba graczy online wynosi: §c" + online + "§7.");
                String s = "§c";
                for (Player p : Bukkit.getOnlinePlayers()) {
                    String name = p.getName();
                    s = s + name + ", ";
                }
                sender.sendMessage(s);
            } else {
                sender.sendMessage("§8» §cPoprawne uzycie §c/list");
            }
        } else {
            sender.sendMessage("§cBrak Uprawnien! lc-list");
        }
        return false;
    }
}
