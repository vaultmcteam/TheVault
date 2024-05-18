package me.relaxitsdax.thevault.util;

import org.bukkit.Location;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.util.Transformation;

public class BlockDisplayUtil {

    public static void rotateAround(Location point, Location axis, double degrees) {

    point.toVector().rotateAroundAxis(axis)
    }

}
