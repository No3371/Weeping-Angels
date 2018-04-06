package com.github.reallysub.angels.common.structures;

import com.github.reallysub.angels.main.WeepingAngels;

import net.minecraft.util.ResourceLocation;

public class CatacombParts {
	
	public static ResourceLocation partStraight = new ResourceLocation(WeepingAngels.MODID, "catacomb/catacomb_hallway_0");
	public static ResourceLocation partCorner1 = new ResourceLocation(WeepingAngels.MODID, "catacomb/catacomb_hallway_1");
	public static ResourceLocation partTSection = new ResourceLocation(WeepingAngels.MODID, "catacomb/catacomb_hallway_2");
	public static ResourceLocation partCrossSection = new ResourceLocation(WeepingAngels.MODID, "catacomb/catacomb_hallway_3");
	
	public static ResourceLocation[] allParts = new ResourceLocation[] { partCorner1, partStraight, partTSection, partCrossSection };
	
}