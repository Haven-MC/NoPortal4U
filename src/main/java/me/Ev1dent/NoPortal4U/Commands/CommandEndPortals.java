package me.Ev1dent.NoPortal4U.Commands;

import me.Ev1dent.NoPortal4U.NPMain;
import me.Ev1dent.NoPortal4U.Utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class CommandEndPortals implements CommandExecutor {

    Utils Utils = new Utils();
    FileConfiguration Config = NPMain.plugin.getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("havenportals.portals")){
            sender.sendMessage(Utils.Color("&4You are not permitted to use that command"));
            Utils.LogWarn(sender + " Tried to run /portals");
            return true;
        }
        if(args.length == 0){
            sender.sendMessage(Utils.Color("&cPlease specify an argument"));
            return true;
        }

        if(args[0].equalsIgnoreCase("enable")){
            Config.set("Enabled", "true");
            NPMain.plugin.saveConfig();
            sender.sendMessage(Utils.Color("&2End portals have been Enabled"));
            return true;
        }

        if(args[0].equalsIgnoreCase("disable")){
            Config.set("Enabled", "false");
            NPMain.plugin.saveConfig();
            sender.sendMessage(Utils.Color("&2End portals have been &4Disabled"));
            return true;
        }
        sender.sendMessage(Utils.Color("&cI have no idea what you mean by " + args[0]));
        return false;
    }
}
