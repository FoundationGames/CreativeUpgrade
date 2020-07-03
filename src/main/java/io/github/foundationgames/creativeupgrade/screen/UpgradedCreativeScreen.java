package io.github.foundationgames.creativeupgrade.screen;

import com.google.common.collect.Lists;
import io.github.foundationgames.creativeupgrade.api.AbstractCategory;
import io.github.foundationgames.creativeupgrade.api.TabIcon;
import io.github.foundationgames.creativeupgrade.itemtab.CreativeItemGroupTab;
import io.github.foundationgames.creativeupgrade.util.Utilz;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

import java.util.List;
import java.util.function.Consumer;

public class UpgradedCreativeScreen extends HandledScreen<UpgradedCreativeScreenHandler> {

    public static int selectedTab = 7;

    private int cx = 0;
    private int cy = 0;

    public List<MouseBoxWidget> mouseBoxes = Lists.newArrayList();
    public List<ScrollBarWidget> scrollBars = Lists.newArrayList();

    public UpgradedCreativeScreen(UpgradedCreativeScreenHandler screenHandler, PlayerInventory playerInventory, Text text) {
        super(screenHandler, playerInventory, text);
    }

    @Override
    protected void init() {
        super.init();
        initWidgets();
    }

    public void initWidgets() {
        refreshWidgets();
    }

    public void refreshWidgets() {
        int cx = (this.width / 2);
        int cy = (this.height / 2);
        this.mouseBoxes = Lists.newArrayList();
        this.scrollBars = Lists.newArrayList();
        for (int i = 0; i < getScreenHandler().categories[getScreenHandler().activeCategory].getTabs().length; i++) {
            int finalI = i; this.mouseBoxes.add(new MouseBoxWidget(cx - 120 + i * 30, cy - 83, 30, 27, getScreenHandler().getActiveCategory().getTabs()[finalI].name, box -> {
                getScreenHandler().getActiveCategory().setActiveTab(finalI);
                PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
                buf.writeShort(Utilz.joinBytes((byte)getScreenHandler().getSyncId(), (byte)finalI));
                ClientSidePacketRegistry.INSTANCE.sendToServer(Utilz.id("pkt_change_tab"), buf);
            }));
        }
        getScreenHandler().getActiveCategory().getActiveTabInst().onAddWidgets(this);
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public void resize(MinecraftClient client, int width, int height) {
        super.resize(client, width, height);
        refreshWidgets();
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for(MouseBoxWidget box : this.mouseBoxes) {
            box.mouseClick((int)mouseX, (int)mouseY);
        }
        getScreenHandler().refresh(client.player.inventory);
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    protected void onMouseClick(Slot slot, int invSlot, int clickData, SlotActionType actionType) {
        super.onMouseClick(slot, invSlot, clickData, actionType);
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        //super.drawForeground(matrices, mouseX, mouseY);
        this.drawMouseoverTooltip(matrices, mouseX-x, mouseY-y);
        for(MouseBoxWidget box : mouseBoxes) {
            box.tryRenderTooltip(matrices, mouseX, mouseY, this);
        }
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        this.renderBackground(matrices);
        this.client.getTextureManager().bindTexture(Utilz.getGuiTex());
        cx = (this.width / 2);
        cy = (this.height / 2);
        this.drawTexture(matrices, cx - 120, cy+59, 0, 117, 240, 29);
        this.drawTexture(matrices, cx - 120, cy-56, 0, 0, 240, 117);
        AbstractCategory category = getScreenHandler().getActiveCategory();
        for(int i = 0; i < category.getTabs().length; i++) {
            int u = 64;
            int v = 146;
            if(i == 0) { u = 34; }
            if(i == 7) { u = 94; }
            if(category.getActiveTab() == i) { u += 90; }
            this.drawTexture(matrices, cx - 120 + i * 30, cy - 83, u, v, 30, 31);
        }
        //for(int k = 0; k < getScreenHandler().categories.length; k++) {
        //    int u = 0;
        //    if(getScreenHandler().activeCategory == k) u = 17;
        //    this.drawTexture(matrices, cx + 52 + k * 16, cy + 58, u, 144, 17, 24);
        //}
        for(int j = 0; j < category.getTabs().length; j++) {
            TabIcon icon = category.getTabs()[j].icon;
            if(icon.getTexture().isPresent()) {
                this.client.getTextureManager().bindTexture(icon.getTexture().get());
                this.drawTexture(matrices, cx - 116 + j * 30, cy - 80, icon.getTextureU(), icon.getTextureV(), 22, 22);
            } else {
                this.itemRenderer.renderGuiItemIcon(icon.getDisplayItemStack(), cx - 113 + j * 30, cy - 76);
            }
        }
        //for(int k = 0; k < getScreenHandler().categories.length; k++) {
        //    AbstractCategory.Icon icon = category.getIcon();
        //    this.client.getTextureManager().bindTexture(icon.texture);
        //    this.drawTexture(matrices, cx + 55 + k * 16, cy + 67, icon.u, icon.v, 11, 12);
        //}
        category.getActiveTabInst().render(matrices, delta, mouseX, mouseY, this);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        boolean boo = getScreenHandler().getActiveCategory().getActiveTabInst().onScroll(mouseX, mouseY, amount, this);
        this.refreshWidgets();
        getScreenHandler().refresh(client.player.inventory);
        getScreenHandler().sendContentUpdates();
        return boo;
    }

    public TextRenderer getTextRenderer() {
        return this.textRenderer;
    }

    public MinecraftClient getClient() {
        return client;
    }

    public static class MouseBoxWidget {
        public int x, y, width, height;
        public Text tooltip;
        public Consumer<MouseBoxWidget> onPress;

        public MouseBoxWidget(int x, int y, int width, int height, Text tooltip, Consumer<MouseBoxWidget> onPress) {
            this.x = x; this.y = y; this.width = width; this.tooltip = tooltip; this.height = height; this.onPress = onPress;
        }

        public void mouseClick(int mouseX, int mouseY) {
            if(mouseX < x + width && mouseX > x && mouseY < y + height && mouseY > y) {
                this.onPress.accept(this);
            }
        }

        public void tryRenderTooltip(MatrixStack matrices, int mouseX, int mouseY, UpgradedCreativeScreen screen) {
            if(mouseX < x + width && mouseX > x && mouseY < y + height && mouseY > y) {
                screen.renderTooltip(matrices, tooltip, mouseX-screen.x, mouseY-screen.y);
            }
        }
    }

    public static class ItemGroupMouseBoxWidget extends MouseBoxWidget {
        public ItemGroupMouseBoxWidget(int x, int y, int width, int height, Text tooltip, Consumer<MouseBoxWidget> onPress) {
            super(x, y, width, height, tooltip, onPress);
        }
        @Override
        public void mouseClick(int mouseX, int mouseY) {
            super.mouseClick(mouseX, mouseY);
        }
    }

    public static class ScrollBarWidget {
        public int x, y, barWidth, barHeight, scrollDist;
        public float barProgress = 0.0f;
        private boolean latched = false;

        public ScrollBarWidget(int x, int y, int barWidth, int barHeight, int scrollDist) {
            this.x = x; this.y = y; this.barWidth = barWidth; this.barHeight = barHeight; this.scrollDist = scrollDist;
        }

        public void mouseDown(int mouseX, int mouseY) {
            if((mouseX > x && mouseX < x + barWidth && mouseY > y && mouseY < y + barHeight) || latched) {
                if(mouseY > y + (barHeight / 2) && mouseY < y + scrollDist - (barHeight / 2)) {
                    this.y = mouseY;
                }
            }
        }

        public void mouseUp() {
            latched = false;
        }
    }
}
