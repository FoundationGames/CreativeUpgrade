package io.github.foundationgames.creativeupgrade;

import io.github.foundationgames.creativeupgrade.api.AbstractCategory;
import io.github.foundationgames.creativeupgrade.api.CreativeTab;
import io.github.foundationgames.creativeupgrade.screen.ServerScreenHandlerManager;
import io.github.foundationgames.creativeupgrade.screen.UpgradedCreativeScreen;
import io.github.foundationgames.creativeupgrade.screen.UpgradedCreativeScreenHandler;
import io.github.foundationgames.creativeupgrade.util.Utilz;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.loader.FabricLoader;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.TranslatableText;

public class CreativeUpgrade implements ModInitializer {

    public static final ScreenHandlerType<UpgradedCreativeScreenHandler> UPGRADED_CREATIVE_HANDLER = ScreenHandlerRegistry.registerSimple(Utilz.id("upgraded_creative_menu"), UpgradedCreativeScreenHandler::new);

    @Override
    public void onInitialize() {

        ScreenRegistry.register(UPGRADED_CREATIVE_HANDLER, UpgradedCreativeScreen::new);

        CreativeTab.clinit();
        AbstractCategory.clinit();

        ServerSidePacketRegistry.INSTANCE.register(Utilz.id("pkt_open_creative"), (ctx, buf) -> ctx.getTaskQueue().execute(() -> {
            ctx.getPlayer().openHandledScreen(this.createScreenHandlerFactory());
        }));
        ServerSidePacketRegistry.INSTANCE.register(Utilz.id("pkt_change_category"), (ctx, buf) -> ctx.getTaskQueue().execute(() -> {
        }));
        ServerSidePacketRegistry.INSTANCE.register(Utilz.id("pkt_change_tab"), (ctx, buf) -> {
            byte[] data = Utilz.splitBytes(buf.readShort());
            int syncId = data[0];
            int tab = data[1];
            ctx.getTaskQueue().execute(() -> {
                if(ServerScreenHandlerManager.serverHandlers.get(syncId) instanceof UpgradedCreativeScreenHandler) {
                    UpgradedCreativeScreenHandler handler = (UpgradedCreativeScreenHandler)ServerScreenHandlerManager.serverHandlers.get(syncId);
                    handler.getActiveCategory().setActiveTab(tab);
                    handler.refresh(handler.playerInv);
                }
            });
        });

        if(FabricLoader.INSTANCE.getEnvironmentType() == EnvType.SERVER) {
            ServerScreenHandlerManager.clinit();
        }
    }

    private NamedScreenHandlerFactory createScreenHandlerFactory() {
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> UPGRADED_CREATIVE_HANDLER.create(i, playerInventory), new TranslatableText("container.creativeupgrade.creative_menu"));
    }
}
