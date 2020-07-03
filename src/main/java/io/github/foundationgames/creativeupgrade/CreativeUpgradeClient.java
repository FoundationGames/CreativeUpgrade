package io.github.foundationgames.creativeupgrade;

import io.github.foundationgames.creativeupgrade.api.CreativeTab;
import io.github.foundationgames.creativeupgrade.screen.UpgradedCreativeScreen;
import io.github.foundationgames.creativeupgrade.screen.UpgradedCreativeScreenHandler;
import io.github.foundationgames.creativeupgrade.util.Utilz;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.*;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.registry.Registry;
import org.lwjgl.glfw.GLFW;

import java.util.Objects;

public class CreativeUpgradeClient implements ClientModInitializer {

    public static final KeyBinding openCreativeKeyBind = new KeyBinding("key.creativeupgrade.opencreative", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_I, "category.creativeupgrade.keybinds");
    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(openCreativeKeyBind);

        ClientTickCallback.EVENT.register(client -> {
            while (openCreativeKeyBind.wasPressed()) {
                //client.openScreen(new UpgradedCreativeScreen(UpgradedCreativeScreenHandler(5, client.player), client.player.inventory, new TranslatableText("container.creativeupgrade.creative_menu")));
                //if(client.player != null && client.player.abilities.creativeMode) client.openScreen(new UpgradedCreativeScreen((UpgradedCreativeScreenHandler)createScreenHandlerFactory().createMenu(5, client.player.inventory, client.player), client.player.inventory, new TranslatableText("container.creativeupgrade.creative_menu")));
                if(client.player != null && client.player.abilities.creativeMode) ClientSidePacketRegistry.INSTANCE.sendToServer(Utilz.id("pkt_open_creative"), new PacketByteBuf(Unpooled.buffer()));
            }
        });
    }
    //new UpgradedCreativeScreenHandler(i, playerInventory), new TranslatableText("container.creativeupgrade.creative_menu")

}
