package me.relaxitsdax.thevault.listeners;

import me.relaxitsdax.thevault.TheVault;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

public class Test implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        Location loc = player.getEyeLocation().add(player.getEyeLocation().getDirection().normalize().multiply(5));

        BlockDisplay e = (BlockDisplay) player.getWorld().spawnEntity(loc, EntityType.BLOCK_DISPLAY);
        e.setBlock(Material.DIAMOND_BLOCK.createBlockData());

        Vector v = e.getLocation().toVector();

        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                v.rotateAroundAxis(player.getLocation().toVector().add(new Vector(0, 1, 0)), 0.1);
                Transformation prev = e.getTransformation();
                e.setTransformation(new Transformation(v.toVector3f(), prev.getLeftRotation(), prev.getScale(), prev.getRightRotation()));

            }
        }.runTaskTimer(TheVault.getInstance(), 0, 1);

        new BukkitRunnable() {
            @Override
            public void run() {
                e.remove();
                task.cancel();
            }
        }.runTaskLater(TheVault.getInstance(), 20);

    }

}
