package net.kordii.code.utils;

import org.bukkit.ChatColor;

public class fixColor {

    public static String fix(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
