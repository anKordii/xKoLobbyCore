package net.kordii.code.Cmd;

import net.kordii.code.Main;
import net.kordii.code.api.actionapi;
import net.kordii.code.api.titleapi;
import net.kordii.code.utils.fixColor;
import net.kordii.code.config.ConfigMenager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CmdBroadcast
        implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
    {
        if (sender.hasPermission("lc-bc"))
        {
            if (args.length != 0)
            {
                if (args[0].equalsIgnoreCase("title"))
                {
                    String s;
                    int i;
                    if (args.length > 1)
                    {
                        s = "";
                        for (i = 1; i != args.length; i++) {
                            s = s + args[i] + " ";
                        }
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            titleapi.sendTitle(p, fixColor.fix(ConfigMenager.getConfig().getString("brodcast_title")), fixColor.fix(s), 5, 60, 5);
                        }
                    }
                    else
                    {
                        sender.sendMessage("§8» §cPoprawne uzycie §c/bc <title/action/chat> <wiadomosc>");
                    }
                }
                if (args[0].equalsIgnoreCase("action"))
                {
                    String s;
                    int i;
                    if (args.length > 1)
                    {
                        s = "";
                        for (i = 1; i != args.length; i++) {
                            s = s + args[i] + " ";
                        }
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            actionapi.sendActionbar(p, fixColor.fix(s));
                        }
                    }
                    else
                    {
                        sender.sendMessage("§8» §cPoprawne uzycie §c/bc <title/action/chat> <wiadomosc>");
                    }
                }
                if (args[0].equalsIgnoreCase("chat"))
                {
                    String s = "";
                    if (args.length > 1)
                    {
                        for (int i = 1; i != args.length; i++) {
                            s = s + args[i] + " ";
                        }
                        Bukkit.broadcastMessage(fixColor.fix(ConfigMenager.getConfig().getString("brodcast_chat")).replace("{message}", s));
                    }
                    else
                    {
                        sender.sendMessage("§8» §cPoprawne uzycie §c/bc <title/action/chat> <wiadomosc>");
                    }
                }
            }
            else
            {
                sender.sendMessage("§8» §cPoprawne uzycie §c/bc <title/action/chat> <wiadomosc>");
            }
        }
        else {
            sender.sendMessage("§cBrak Uprawnien! lc-bc");
        }
        return false;
    }
}
