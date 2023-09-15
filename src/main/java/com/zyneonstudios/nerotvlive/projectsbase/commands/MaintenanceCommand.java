package com.zyneonstudios.nerotvlive.projectsbase.commands;

import com.zyneonstudios.nerotvlive.projectsbase.Main;
import com.zyneonstudios.nerotvlive.projectsbase.utils.Communicator;
import com.zyneonstudios.nerotvlive.projectsbase.utils.Strings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MaintenanceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
        if(s.hasPermission("zyneon.team")) {
            Main.setMaintenance(!Main.maintenance);
            Communicator.sendInfo(s,"Der Wartungsmodus steht nun auf§8: §e"+Main.maintenance);
        } else {
            Communicator.sendError(s, Strings.noPermission);
        }
        return false;
    }
}
