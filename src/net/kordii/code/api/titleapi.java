package net.kordii.code.api;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class titleapi {

    public static void sendTitle(Player player, String messageA, String messageB, int a, int b, int c){
        IChatBaseComponent Title = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + messageA + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");
        IChatBaseComponent subTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + messageB + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");


        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, Title);
        PacketPlayOutTitle length = new PacketPlayOutTitle(a, b, c);
        PacketPlayOutTitle subtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subTitle);


        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(length);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(subtitle);
    }
}
