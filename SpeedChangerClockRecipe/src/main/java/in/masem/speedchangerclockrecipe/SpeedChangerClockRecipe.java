package in.masem.speedchangerclockrecipe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import in.masem.speedchangerclockrecipe.listeners.walkSpeedChangerListener;
import in.masem.speedchangerclockrecipe.commands.speedChangerClock;

import java.util.ArrayList;

public final class SpeedChangerClockRecipe extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Welcome to Speed Changer Clock");

        ItemStack speedChangerClockItem = new ItemStack(Material.CLOCK);
        ItemMeta speedChangerClockItemMeta = speedChangerClockItem.getItemMeta();

        speedChangerClockItemMeta.setDisplayName(ChatColor.GRAY + "Speed Changer Clock");
        speedChangerClockItemMeta.addEnchant(Enchantment.DURABILITY, 1, false);

        ArrayList<String> walkSpeedChangerLore = new ArrayList<>();

        walkSpeedChangerLore.add(0, " Custom Speed Changer ");
        walkSpeedChangerLore.add(1, "--------------------");
        walkSpeedChangerLore.add(2, " Speed 1 - 125% ");
        walkSpeedChangerLore.add(3, " Speed 2 - 150% ");
        walkSpeedChangerLore.add(4, " Speed 3 - 175% ");
        walkSpeedChangerLore.add(5, " Speed 1 - 200% ");
        walkSpeedChangerLore.add(6, "--------------------");

        speedChangerClockItemMeta.setLore(walkSpeedChangerLore);
        speedChangerClockItem.setItemMeta(speedChangerClockItemMeta);

        NamespacedKey speedClockKey = new NamespacedKey((Plugin) this,"speed_Clock");
        ShapedRecipe speedClock = new ShapedRecipe(speedClockKey, speedChangerClockItem);

        speedClock.shape("ABA","CDE","AFA");
        speedClock.setIngredient('A', Material.AIR);
        speedClock.setIngredient('B', Material.ENCHANTED_GOLDEN_APPLE);
        speedClock.setIngredient('C', Material.RECOVERY_COMPASS);
        speedClock.setIngredient('D', Material.CLOCK);
        speedClock.setIngredient('E', Material.COMPASS);
        speedClock.setIngredient('F', Material.ELYTRA);

        Bukkit.addRecipe(speedClock);


        getServer().getPluginManager().registerEvents(new walkSpeedChangerListener(), this);    // Listener
        getCommand("sp").setExecutor(new speedChangerClock());                                  // Command



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("GoodBye");
    }
}
