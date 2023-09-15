package com.zyneonstudios.nerotvlive.projectsbase.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public class PlayerCommandListener implements Listener {

    private static final ArrayList<String> blockedCommands = new ArrayList<>();
    public static void initBlockedCommands(ArrayList<String> list) {
        blockedCommands.add("/gsit");
        blockedCommands.add("/bellyflop");
        blockedCommands.add("/emote");
        blockedCommands.add("/gbellyflop");
        blockedCommands.add("/gcrawl");
        blockedCommands.add("/gemote");
        blockedCommands.add("/glay");
        blockedCommands.add("/gspin");
        blockedCommands.add("/spin");
        blockedCommands.add("/sr");
        blockedCommands.add("/skin");
        blockedCommands.add("/skins");
        blockedCommands.add("/skinsrestorer");
        blockedCommands.addAll(list);
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        for(String check:blockedCommands) {
            if(e.getMessage().contains(check)) {
                e.setCancelled(true);
            }
        }
    }
}