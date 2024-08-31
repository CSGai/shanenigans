package net.firstMod.shenanigens.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class Ligma extends Item {
    public Ligma(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            BlockPos blockPos = getPlayerLookingAt(player, world, 50.0);

            if (blockPos != null) {
                world.explode(player, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 5.0F, Level.ExplosionInteraction.TNT);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }

    private BlockPos getPlayerLookingAt(Player player, Level world, double reachDistance) {
        Vec3 startVec = player.getEyePosition(1.0F);
        Vec3 lookVec = player.getViewVector(1.0F);
        Vec3 endVec = startVec.add(lookVec.scale(reachDistance));

        BlockHitResult rayTraceResult = world.clip(new ClipContext(startVec, endVec, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));

        if (rayTraceResult.getType() == HitResult.Type.BLOCK) {
            return rayTraceResult.getBlockPos();
        }

        return null;
    }
}
