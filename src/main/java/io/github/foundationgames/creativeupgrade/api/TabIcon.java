package io.github.foundationgames.creativeupgrade.api;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.Optional;

public class TabIcon {
    private Optional<Identifier> texture;
    private int textureU;
    private int textureV;

    private ItemStack displayItem;

    private TabIcon() {
    }

    public Optional<Identifier> getTexture() {
        return texture;
    }

    public int getTextureU() {
        return textureU;
    }

    public int getTextureV() {
        return textureV;
    }

    public ItemStack getDisplayItemStack() {
        return displayItem.copy();
    }

    private void setDisplayItem(ItemStack stack) {
        this.displayItem = stack;
        this.texture = Optional.empty();
        this.textureU = 0;
        this.textureV = 0;
    }

    private void setTexture(Identifier texture, int u, int v) {
        this.texture = Optional.of(texture);
        this.textureU = u; this.textureV = v;
        this.displayItem = new ItemStack(Items.BARRIER);
    }

    public static class Builder {

        private final TabIcon underlying = new TabIcon();

        public Builder() {
        }

        public TabIcon itemStack(ItemStack stack) {
            underlying.setDisplayItem(stack);
            return underlying;
        }

        public TabIcon texture(Identifier texture, int u, int v) {
            underlying.setTexture(texture, u, v);
            return underlying;
        }
    }
}
