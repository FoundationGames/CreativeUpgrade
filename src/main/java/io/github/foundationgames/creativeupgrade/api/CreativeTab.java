package io.github.foundationgames.creativeupgrade.api;

import io.github.foundationgames.creativeupgrade.itemtab.ItemLists;
import io.github.foundationgames.creativeupgrade.screen.UpgradedCreativeScreen;
import io.github.foundationgames.creativeupgrade.screen.UpgradedCreativeScreenHandler;
import io.github.foundationgames.creativeupgrade.itemtab.CreativeItemGroupTab;
import io.github.foundationgames.creativeupgrade.util.Utilz;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import java.util.function.Function;


public class CreativeTab {

    public static final DefaultedList<ItemStack> GROUP_A = DefaultedList.copyOf(ItemStack.EMPTY, new ItemStack(Items.STICK), new ItemStack(Items.STONE), new ItemStack(Items.DIAMOND_PICKAXE), new ItemStack(Items.BONE));

    public static final CreativeTab CONSTRUCTION;
    public static final CreativeTab DECORATIONS;
    public static final CreativeTab ITEMS;
    public static final CreativeTab EQUIPMENT;
    public static final CreativeTab FOODSTUFFS;
    public static final CreativeTab REDSTONE_TRANSPORT;
    public static final CreativeTab MAGIC;
    public static final CreativeTab SEARCH_ALL;

    public static final CreativeTab TOOLBARS;

    public static final CreativeTab SURVIVAL;
    public static final CreativeTab CRAFTING;

    public final TabIcon icon;
    public final Text name;

    public CreativeTab(TabIcon icon, Text name) {
        this.icon = icon;
        this.name = name;
    }

    public static void clinit() {}

    public void handlerInit(UpgradedCreativeScreenHandler handler, PlayerInventory playerInv) {
    }

    public void onAddWidgets(UpgradedCreativeScreen screen) {
    }

    public void render(MatrixStack matrices, float delta, int mouseX, int mouseY, UpgradedCreativeScreen screen) {
    }

    public ItemStack transferSlot(PlayerInventory playerInv, int index, UpgradedCreativeScreenHandler handler) {
        return ItemStack.EMPTY;
    }

    public boolean canInsertIntoSlot(Slot slot) {
        return true;
    }

    public boolean onScroll(double mouseX, double mouseY, double amount, UpgradedCreativeScreen screen) { return false; }

    static {
        CONSTRUCTION = new CreativeItemGroupTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 2, 2), new TranslatableText("creativeTab.minecraft.construction"), ItemLists.CONSTRUCTION);
        DECORATIONS = new CreativeItemGroupTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 27, 2), new TranslatableText("creativeTab.minecraft.decorations"), ItemLists.DECORATIONS);
        ITEMS = new CreativeItemGroupTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 77, 2), new TranslatableText("creativeTab.minecraft.items"), ItemLists.ITEMS);
        EQUIPMENT = new CreativeItemGroupTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 152, 2), new TranslatableText("creativeTab.minecraft.equipment"), ItemLists.EQUIPMENT);
        FOODSTUFFS = new CreativeItemGroupTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 52, 2), new TranslatableText("creativeTab.minecraft.foodstuffs"), GROUP_A);
        REDSTONE_TRANSPORT = new CreativeItemGroupTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 102, 2), new TranslatableText("creativeTab.minecraft.redstone_transport"), GROUP_A);
        MAGIC = new CreativeItemGroupTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 127, 2), new TranslatableText("creativeTab.minecraft.magic"), GROUP_A);
        SEARCH_ALL = new CreativeItemGroupTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 177, 2), new TranslatableText("creativeTab.minecraft.search_all"), GROUP_A);

        TOOLBARS = new CreativeTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 2, 27), new TranslatableText("creativeTab.minecraft.saved_hotbars"));

        SURVIVAL = new CreativeTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 227, 2), new TranslatableText("creativeTab.minecraft.survival"));
        CRAFTING = new CreativeTab(new TabIcon.Builder().texture(Utilz.getIconTex(), 202, 2), new TranslatableText("creativeTab.minecraft.crafting"));
    }
}
