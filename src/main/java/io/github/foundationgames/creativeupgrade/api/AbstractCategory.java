package io.github.foundationgames.creativeupgrade.api;

import io.github.foundationgames.creativeupgrade.itemtab.CreativeCategory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public abstract class AbstractCategory {

    public static final AbstractCategory CREATIVE_CATEGORY;

    public static void clinit() {
    }

    public abstract CreativeTab[] getTabs();

    public abstract int getActiveTab();

    public abstract void setActiveTab(int tab);

    public abstract CreativeTab getActiveTabInst();

    public abstract Icon getIcon();

    public abstract void render(MatrixStack matrices, float delta, int mouseX, int mouseY, int centerX, int centerY);

    public static class Icon {
        public Identifier texture; public int u; public int v;

        public Icon(Identifier texture, int u, int v) {
            this.texture = texture; this.u = u; this.v = v;
        }
    }

    static {
        CREATIVE_CATEGORY = new CreativeCategory();
    }
}
