package io.github.foundationgames.creativeupgrade.screen;

import com.google.common.collect.Maps;
import net.minecraft.screen.ScreenHandler;

import java.util.Map;

public class ServerScreenHandlerManager {

    public static final Map<Integer, ScreenHandler> serverHandlers = Maps.newHashMap();

    public static void clinit() {
    }
}
