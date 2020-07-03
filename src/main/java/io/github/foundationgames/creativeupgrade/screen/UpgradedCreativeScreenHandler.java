package io.github.foundationgames.creativeupgrade.screen;

import io.github.foundationgames.creativeupgrade.CreativeUpgrade;
import io.github.foundationgames.creativeupgrade.api.AbstractCategory;
import io.github.foundationgames.creativeupgrade.itemtab.CreativeCategory;
import io.github.foundationgames.creativeupgrade.itemtab.CreativeItemGroupTab;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.loader.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.server.world.ServerWorld;

import java.util.Objects;

public class UpgradedCreativeScreenHandler extends ScreenHandler {

    public final PlayerInventory playerInv;

    public final AbstractCategory[] categories = {
        AbstractCategory.CREATIVE_CATEGORY
    };

    public int activeCategory = 0;

    public UpgradedCreativeScreenHandler(int syncId, PlayerInventory playerInv) {
        super(CreativeUpgrade.UPGRADED_CREATIVE_HANDLER, syncId);
        this.playerInv = playerInv;
        this.refresh(playerInv);
        if(playerInv.player.world instanceof ServerWorld) {
            ServerScreenHandlerManager.serverHandlers.put(syncId, this);
        }
    }

    public void refresh(PlayerInventory playerInv) {
        this.slots.clear();
        getActiveCategory().getActiveTabInst().handlerInit(this, playerInv);
        for(int i = 0; i < 9; i++) {
            this.addSlotToHandler(new Slot(playerInv, i, -2 + i * 18, 148));
        }
    }

    public Slot addSlotToHandler(Slot slot) {
        return super.addSlot(slot);
    }

    @Override
    public ItemStack onSlotClick(int index, int buttonData, SlotActionType actionType, PlayerEntity playerEntity) {
        PlayerInventory playerInv = playerEntity.inventory;
        if(index > -1) {
            if (slots.get(index) instanceof CreativeItemGroupTab.CreativeSlot) {
                ItemStack sStack = slots.get(index).getStack();
                ItemStack cStack = playerInv.getCursorStack();
                System.out.println(sStack);
                if (actionType == SlotActionType.PICKUP || (actionType == SlotActionType.THROW)/*Hacky code to temporarily address an annoying problem*/) {
                    boolean tagMatch = Objects.equals(sStack.getTag(), cStack.getTag());
                    if(sStack.getItem() == cStack.getItem() && tagMatch && buttonData == 0) {
                        cStack.increment(1);
                    } else if(!cStack.isEmpty()) {
                        if(buttonData == 0) playerInv.setCursorStack(ItemStack.EMPTY);
                        else if(buttonData == 1) cStack.decrement(1);
                    } else playerInv.setCursorStack(sStack.copy());
                } else if (actionType == SlotActionType.SWAP) {
                    playerInv.setStack(buttonData, sStack.copy());
                } else if (actionType == SlotActionType.CLONE || actionType == SlotActionType.QUICK_MOVE) {
                    ItemStack resultStack = sStack.copy();
                    resultStack.setCount(resultStack.getMaxCount());
                    playerInv.setCursorStack(resultStack);
                }
            } else super.onSlotClick(index, buttonData, actionType, playerEntity);
        } else super.onSlotClick(index, buttonData, actionType, playerEntity);

        return ItemStack.EMPTY;
    }

    @Override
    public void close(PlayerEntity player) {
        super.close(player);
        if(this.playerInv.player.world instanceof ServerWorld) {
            ServerScreenHandlerManager.serverHandlers.remove(syncId);
        }
    }

    public int getSyncId() {
        return syncId;
    }

    @Override
    public ScreenHandlerType<?> getType() {
        return CreativeUpgrade.UPGRADED_CREATIVE_HANDLER;
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        if (index >= this.slots.size() - 9 && index < this.slots.size()) {
            Slot slot = this.slots.get(index);
            if (slot != null && slot.hasStack()) {
                slot.setStack(ItemStack.EMPTY);
            }
        }

        return getActiveCategory().getActiveTabInst().transferSlot(player.inventory, index, this);
    }

    public boolean canInsertIntoSlot(Slot slot) {
        return getActiveCategory().getActiveTabInst().canInsertIntoSlot(slot);
    }

    public AbstractCategory getActiveCategory() {
        return categories[activeCategory];
    }



    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
