package in.masem.speedchangerclockrecipe.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class walkSpeedChangerListener implements Listener {

    private Inventory speedChangeClock;

    @EventHandler
    public void playerWalkSpeedChange(PlayerInteractEvent event){

        Player player = event.getPlayer();
        ItemStack playerHoldingItem = player.getInventory().getItemInMainHand();
        Action playerAction = event.getAction();

        if (playerAction == Action.RIGHT_CLICK_AIR && playerHoldingItem.getType().equals(Material.CLOCK)){
            if (playerHoldingItem.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Speed Changer Clock")){

                speedChangeClock = Bukkit.createInventory(player, 9 , ChatColor. BLUE + "Choose your Speed");

                ItemStack speed1 = new ItemStack(Material.BIRCH_LOG);
                ItemMeta speed1Meta = speed1.getItemMeta();
                speed1Meta.setDisplayName(ChatColor.GRAY + "100% Speed");
                ArrayList<String> speed1lore = new ArrayList<>();
                speed1lore.add(0, "Set Speed to 100%");
                speed1Meta.setLore(speed1lore);
                speed1.setItemMeta(speed1Meta);

                ItemStack speed2 = new ItemStack(Material.BIRCH_PLANKS);
                ItemMeta speed2Meta = speed2.getItemMeta();
                speed2Meta.setDisplayName(ChatColor.AQUA + "125% Speed");
                ArrayList<String> speed2lore = new ArrayList<>();
                speed2lore.add(0, "Set Speed to 100%");
                speed2Meta.setLore(speed2lore);
                speed2.setItemMeta(speed2Meta);

                ItemStack speed3 = new ItemStack(Material.STICK);
                ItemMeta speed3Meta = speed3.getItemMeta();
                speed3Meta.setDisplayName(ChatColor.DARK_BLUE + "150% Speed");
                ArrayList<String> speed3lore = new ArrayList<>();
                speed3lore.add(0, "Set Speed to 150%");
                speed3Meta.setLore(speed3lore);
                speed3.setItemMeta(speed3Meta);

                ItemStack speed4 = new ItemStack(Material.BIRCH_LEAVES);
                ItemMeta speed4Meta = speed4.getItemMeta();
                speed4Meta.setDisplayName(ChatColor.DARK_GREEN + "175% Speed");
                ArrayList<String> speed4lore = new ArrayList<>();
                speed4lore.add(0, "Set Speed to 100%");
                speed4Meta.setLore(speed4lore);
                speed4.setItemMeta(speed4Meta);

                ItemStack speed5 = new ItemStack(Material.BIRCH_SAPLING);
                ItemMeta speed5Meta = speed5.getItemMeta();
                speed5Meta.setDisplayName(ChatColor.RED + "200% Speed");
                ArrayList<String> speed5lore = new ArrayList<>();
                speed5lore.add(0, "Set Speed to 200%");
                speed5Meta.setLore(speed5lore);
                speed5.setItemMeta(speed5Meta);

                speedChangeClock.setItem(0, speed1);
                speedChangeClock.setItem(2, speed2);
                speedChangeClock.setItem(4, speed3);
                speedChangeClock.setItem(6, speed4);
                speedChangeClock.setItem(8, speed5);

                player.openInventory(speedChangeClock);
            }
            else
                event.setCancelled(true);
        }

    }

    @EventHandler
    public void speedChangerClickerInventory(InventoryClickEvent event) {

        // Inventory Name = ChatColor.GRAY + "Speed Changer Clock"
        Inventory speedChangerInventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();

        if (speedChangerInventory.equals(speedChangeClock)) {
            if (event.getCurrentItem() != null) {                               //Missing this line = NUll Exception
                if (event.getCurrentItem().getType() == Material.BIRCH_LOG) {
                    player.closeInventory();
                    player.setWalkSpeed(0.2f);
                    player.sendMessage(ChatColor.GRAY + "Your speed is set to 100%");
                } else if (event.getCurrentItem().getType() == Material.BIRCH_PLANKS) {
                    player.closeInventory();
                    player.setWalkSpeed(0.25f);

                    player.sendMessage(ChatColor.AQUA + "Your speed is set to 125%");
                } else if (event.getCurrentItem().getType() == Material.STICK) {
                    player.closeInventory();
                    player.setWalkSpeed(0.3f);

                    player.sendMessage(ChatColor.DARK_BLUE + "Your speed is set to 150%");
                } else if (event.getCurrentItem().getType() == Material.BIRCH_LEAVES) {
                    player.closeInventory();
                    player.setWalkSpeed(0.35f);

                    player.sendMessage(ChatColor.DARK_GREEN + "Your Speed set to 175%");
                } else if (event.getCurrentItem().getType() == Material.BIRCH_SAPLING) {
                    player.closeInventory();
                    player.setWalkSpeed(0.4f);

                    player.sendMessage(ChatColor.RED + "Your Speed is set to 200%");
                }
            } else {
                player.closeInventory();
                player.sendMessage("Choose Something");
            }
        }
    }
}