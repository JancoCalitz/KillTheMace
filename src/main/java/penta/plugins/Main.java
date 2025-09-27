package penta.plugins;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    private Location arenaCenter;
    private double arenaRadius = 60.0;

    @Override
    public void onEnable() {
        // Set the arena center coordinates as per your screenshot
        World world = Bukkit.getWorld("world_the_end");
        if (world == null) {
            getLogger().severe("World 'world_the_end' not found! Plugin will not work correctly.");
            return;
        }
        arenaCenter = new Location(world, 0.498, 88, 0.452);

        // Register events
        getServer().getPluginManager().registerEvents(this, this);

        getLogger().info("KillTheMace enabled! Arena center set at " + arenaCenter);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        // Only care if damager is a player
        if (!(event.getDamager() instanceof Player)) return;
        Player damager = (Player) event.getDamager();

        // Check if player is inside the arena region
        if (isInsideArena(damager.getLocation())) {
            double damage = event.getDamage();
            if (damage > 70) {
                event.setDamage(70);
             //   damager.sendMessage("Damage capped to 50 inside the arena!");
            }
        }
    }

    private boolean isInsideArena(Location loc) {
        if (loc.getWorld() == null || arenaCenter == null) return false;
        if (!loc.getWorld().getName().equals(arenaCenter.getWorld().getName())) return false;

        return loc.distance(arenaCenter) <= arenaRadius;
    }
}
