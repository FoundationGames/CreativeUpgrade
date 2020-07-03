package io.github.foundationgames.creativeupgrade.itemtab;

import io.github.foundationgames.creativeupgrade.api.CreativeTab;
import io.github.foundationgames.creativeupgrade.api.TabIcon;
import io.github.foundationgames.creativeupgrade.screen.UpgradedCreativeScreen;
import io.github.foundationgames.creativeupgrade.screen.UpgradedCreativeScreenHandler;
import io.github.foundationgames.creativeupgrade.util.Utilz;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;

public class CreativeItemGroupTab extends CreativeTab {

    public Inventory inv = new SimpleInventory(55);
    DefaultedList<ItemStack> items;
    private int scrolledRows = 0;
    private final int maxScrollableRows;
    private float scrollProgressF = 0.0f;

    public CreativeItemGroupTab(TabIcon icon, Text name, DefaultedList<ItemStack> items) {
        super(icon, name);
        this.items = items;
        this.maxScrollableRows = (int)Math.floor((float)items.size() / 9);
    }

    @Override
    public void handlerInit(UpgradedCreativeScreenHandler handler, PlayerInventory playerInv) {
        for (int k = 0; k < items.size() - (scrolledRows * 11) && k < 55; k++) {
            inv.setStack(k, this.items.get(k + (scrolledRows * 11)).copy());
        }
        int x = 0, y = 0;

        for (int i = 0; i < items.size() - (scrolledRows * 11) && i < 55; i++) {
            if(i % 11 == 0) { x = 0; y += 1; }
            handler.addSlotToHandler(new CreativeSlot(inv, i, -20 + x * 18, 28 + y * 18));
            x += 1;
        }
    }

    @Override
    public void render(MatrixStack matrices, float delta, int mouseX, int mouseY, UpgradedCreativeScreen screen) {
        int cx = screen.width / 2;
        int cy = screen.height / 2;
        screen.getTextRenderer().draw(matrices, name, cx-10 - (float)(name.getString().length() * 5) / 2, cy-49, 0x434343);
        screen.getClient().getTextureManager().bindTexture(Utilz.getWidgetsTex());
        screen.drawTexture(matrices, cx-110, cy-39, 0, 0, 218, 92);
        //screen.drawTexture(matrices, cx-110, cy-52, 36, 92, 100, 12);
        int x = 0, y = 0;
        for (int i = 0; i < items.size() - (scrolledRows * 11) && i < 55; i++) {
            if(i % 11 == 0) { x = 0; y += 1; }
            screen.drawTexture(matrices, cx-109 + x * 18, cy-56 + y * 18, 0, 92, 18, 18);
            x += 1;
        }
        if(items.size() <= 55) screen.drawTexture(matrices, cx+100, cy-39, 8, 110, 8, 13);
    }

    @Override
    public boolean onScroll(double mouseX, double mouseY, double amount, UpgradedCreativeScreen screen) {
        int cx = screen.width / 2;
        int cy = screen.height / 2;
        if(mouseX > cx-110 && mouseX < cx-110+218 && mouseY > cy-39 && mouseY < cy-39+92) {
            return scrollIncrement(amount > 0);
        }
        return super.onScroll(mouseX, mouseY, amount, screen);
    }

    private boolean scrollIncrement(boolean up) {
        if(up && scrolledRows > 0) {
            scrolledRows -= 1;
            return true;
        } else if(!up && items.size() - (scrolledRows * 11) > 55) {
            scrolledRows += 1;
            return true;
        }
        return false;
    }

    public static class CreativeSlot extends Slot {
        public CreativeSlot(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }
    }
}
