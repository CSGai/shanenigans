package net.firstMod.shenanigens.item;

import net.firstMod.shenanigens.shenanigens;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, shenanigens.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEST = CREATIVE_MODE_TAB.register("test",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LIGMA.get()))
                    .title(Component.translatable("creativetab.test"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LIGMA.get());
                        output.accept(ModItems.XBALL.get());
                        output.accept(ModItems.YBALL.get());
                        output.accept(ModItems.ZBALL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
