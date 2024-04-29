package com.lzimul.LawAssistAdventure.event;

import com.lzimul.LawAssistAdventure.network.NetworkData;
import com.lzimul.LawAssistAdventure.register.KeyRegister;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import static com.lzimul.LawAssistAdventure.Config.MODID;

@EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class KeyEvent {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key inputEvent) {
        if (KeyRegister.MouseLeft.consumeClick() && inputEvent.getKey() == KeyRegister.MouseLeft.getKey().getValue()) {
            PacketDistributor.sendToServer(new NetworkData("server:mouse/Left", 1000));
        }
        if (KeyRegister.MouseRight.consumeClick() && inputEvent.getKey() == KeyRegister.MouseRight.getKey().getValue()) {
            PacketDistributor.sendToServer(new NetworkData("server:mouse/Right", 1001));
        }
        if (KeyRegister.KeyboardR.consumeClick() && inputEvent.getKey() == KeyRegister.KeyboardR.getKey().getValue()) {
            PacketDistributor.sendToServer(new NetworkData("server:keyBoard/R", 1002));
        }
        if (KeyRegister.KeyboardC.consumeClick() && inputEvent.getKey() == KeyRegister.KeyboardC.getKey().getValue()) {
            PacketDistributor.sendToServer(new NetworkData("server:keyBoard/C", 1003));
        }
    }
}
