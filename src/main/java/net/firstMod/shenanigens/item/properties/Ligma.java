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
            // Determine the block the player is looking at
            BlockPos blockPos = getPlayerLookingAt(player, world, 20.0);  // Adjust range as needed

            if (blockPos != null) {
                // Create an explosion at the block the player is looking at
                world.explode(player, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }

    // Helper method to determine what block the player is looking at
    private BlockPos getPlayerLookingAt(Player player, Level world, double reachDistance) {
        Vec3 startVec = player.getEyePosition(1.0F);  // Verify this method name with Parchment mappings
        Vec3 lookVec = player.getViewVector(1.0F);    // Verify this method name with Parchment mappings
        Vec3 endVec = startVec.add(lookVec.scale(reachDistance));

        BlockHitResult rayTraceResult = world.clip(new ClipContext(startVec, endVec, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));

        if (rayTraceResult.getType() == HitResult.Type.BLOCK) {
            return rayTraceResult.getBlockPos();
        }

        return null;
    }
}
