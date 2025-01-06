package com.sjkz1.playerStrain.player;

import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerStress {

    private final Player player;
    private int stress;

    public PlayerStress(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public UUID getPlayerUuid() {
        return this.player.getUniqueId();
    }

    public void setStress(int stress) {
        this.stress = stress;
    }

    public int getStress() {
        return stress;
    }

    public String getId() {
        return "stress";
    }

    @Override
    public String toString() {
        return this.player.name().toString() + " has stress value: " + this.stress;
    }
}
