package com.zyneonstudios.nerotvlive.projectsbase.locks.commands;

import com.zyneonstudios.nerotvlive.projectsbase.Main;
import com.zyneonstudios.nerotvlive.projectsbase.objects.User;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class LockModeCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player p) {
            User u = Main.getUser(p);
            if(args.length>0) {
                if (args[0].equalsIgnoreCase("public")) {
                    if(u.getInteractMode().equalsIgnoreCase("lockmode-public")) {
                        u.setInteractMode("nullmode");
                        u.sendMessage("Du bist nun nicht mehr im §eLockmode§8. (Öffentlich)");
                        return false;
                    }
                    u.setInteractMode("lockmode-public");
                    u.sendMessage("Du bist nun im §eLockmode§8. (Öffentlich)");
                    return false;
                } else if (args[0].equalsIgnoreCase("unlock")) {
                    if(u.getInteractMode().equalsIgnoreCase("unlockmode")) {
                        u.setInteractMode("nullmode");
                        u.sendMessage("Du bist nun nicht mehr im §eUnlockmode§8.");
                        return false;
                    }
                    u.setInteractMode("unlockmode");
                    u.sendMessage("Du bist nun im §eUnlockmode§8.");
                    return false;
                }
            }
            if(u.getInteractMode().equalsIgnoreCase("lockmode")) {
                u.setInteractMode("nullmode");
                u.sendMessage("Du bist nun nicht mehr im §eLockmode§8. (Privat)");
                return false;
            }
            u.setInteractMode("lockmode");
            u.sendMessage("Du bist nun im §eLockmode§8. (Privat)");
            return false;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender s, Command cmd, String label, String[] args) {
        ArrayList<String> completer = new ArrayList<>();
        if(args.length==1) {
            completer.add("public");
            completer.add("private");
            completer.add("unlock");
        }
        return completer;
    }
}
