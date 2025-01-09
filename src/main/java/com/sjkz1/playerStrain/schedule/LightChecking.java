package com.sjkz1.playerStrain.schedule;

import com.sjkz1.playerStrain.PlayerStrain;
import com.sjkz1.playerStrain.player.PlayerStress;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;
import java.util.Random;

public class LightChecking extends PlayerStress implements Runnable {

    private final PlayerStrain plugin;
    private final NamespacedKey attributeKey;

    public LightChecking(PlayerStrain plugin) {
        this.plugin = plugin;
        attributeKey = new NamespacedKey(plugin, "stress");
    }

    @Override
    public void run() {
        Collection<? extends Player> players = this.plugin.getServer().getOnlinePlayers();
        for (Player player : players) {
            Random random = new Random();
            int blockLightLvl = player.getLocation().getBlock().getLightLevel();
            if (blockLightLvl < 7) {
                player.sendActionBar(Component.text("Current Player Stress ").append(Component.text(getStress(player))).style(builder -> {
                    builder.color(TextColor.fromHexString("#41e852"));
                }));
                if (random.nextInt(10) == 0) {
                    if (getStress(player) < 10) {
                        setStress(player, getStress(player) + 1);
                    }
                }
            } else {
                removeStress(player);
            }
        }
    }

    @Override
    public void setStress(Player player, int value) {
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        dataContainer.set(attributeKey, PersistentDataType.INTEGER, value);
    }

    @Override
    public int getStress(Player player) {
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        return dataContainer.getOrDefault(attributeKey, PersistentDataType.INTEGER, 0);
    }

    @Override
    public void removeStress(Player player) {
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();
        dataContainer.remove(attributeKey);
    }
}