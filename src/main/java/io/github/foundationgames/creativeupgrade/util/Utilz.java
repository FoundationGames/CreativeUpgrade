package io.github.foundationgames.creativeupgrade.util;

import net.minecraft.util.Identifier;

public class Utilz {
    public static final String MOD_ID = "creativeupgrade";

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    public static Identifier getIconTex() { return id("textures/gui/creative_menu/icons.png"); }

    public static Identifier getWidgetsTex() { return id("textures/gui/creative_menu/light/widgets_creative.png"); }
    public static Identifier getGuiTex() { return id("textures/gui/creative_menu/light/gui.png"); }
    public static short joinBytes(byte a, byte b) { return (short)((short)a << 8 | b); }
    public static byte[] splitBytes(short s) {
        return new byte[] {
            (byte)((s >> 8) & 0xff),
            (byte)(s & 0xff)
        };
    }
}
