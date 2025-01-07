package com.sjkz1.playerStrain.schedule;

import com.sjkz1.playerStrain.PlayerStrain;
import com.sjkz1.playerStrain.player.PlayerStress;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Random;

public class LightChecking implements Runnable {

    private final PlayerStrain plugin;

    public LightChecking(PlayerStrain plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        Collection<? extends Player> players = this.plugin.getServer().getOnlinePlayers();
        for (Player player : players) {
            PlayerStress playerStress = new PlayerStress(player);//TODO Fix stress logic
            Random random = new Random();
            int blockLightLvl = player.getLocation().getBlock().getLightLevel();
            player.sendActionBar(Component.text("Current Light Level ").append(Component.text(blockLightLvl)).style(builder -> {
                builder.color(TextColor.fromHexString("#41e852"));
            }));
            if (blockLightLvl < 7) {
                if (random.nextInt(10) == 0) {
                    playerStress.setStress(playerStress.getStress() + 1);
                    player.sendActionBar(Component.text("Current Player Stress ").append(Component.text(playerStress.getStress())).style(builder -> {
                        builder.color(TextColor.fromHexString("#41e852"));
                    }));

                }
            }
        }
    }
}