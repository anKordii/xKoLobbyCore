package net.kordii.code.Cmd;

import net.kordii.code.utils.ChatUtil;
import net.kordii.code.utils.fixColor;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdPvP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("lc-pvp")){
            ChatUtil.sendM(sender, "§cBrak Uprawnien! lc-pvp");
            return false;
        }
        if(cmd.getName().equalsIgnoreCase("reverse")){
            if(args.length !=1){
                return false;
            }
            String nazwa = args[0];
            if(Bukkit.getWorld(nazwa) !=null){
                Player p = (Player) sender;
                World w = Bukkit.getWorld(nazwa);
                w.setPVP(!w.getPVP());
                w.setDifficulty(Difficulty.EASY);
                p.sendMessage( "§8» §7Tryb serwera PVP zostal §c§lzmieniony§7!");
            }else {
                sender.sendMessage("§8» §cPoprawne uzycie §c/reverse <swiat>");
            }
        }
        return false;
    }
}
