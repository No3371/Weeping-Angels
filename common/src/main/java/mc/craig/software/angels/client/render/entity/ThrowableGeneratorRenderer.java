package mc.craig.software.angels.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import mc.craig.software.angels.common.entity.projectile.ThrowableGenerator;
import mc.craig.software.angels.common.items.WAItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemStack;

public class ThrowableGeneratorRenderer extends ThrownItemRenderer<ThrowableGenerator> {

    public ThrowableGeneratorRenderer(EntityRendererProvider.Context context, float f, boolean bl) {
        super(context, f, bl);
    }

    public ThrowableGeneratorRenderer(EntityRendererProvider.Context context) {
        super(context);
    }


    @Override
    public void render(ThrowableGenerator entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (entity.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(entity) < 12.25)) {
            poseStack.pushPose();
            poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
            Minecraft.getInstance().getItemRenderer().renderStatic(new ItemStack(WAItems.CHRONODYNE_GENERATOR.get()), ItemTransforms.TransformType.GROUND, packedLight, OverlayTexture.NO_OVERLAY, poseStack, buffer, entity.getId());
            poseStack.popPose();
            super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
        }
    }
}
