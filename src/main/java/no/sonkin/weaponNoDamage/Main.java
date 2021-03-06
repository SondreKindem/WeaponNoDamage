package no.sonkin.weaponNoDamage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;

public class Main extends JavaPlugin implements Listener {
    private HashSet<Material> items = new HashSet<>();

    @Override
    public void onEnable(){
        items.add(Material.STONE_SWORD);
        items.add(Material.IRON_SWORD);
        items.add(Material.GOLDEN_SWORD);
        items.add(Material.DIAMOND_SWORD);
        items.add(Material.WOODEN_SWORD);

        items.add(Material.STONE_AXE);
        items.add(Material.IRON_AXE);
        items.add(Material.GOLDEN_AXE);
        items.add(Material.DIAMOND_AXE);
        items.add(Material.WOODEN_AXE);

        items.add(Material.STONE_SHOVEL);
        items.add(Material.IRON_SHOVEL);
        items.add(Material.GOLDEN_SHOVEL);
        items.add(Material.DIAMOND_SHOVEL);
        items.add(Material.WOODEN_SHOVEL);

        items.add(Material.STONE_PICKAXE);
        items.add(Material.IRON_PICKAXE);
        items.add(Material.GOLDEN_PICKAXE);
        items.add(Material.DIAMOND_PICKAXE);
        items.add(Material.WOODEN_PICKAXE);

        items.add(Material.STONE_HOE);
        items.add(Material.IRON_HOE);
        items.add(Material.GOLDEN_HOE);
        items.add(Material.DIAMOND_HOE);
        items.add(Material.WOODEN_HOE);

        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    void onPlayerHitWithTool(EntityDamageByEntityEvent event) {
        if(event.getDamager().getType() == EntityType.PLAYER){
            Player player = (Player) event.getDamager();
            ItemStack primaryItem = player.getInventory().getItemInMainHand();

            Material material = primaryItem.getType();

            if(items.contains(material)){
                event.setDamage(0.5);
            }
        }
    }

    /*
    @EventHandler
    void onPlayerEquipTool(PlayerItemHeldEvent event) {
        if(items.contains(event.getPlayer().getInventory().getItemInMainHand().getType())){
            removeItemMeta(event.getPlayer().getInventory().getItemInMainHand());
        }
    }

    private void removeItemMeta(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        Objects.requireNonNull(meta).addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
    }
    */
}
