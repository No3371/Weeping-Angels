package me.swirtzly.minecraft.angels.data;

import me.swirtzly.minecraft.angels.common.WAObjects;
import me.swirtzly.minecraft.angels.utils.AngelUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.Tag;
import net.minecraftforge.registries.ForgeRegistries;

public class WABlockTags extends BlockTagsProvider {

    public WABlockTags(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void registerTags() {
        add(BlockTags.STONE_BRICKS, WAObjects.Blocks.ARM.get(), WAObjects.Blocks.STATUE.get(),WAObjects.Blocks.PLINTH.get());
        add(AngelUtils.BANNED_BLOCKS, Blocks.MAGMA_BLOCK, Blocks.GLOWSTONE, Blocks.SEA_LANTERN);

        for (Block block : ForgeRegistries.BLOCKS.getValues()) {
            if(block.getDefaultState().getMaterial() == Material.AIR){
                add(AngelUtils.BANNED_BLOCKS, block);
            }
        }
    }

    public void add(ITag.INamedTag<Block> branch, Block block) {
        this.getOrCreateBuilder(branch).add(block);
    }

    public void add(ITag.INamedTag<Block> branch, Block... block) {
        this.getOrCreateBuilder(branch).add(block);
    }
}