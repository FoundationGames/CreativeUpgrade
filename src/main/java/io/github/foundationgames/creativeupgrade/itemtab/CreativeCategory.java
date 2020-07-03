package io.github.foundationgames.creativeupgrade.itemtab;

import io.github.foundationgames.creativeupgrade.api.AbstractCategory;
import io.github.foundationgames.creativeupgrade.api.CreativeTab;
import io.github.foundationgames.creativeupgrade.util.Utilz;
import net.minecraft.client.util.math.MatrixStack;

public class CreativeCategory extends AbstractCategory {

    private int activeTab = 0;

    @Override
    public CreativeTab[] getTabs() {
        return new CreativeTab[] {
                CreativeTab.CONSTRUCTION,
                CreativeTab.DECORATIONS,
                CreativeTab.EQUIPMENT,
                CreativeTab.ITEMS,
                CreativeTab.FOODSTUFFS,
                CreativeTab.REDSTONE_TRANSPORT,
                CreativeTab.MAGIC,
                CreativeTab.SEARCH_ALL,
        };
    }

    @Override
    public int getActiveTab() {
        return activeTab;
    }

    @Override
    public void setActiveTab(int tab) {
        activeTab = tab;
    }

    @Override
    public CreativeTab getActiveTabInst() {
        return getTabs()[activeTab];
    }

    @Override
    public Icon getIcon() {
        return new Icon(Utilz.getIconTex(), 2, 52);
    }

    @Override
    public void render(MatrixStack matrices, float delta, int mouseX, int mouseY, int centerX, int centerY) {

    }
}
