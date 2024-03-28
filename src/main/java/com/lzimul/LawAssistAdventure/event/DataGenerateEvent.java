package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.generator.*;
import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerateEvent {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        String[] locales = {
                "en_us",
                "zh_cn",
                "zh_tw",
                "ja_jp",
        };
        for (String locale : locales) {
            event.getGenerator().addProvider(
                    event.includeClient(),
                    (DataProvider.Factory<LanguageGenerator>) output -> new LanguageGenerator(output, MODID, locale)
            );
        }
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ItemModelGenerator>) output -> new ItemModelGenerator(output, MODID, existingFileHelper)
        );
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<BlockModelGenerator>) output -> new BlockModelGenerator(output, MODID, existingFileHelper)
        );
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<BlockStateGenerator>) output -> new BlockStateGenerator(output, MODID, existingFileHelper)
        );
    }
}
