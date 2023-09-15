package com.zyneonstudios.nerotvlive.projectsbase.listeners;

import com.zyneonstudios.nerotvlive.projectsbase.api.WarpAPI;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getClickedBlock()!=null) {
            if(e.getClickedBlock().getType().equals(Material.OAK_WALL_SIGN)) {
                Sign sign = (Sign)e.getClickedBlock().getState();
                String lineOne = sign.getLine(0);
                String lineTwo = sign.getLine(1);
                String lineThree = sign.getLine(2);
                String lineFour = sign.getLine(3);
                if(lineOne.contains("§")) {
                    if(lineFour.contains("§")) {
                        if(lineTwo.contains("Zug nach")) {
                            if(lineThree.toLowerCase().contains("falkenwacht")) {
                                p.teleport(WarpAPI.getWarp("falkenwacht"));
                            } else if(lineThree.toLowerCase().contains("silberfels")) {
                                p.teleport(WarpAPI.getWarp("silberfels"));
                            } else if(lineThree.toLowerCase().contains("tiefenstein")) {
                                p.teleport(WarpAPI.getWarp("tiefenstein"));
                            }
                        }
                    }
                }
            }
        }
    }
}