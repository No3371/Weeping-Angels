package me.swirtzly.minecraft.angels.client.renders.tileentities;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.matrixStack;

import me.swirtzly.minecraft.angels.WeepingAngels;
import me.swirtzly.minecraft.angels.client.models.entity.ModelAngelEd;
import me.swirtzly.minecraft.angels.common.entities.WeepingAngelEntity;
import me.swirtzly.minecraft.angels.common.tileentities.PlinthTile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.util.ResourceLocation;

public class PlinthTileRender extends TileEntityRenderer<PlinthTile> {
	
	private ModelAngelEd<WeepingAngelEntity> ed = new ModelAngelEd<WeepingAngelEntity>();
	private ResourceLocation ARM_TEX = new ResourceLocation(WeepingAngels.MODID, "textures/entities/angel_2.png");

	@Override
	public void render(PlinthTile plinthTile, float v, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i, int i1) {
		matrixStack.push();

		matrixStack.translate((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		matrixStack.rotatef(180, 0.0F, 0.0F, 1.0F);

		matrixStack.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.translate(0, -1, 0);

		matrixStack.rotatef(tile.getRotation(), 0, 1, 0);

		if (!tile.getHasSpawned()) {
			Minecraft.getInstance().getTextureManager().bindTexture(ARM_TEX);
			ed.quickRender(0.0625f, plinthTile.getPose());
		}

		matrixStack.pop();
	}
}
