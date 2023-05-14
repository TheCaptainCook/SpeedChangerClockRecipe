package in.masem.speedchangerclockrecipe.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class speedChangerClock implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;
        Inventory playerInventory = player.getInventory();

        if (commandSender instanceof Player) {

            ItemStack walkSpeedChanger = new ItemStack(Material.CLOCK);
            ItemMeta walkSpeedChangerMeta = walkSpeedChanger.getItemMeta();

            walkSpeedChangerMeta.setDisplayName(ChatColor.GRAY + "Speed Changer Clock");
            walkSpeedChangerMeta.addEnchant(Enchantment.DURABILITY, 1, false);

            ArrayList<String> walkSpeedChangerLore = new ArrayList<>();

            walkSpeedChangerLore.add(0, " Custom Speed Changer ");
            walkSpeedChangerLore.add(1, "--------------------");
            walkSpeedChangerLore.add(2, " Speed 1 - 125% ");
            walkSpeedChangerLore.add(3, " Speed 2 - 150% ");
            walkSpeedChangerLore.add(4, " Speed 3 - 175% ");
            walkSpeedChangerLore.add(5, " Speed 1 - 200% ");
            walkSpeedChangerLore.add(6, "--------------------");

            walkSpeedChangerMeta.setLore(walkSpeedChangerLore);
            walkSpeedChanger.setItemMeta(walkSpeedChangerMeta);

            playerInventory.addItem(walkSpeedChanger);

            player.sendMessage("Added " + ChatColor.GRAY + "Speed Changer Clock" + " to your inventory");

        }
        return true;
    }
}