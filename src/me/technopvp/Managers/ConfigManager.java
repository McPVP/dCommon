package me.technopvp.Managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class ConfigManager
{
  static ConfigManager instance = new ConfigManager();
  Plugin p;
  FileConfiguration homes;
  File homefile;

  public static ConfigManager getInstance()
  {
    return instance;
  }

  public void setup(Plugin p)
  {
    this.p = p;

    if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();

    this.homefile = new File(p.getDataFolder(), "data.yml");
    this.homes = YamlConfiguration.loadConfiguration(this.homefile);

    if (!this.homefile.exists())
      try {
        this.homefile.createNewFile();
      }
      catch (IOException e) {
        System.out.println("Could not create home file!");
      }
  }

  public FileConfiguration getConfig()
  {
    return this.homes;
  }

  public void saveConfig() {
    try {
      this.homes.save(this.homefile);
    }
    catch (IOException e) {
      System.out.println("Could not save home file!");
    }
  }

  public PluginDescriptionFile getDescription() {
    return this.p.getDescription();
  }
}