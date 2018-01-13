package net.kordii.code.config;

import net.kordii.code.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigMenager {

    private Plugin plugin = Main.getPlugin();
    private static File configf;
    private static YamlConfiguration config;

    public void check(){

        configf = new File(plugin.getDataFolder(), "config.yml");


        if (!configf.exists()) {
            configf.getParentFile().mkdirs();
            plugin.saveResource("config.yml", true);
            plugin.getLogger().info("Config.yml not found, creating new one :D");
        }

        try{
            config = YamlConfiguration.loadConfiguration(configf);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static YamlConfiguration getConfig() {
        return config;
    }


    public static void saveConfigs(){
        try {
            config.save(configf);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
