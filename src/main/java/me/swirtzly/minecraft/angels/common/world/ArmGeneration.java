package me.swirtzly.minecraft.angels.common.world;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import me.swirtzly.minecraft.angels.common.WAObjects;
import me.swirtzly.minecraft.angels.config.WAConfig;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

/**
 * Created by Swirtzly on 11/02/2020 @ 21:58
 */
public class ArmGeneration extends Feature<NoFeatureConfig> {


	public ArmGeneration(Codec<NoFeatureConfig> p_i231953_1_) {
		super(p_i231953_1_);
	}

	private static boolean generateArms(World world, BlockPos position) {
		if (!WAConfig.CONFIG.arms.get()) return false;
		BlockPos pos = new BlockPos(position.add(new BlockPos(8, 0, 8)));
		if ((!world.dimension.isNether() || pos.getY() < 255) && world.getBiome(position).doesSnowGenerate(world, pos)) {
			if (world.getBlockState(pos).getBlock() == Blocks.SNOW || world.getBlockState(pos).getBlock() == Blocks.SNOW_BLOCK) world.setBlockState(pos, WAObjects.Blocks.ARM.get().getDefaultState(), 1);
			return true;
		}
		return false;
	}


	@Override
	public boolean func_241855_a(ISeedReader iSeedReader, ChunkGenerator chunkGenerator, Random random, BlockPos blockPos, NoFeatureConfig noFeatureConfig) {
		return generateArms(world.getWorld(), blockPos);
	}
}
