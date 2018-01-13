package net.kordii.code.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CmdGamemode
        implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender.hasPermission("lc-gm"))
        {
            if ((sender instanceof Player))
            {
                Player p = (Player)sender;
                if (args.length != 0)
                {
                    if (args.length == 1)
                    {
                        if (args[0].equalsIgnoreCase("1"))
                        {
                            p.setGameMode(GameMode.CREATIVE);
                            p.setFlying(true);
                            p.sendMessage("§8» §7Tryb §c§lCreative §7zostal wlaczony!");
                        }
                        if (args[0].equalsIgnoreCase("0"))
                        {
                            p.setGameMode(GameMode.SURVIVAL);
                            p.setFlying(false);
                            p.sendMessage("§8» §7Tryb §c§lSurvival §7zostal wlaczony!");
                        }
                        if (args[0].equalsIgnoreCase("2"))
                        {
                            p.setGameMode(GameMode.ADVENTURE);
                            p.setFlying(false);
                            p.sendMessage("§8» §7Tryb §c§lAdventure §7zostal wlaczony!");
                        }
                        if (args[0].equalsIgnoreCase("3"))
                        {
                            p.setGameMode(GameMode.SPECTATOR);
                            p.setFlying(true);
                            p.sendMessage("§8» §7Tryb §c§lSpectator §7zostal wlaczony!");
                        }
                    }
                    if (args.length == 2)
                    {
                        String nick = args[1].toString();
                        if (Bukkit.getPlayer(nick) != null)
                        {
                            Player player = Bukkit.getPlayer(nick);
                            if (args[0].equalsIgnoreCase("1"))
                            {
                                player.setGameMode(GameMode.CREATIVE);
                                player.setFlying(true);
                                player.sendMessage("§8» §7Tryb §c§lCreative §7zostal wlaczony!");
                            }
                            if (args[0].equalsIgnoreCase("0"))
                            {
                                player.setGameMode(GameMode.SURVIVAL);
                                player.setFlying(false);
                                player.sendMessage("§8» §7Tryb §c§lSurvival §7zostal wlaczony!");
                            }
                            if (args[0].equalsIgnoreCase("2"))
                            {
                                player.setGameMode(GameMode.ADVENTURE);
                                player.setFlying(false);
                                player.sendMessage("§8» §7Tryb §c§lAdventure §7zostal wlaczony!");
                            }
                            if (args[0].equalsIgnoreCase("3"))
                            {
                                player.setGameMode(GameMode.SPECTATOR);
                                player.setFlying(true);
                                player.sendMessage("§8» §7Tryb §c§lSpectator §7zostal wlaczony!");
                            }
                        }
                        else
                        {
                            p.sendMessage("§8» §4Nie ma takiego gracza na serwerze!");
                        }
                    }
                }
                else
                {
                    sender.sendMessage("§8» §cPoprawne uzycie §c/gamemode <0/1/2/3> <Nick>");
                }
            }
            else
            {
                sender.sendMessage("§4Musisz byc graczem aby uzyc tej komendy");
            }
        }
        else {
            sender.sendMessage("§cBrak Uprawnien! lc-gm");
        }
        return false;
    }
}
