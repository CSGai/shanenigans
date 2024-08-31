package net.firstMod.shenanigens.item;

import net.firstMod.shenanigens.item.custom.Ligma;
import net.firstMod.shenanigens.shenanigens;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, shenanigens.MOD_ID);

    public static final RegistryObject<Item> LIGMA = ITEMS.register("ligma",
            () -> new Ligma(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> XBALL = ITEMS.register("xball",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YBALL = ITEMS.register("yball",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZBALL = ITEMS.register("zball",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
