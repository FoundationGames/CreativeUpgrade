package io.github.foundationgames.creativeupgrade.itemtab;

import com.google.common.collect.Lists;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ItemLists {
    public static final DefaultedList<ItemStack> CONSTRUCTION = DefaultedList.copyOf(ItemStack.EMPTY,
            i(Items.GRASS_BLOCK), i(Items.GRASS_PATH), i(Items.PODZOL), i(Items.MYCELIUM), i(Items.DIRT), i(Items.COARSE_DIRT),
            i(Items.OAK_LOG), i(Items.BIRCH_LOG), i(Items.SPRUCE_LOG), i(Items.JUNGLE_LOG), i(Items.ACACIA_LOG), i(Items.DARK_OAK_LOG),
            i(Items.OAK_WOOD), i(Items.BIRCH_WOOD), i(Items.SPRUCE_WOOD), i(Items.JUNGLE_WOOD), i(Items.ACACIA_WOOD), i(Items.DARK_OAK_WOOD),
            i(Items.OAK_PLANKS), i(Items.OAK_STAIRS), i(Items.OAK_SLAB), i(Items.OAK_FENCE),
            i(Items.BIRCH_PLANKS), i(Items.BIRCH_STAIRS), i(Items.BIRCH_SLAB), i(Items.BIRCH_FENCE),
            i(Items.SPRUCE_PLANKS), i(Items.SPRUCE_STAIRS), i(Items.SPRUCE_SLAB), i(Items.SPRUCE_FENCE),
            i(Items.JUNGLE_PLANKS), i(Items.JUNGLE_STAIRS), i(Items.JUNGLE_SLAB), i(Items.JUNGLE_FENCE),
            i(Items.ACACIA_PLANKS), i(Items.ACACIA_STAIRS), i(Items.ACACIA_SLAB), i(Items.ACACIA_FENCE),
            i(Items.DARK_OAK_PLANKS), i(Items.DARK_OAK_STAIRS), i(Items.DARK_OAK_SLAB), i(Items.DARK_OAK_FENCE),
            i(Items.STRIPPED_OAK_LOG), i(Items.STRIPPED_BIRCH_LOG), i(Items.STRIPPED_SPRUCE_LOG), i(Items.STRIPPED_JUNGLE_LOG), i(Items.STRIPPED_ACACIA_LOG), i(Items.STRIPPED_DARK_OAK_LOG),
            i(Items.STRIPPED_OAK_WOOD), i(Items.STRIPPED_BIRCH_WOOD), i(Items.STRIPPED_SPRUCE_WOOD), i(Items.STRIPPED_JUNGLE_WOOD), i(Items.STRIPPED_ACACIA_WOOD), i(Items.STRIPPED_DARK_OAK_WOOD),
            i(Items.OAK_LEAVES), i(Items.BIRCH_LEAVES), i(Items.SPRUCE_LEAVES), i(Items.JUNGLE_LEAVES), i(Items.ACACIA_LEAVES), i(Items.DARK_OAK_LEAVES),
            i(Items.SAND),
            i(Items.SANDSTONE), i(Items.SANDSTONE_STAIRS), i(Items.SANDSTONE_SLAB), i(Items.SANDSTONE_WALL),
            i(Items.CUT_SANDSTONE), i(Items.CUT_SANDSTONE_SLAB),
            i(Items.SMOOTH_SANDSTONE), i(Items.SMOOTH_SANDSTONE_STAIRS), i(Items.SMOOTH_SANDSTONE_SLAB),
            i(Items.CHISELED_SANDSTONE),
            i(Items.RED_SAND),
            i(Items.RED_SANDSTONE), i(Items.RED_SANDSTONE_STAIRS), i(Items.RED_SANDSTONE_SLAB), i(Items.RED_SANDSTONE_WALL),
            i(Items.CUT_RED_SANDSTONE), i(Items.CUT_RED_SANDSTONE_SLAB),
            i(Items.SMOOTH_RED_SANDSTONE), i(Items.SMOOTH_RED_SANDSTONE_STAIRS), i(Items.SMOOTH_RED_SANDSTONE_SLAB),
            i(Items.CHISELED_RED_SANDSTONE),
            i(Items.COAL_ORE), i(Items.IRON_ORE), i(Items.GOLD_ORE), i(Items.REDSTONE_ORE), i(Items.LAPIS_ORE), i(Items.EMERALD_ORE), i(Items.DIAMOND_ORE),
            i(Items.COAL_BLOCK), i(Items.IRON_BLOCK), i(Items.GOLD_BLOCK), i(Items.LAPIS_BLOCK), i(Items.EMERALD_BLOCK), i(Items.DIAMOND_BLOCK),
            i(Items.GRAVEL),
            i(Items.STONE), i(Items.STONE_STAIRS), i(Items.STONE_SLAB),
            i(Items.SMOOTH_STONE), i(Items.SMOOTH_STONE_SLAB),
            i(Items.COBBLESTONE), i(Items.COBBLESTONE_STAIRS), i(Items.COBBLESTONE_SLAB), i(Items.COBBLESTONE_WALL),
            i(Items.MOSSY_COBBLESTONE), i(Items.MOSSY_COBBLESTONE_STAIRS), i(Items.MOSSY_COBBLESTONE_SLAB), i(Items.MOSSY_COBBLESTONE_WALL),
            i(Items.BEDROCK),
            i(Items.STONE_BRICKS), i(Items.STONE_BRICK_STAIRS), i(Items.STONE_BRICK_SLAB), i(Items.STONE_BRICK_WALL),
            i(Items.MOSSY_STONE_BRICKS), i(Items.MOSSY_STONE_BRICK_STAIRS), i(Items.MOSSY_STONE_BRICK_SLAB), i(Items.MOSSY_STONE_BRICK_WALL),
            i(Items.CHISELED_STONE_BRICKS), i(Items.CRACKED_STONE_BRICKS),
            i(Items.ANDESITE), i(Items.ANDESITE_STAIRS), i(Items.ANDESITE_SLAB), i(Items.ANDESITE_WALL),
            i(Items.POLISHED_ANDESITE), i(Items.POLISHED_ANDESITE_STAIRS), i(Items.POLISHED_ANDESITE_SLAB),
            i(Items.DIORITE), i(Items.DIORITE_STAIRS), i(Items.DIORITE_SLAB), i(Items.DIORITE_WALL),
            i(Items.POLISHED_DIORITE), i(Items.POLISHED_DIORITE_STAIRS), i(Items.POLISHED_DIORITE_SLAB),
            i(Items.GRANITE), i(Items.GRANITE_STAIRS), i(Items.GRANITE_SLAB), i(Items.GRANITE_WALL),
            i(Items.POLISHED_GRANITE), i(Items.POLISHED_GRANITE_STAIRS), i(Items.POLISHED_GRANITE_SLAB),
            i(Items.BRICKS), i(Items.BRICK_STAIRS), i(Items.BRICK_SLAB), i(Items.BRICK_WALL),
            i(Items.SPONGE), i(Items.WET_SPONGE), i(Items.DRIED_KELP_BLOCK),
            i(Items.PRISMARINE), i(Items.PRISMARINE_STAIRS), i(Items.PRISMARINE_SLAB), i(Items.PRISMARINE_WALL),
            i(Items.PRISMARINE_BRICKS), i(Items.PRISMARINE_BRICK_STAIRS), i(Items.PRISMARINE_BRICK_SLAB),
            i(Items.DARK_PRISMARINE), i(Items.DARK_PRISMARINE_STAIRS), i(Items.DARK_PRISMARINE_SLAB),
            i(Items.SEA_LANTERN),

            i(Items.CRIMSON_NYLIUM), i(Items.WARPED_NYLIUM), i(Items.NETHERRACK),
            i(Items.CRIMSON_STEM), i(Items.WARPED_STEM), i(Items.CRIMSON_HYPHAE), i(Items.WARPED_HYPHAE),
            i(Items.STRIPPED_CRIMSON_STEM), i(Items.STRIPPED_WARPED_STEM), i(Items.STRIPPED_CRIMSON_HYPHAE), i(Items.STRIPPED_WARPED_HYPHAE),
            i(Items.CRIMSON_PLANKS), i(Items.CRIMSON_STAIRS), i(Items.CRIMSON_SLAB), i(Items.CRIMSON_FENCE),
            i(Items.WARPED_PLANKS), i(Items.WARPED_STAIRS), i(Items.WARPED_SLAB), i(Items.WARPED_FENCE),
            i(Items.NETHER_WART_BLOCK), i(Items.WARPED_WART_BLOCK), i(Items.SHROOMLIGHT),
            i(Items.SOUL_SAND), i(Items.SOUL_SOIL), i(Items.GLOWSTONE),
            i(Items.NETHER_QUARTZ_ORE), i(Items.NETHER_GOLD_ORE), i(Items.ANCIENT_DEBRIS),
            i(Items.NETHERITE_BLOCK),
            i(Items.QUARTZ_BLOCK), i(Items.QUARTZ_STAIRS), i(Items.QUARTZ_SLAB),
            i(Items.SMOOTH_QUARTZ), i(Items.SMOOTH_QUARTZ_STAIRS), i(Items.SMOOTH_QUARTZ_SLAB),
            i(Items.CHISELED_QUARTZ_BLOCK), i(Items.QUARTZ_BRICKS), i(Items.QUARTZ_PILLAR),
            i(Items.NETHER_BRICKS), i(Items.NETHER_BRICK_STAIRS), i(Items.NETHER_BRICK_SLAB), i(Items.NETHER_BRICK_WALL), i(Items.NETHER_BRICK_FENCE),
            i(Items.CHISELED_NETHER_BRICKS), i(Items.CRACKED_NETHER_BRICKS),
            i(Items.RED_NETHER_BRICKS), i(Items.RED_NETHER_BRICK_STAIRS), i(Items.RED_NETHER_BRICK_SLAB), i(Items.RED_NETHER_BRICK_WALL),
            i(Items.MAGMA_BLOCK), i(Items.BASALT), i(Items.POLISHED_BASALT),
            i(Items.OBSIDIAN), i(Items.CRYING_OBSIDIAN),
            i(Items.BLACKSTONE), i(Items.BLACKSTONE_STAIRS), i(Items.BLACKSTONE_SLAB), i(Items.BLACKSTONE_WALL),
            i(Items.GILDED_BLACKSTONE),
            i(Items.POLISHED_BLACKSTONE), i(Items.POLISHED_BLACKSTONE_STAIRS), i(Items.POLISHED_BLACKSTONE_SLAB), i(Items.POLISHED_BLACKSTONE_WALL), i(Items.CHISELED_POLISHED_BLACKSTONE),
            i(Items.POLISHED_BLACKSTONE_BRICKS), i(Items.POLISHED_BLACKSTONE_BRICK_STAIRS), i(Items.POLISHED_BLACKSTONE_BRICK_SLAB), i(Items.POLISHED_BLACKSTONE_BRICK_WALL),
            i(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS),

            i(Items.END_STONE),
            i(Items.END_STONE_BRICKS), i(Items.END_STONE_BRICK_STAIRS), i(Items.END_STONE_BRICK_SLAB), i(Items.END_STONE_BRICK_WALL),
            i(Items.PURPUR_BLOCK), i(Items.PURPUR_STAIRS), i(Items.PURPUR_SLAB), i(Items.PURPUR_PILLAR),

            i(Items.WHITE_WOOL), i(Items.RED_WOOL), i(Items.ORANGE_WOOL), i(Items.YELLOW_WOOL),
            i(Items.LIME_WOOL), i(Items.GREEN_WOOL), i(Items.BLUE_WOOL), i(Items.CYAN_WOOL),
            i(Items.LIGHT_BLUE_WOOL), i(Items.PINK_WOOL), i(Items.MAGENTA_WOOL), i(Items.PURPLE_WOOL),
            i(Items.BROWN_WOOL), i(Items.BLACK_WOOL), i(Items.GRAY_WOOL), i(Items.LIGHT_GRAY_WOOL),
            i(Items.GLASS), i(Items.GLASS_PANE), i(Items.IRON_BARS),
            i(Items.WHITE_STAINED_GLASS), i(Items.RED_STAINED_GLASS), i(Items.ORANGE_STAINED_GLASS), i(Items.YELLOW_STAINED_GLASS),
            i(Items.LIME_STAINED_GLASS), i(Items.GREEN_STAINED_GLASS), i(Items.BLUE_STAINED_GLASS), i(Items.CYAN_STAINED_GLASS),
            i(Items.LIGHT_BLUE_STAINED_GLASS), i(Items.PINK_STAINED_GLASS), i(Items.MAGENTA_STAINED_GLASS), i(Items.PURPLE_STAINED_GLASS),
            i(Items.BROWN_STAINED_GLASS), i(Items.BLACK_STAINED_GLASS), i(Items.GRAY_STAINED_GLASS), i(Items.LIGHT_GRAY_STAINED_GLASS),
            i(Items.WHITE_STAINED_GLASS_PANE), i(Items.RED_STAINED_GLASS_PANE), i(Items.ORANGE_STAINED_GLASS_PANE), i(Items.YELLOW_STAINED_GLASS_PANE),
            i(Items.LIME_STAINED_GLASS_PANE), i(Items.GREEN_STAINED_GLASS_PANE), i(Items.BLUE_STAINED_GLASS_PANE), i(Items.CYAN_STAINED_GLASS_PANE),
            i(Items.LIGHT_BLUE_STAINED_GLASS_PANE), i(Items.PINK_STAINED_GLASS_PANE), i(Items.MAGENTA_STAINED_GLASS_PANE), i(Items.PURPLE_STAINED_GLASS_PANE),
            i(Items.BROWN_STAINED_GLASS_PANE), i(Items.BLACK_STAINED_GLASS_PANE), i(Items.GRAY_STAINED_GLASS_PANE), i(Items.LIGHT_GRAY_STAINED_GLASS_PANE),
            i(Items.WHITE_CONCRETE_POWDER), i(Items.RED_CONCRETE_POWDER), i(Items.ORANGE_CONCRETE_POWDER), i(Items.YELLOW_CONCRETE_POWDER),
            i(Items.LIME_CONCRETE_POWDER), i(Items.GREEN_CONCRETE_POWDER), i(Items.BLUE_CONCRETE_POWDER), i(Items.CYAN_CONCRETE_POWDER),
            i(Items.LIGHT_BLUE_CONCRETE_POWDER), i(Items.PINK_CONCRETE_POWDER), i(Items.MAGENTA_CONCRETE_POWDER), i(Items.PURPLE_CONCRETE_POWDER),
            i(Items.BROWN_CONCRETE_POWDER), i(Items.BLACK_CONCRETE_POWDER), i(Items.GRAY_CONCRETE_POWDER), i(Items.LIGHT_GRAY_CONCRETE_POWDER),
            i(Items.WHITE_CONCRETE), i(Items.RED_CONCRETE), i(Items.ORANGE_CONCRETE), i(Items.YELLOW_CONCRETE),
            i(Items.LIME_CONCRETE), i(Items.GREEN_CONCRETE), i(Items.BLUE_CONCRETE), i(Items.CYAN_CONCRETE),
            i(Items.LIGHT_BLUE_CONCRETE), i(Items.PINK_CONCRETE), i(Items.MAGENTA_CONCRETE), i(Items.PURPLE_CONCRETE),
            i(Items.BROWN_CONCRETE), i(Items.BLACK_CONCRETE), i(Items.GRAY_CONCRETE), i(Items.LIGHT_GRAY_CONCRETE),
            i(Items.WHITE_TERRACOTTA), i(Items.RED_TERRACOTTA), i(Items.ORANGE_TERRACOTTA), i(Items.YELLOW_TERRACOTTA),
            i(Items.LIME_TERRACOTTA), i(Items.GREEN_TERRACOTTA), i(Items.BLUE_TERRACOTTA), i(Items.CYAN_TERRACOTTA),
            i(Items.LIGHT_BLUE_TERRACOTTA), i(Items.PINK_TERRACOTTA), i(Items.MAGENTA_TERRACOTTA), i(Items.PURPLE_TERRACOTTA),
            i(Items.BROWN_TERRACOTTA), i(Items.BLACK_TERRACOTTA), i(Items.GRAY_TERRACOTTA), i(Items.LIGHT_GRAY_TERRACOTTA),
            i(Items.WHITE_GLAZED_TERRACOTTA), i(Items.RED_GLAZED_TERRACOTTA), i(Items.ORANGE_GLAZED_TERRACOTTA), i(Items.YELLOW_GLAZED_TERRACOTTA),
            i(Items.LIME_GLAZED_TERRACOTTA), i(Items.GREEN_GLAZED_TERRACOTTA), i(Items.BLUE_GLAZED_TERRACOTTA), i(Items.CYAN_GLAZED_TERRACOTTA),
            i(Items.LIGHT_BLUE_GLAZED_TERRACOTTA), i(Items.PINK_GLAZED_TERRACOTTA), i(Items.MAGENTA_GLAZED_TERRACOTTA), i(Items.PURPLE_GLAZED_TERRACOTTA),
            i(Items.BROWN_GLAZED_TERRACOTTA), i(Items.BLACK_GLAZED_TERRACOTTA), i(Items.GRAY_GLAZED_TERRACOTTA), i(Items.LIGHT_GRAY_GLAZED_TERRACOTTA)
    );

    public static final DefaultedList<ItemStack> DECORATIONS = DefaultedList.copyOf(ItemStack.EMPTY,
            i(Items.OAK_SAPLING), i(Items.BIRCH_SAPLING), i(Items.SPRUCE_SAPLING), i(Items.JUNGLE_SAPLING), i(Items.ACACIA_SAPLING), i(Items.DARK_OAK_SAPLING),
            i(Items.GRASS), i(Items.TALL_GRASS), i(Items.FERN), i(Items.LARGE_FERN), i(Items.DEAD_BUSH), i(Items.VINE),
            i(Items.DANDELION), i(Items.POPPY),
            i(Items.LILY_OF_THE_VALLEY), i(Items.RED_TULIP), i(Items.ORANGE_TULIP), i(Items.CORNFLOWER), i(Items.BLUE_ORCHID), i(Items.PINK_TULIP), i(Items.ALLIUM), i(Items.WITHER_ROSE), i(Items.OXEYE_DAISY), i(Items.AZURE_BLUET), i(Items.WHITE_TULIP),
            i(Items.ROSE_BUSH), i(Items.SUNFLOWER), i(Items.PEONY), i(Items.LILAC),
            i(Items.BROWN_MUSHROOM), i(Items.RED_MUSHROOM),
            i(Items.LILY_PAD), i(Items.BAMBOO), i(Items.SUGAR_CANE),
            i(Items.CACTUS), i(Items.MELON), i(Items.PUMPKIN), i(Items.CARVED_PUMPKIN), i(Items.JACK_O_LANTERN),
            i(Items.OAK_SIGN), i(Items.BIRCH_SIGN), i(Items.SPRUCE_SIGN), i(Items.JUNGLE_SIGN), i(Items.ACACIA_SIGN), i(Items.DARK_OAK_SIGN),
            i(Items.BEE_NEST), i(Items.BEEHIVE), i(Items.HONEYCOMB_BLOCK), i(Items.HONEY_BLOCK), i(Items.SLIME_BLOCK),
            i(Items.SNOW),
            i(Items.KELP), i(Items.SEAGRASS), i(Items.SEA_PICKLE),
            i(Items.TUBE_CORAL_BLOCK), i(Items.TUBE_CORAL), i(Items.TUBE_CORAL_FAN),
            i(Items.BRAIN_CORAL_BLOCK), i(Items.BRAIN_CORAL), i(Items.BRAIN_CORAL_FAN),
            i(Items.BUBBLE_CORAL_BLOCK), i(Items.BUBBLE_CORAL), i(Items.BUBBLE_CORAL_FAN),
            i(Items.FIRE_CORAL_BLOCK), i(Items.FIRE_CORAL), i(Items.FIRE_CORAL_FAN),
            i(Items.HORN_CORAL_BLOCK), i(Items.HORN_CORAL), i(Items.HORN_CORAL_FAN),
            i(Items.DEAD_TUBE_CORAL_BLOCK), i(Items.DEAD_TUBE_CORAL), i(Items.DEAD_TUBE_CORAL_FAN),
            i(Items.DEAD_BRAIN_CORAL_BLOCK), i(Items.DEAD_BRAIN_CORAL), i(Items.DEAD_BRAIN_CORAL_FAN),
            i(Items.DEAD_BUBBLE_CORAL_BLOCK), i(Items.DEAD_BUBBLE_CORAL), i(Items.DEAD_BUBBLE_CORAL_FAN),
            i(Items.DEAD_FIRE_CORAL_BLOCK), i(Items.DEAD_FIRE_CORAL), i(Items.DEAD_FIRE_CORAL_FAN),
            i(Items.DEAD_HORN_CORAL_BLOCK), i(Items.DEAD_HORN_CORAL), i(Items.DEAD_HORN_CORAL_FAN),
            i(Items.CRIMSON_FUNGUS), i(Items.CRIMSON_ROOTS), i(Items.WEEPING_VINES),
            i(Items.WARPED_FUNGUS), i(Items.WARPED_ROOTS), i(Items.NETHER_SPROUTS), i(Items.TWISTING_VINES),
            i(Items.CRIMSON_SIGN), i(Items.WARPED_SIGN),
            i(Items.CHORUS_PLANT), i(Items.CHORUS_FLOWER),
            i(Items.TORCH), i(Items.LANTERN), i(Items.CAMPFIRE), i(Items.SOUL_TORCH), i(Items.SOUL_LANTERN), i(Items.SOUL_CAMPFIRE), i(Items.END_ROD),
            i(Items.COBWEB), i(Items.FLOWER_POT), i(Items.PAINTING), i(Items.ITEM_FRAME), i(Items.ARMOR_STAND), i(Items.SCAFFOLDING), i(Items.LADDER), i(Items.CHAIN), i(Items.BELL),
            i(Items.CHEST), i(Items.CRAFTING_TABLE), i(Items.FURNACE), i(Items.JUKEBOX), i(Items.BOOKSHELF),
            i(Items.ENCHANTING_TABLE), i(Items.ENDER_CHEST), i(Items.LODESTONE), i(Items.RESPAWN_ANCHOR),
            i(Items.LOOM), i(Items.CARTOGRAPHY_TABLE), i(Items.SMITHING_TABLE), i(Items.FLETCHING_TABLE), i(Items.STONECUTTER),
            i(Items.SMOKER), i(Items.BLAST_FURNACE),
            i(Items.GRINDSTONE), i(Items.ANVIL), i(Items.CHIPPED_ANVIL), i(Items.DAMAGED_ANVIL),
            i(Items.COMPOSTER), i(Items.BARREL),
            i(Items.SHULKER_BOX),
            i(Items.WHITE_SHULKER_BOX), i(Items.RED_SHULKER_BOX), i(Items.ORANGE_SHULKER_BOX), i(Items.YELLOW_SHULKER_BOX),
            i(Items.LIME_SHULKER_BOX), i(Items.GREEN_SHULKER_BOX), i(Items.BLUE_SHULKER_BOX), i(Items.CYAN_SHULKER_BOX),
            i(Items.LIGHT_BLUE_SHULKER_BOX), i(Items.PINK_SHULKER_BOX), i(Items.MAGENTA_SHULKER_BOX), i(Items.PURPLE_SHULKER_BOX),
            i(Items.BROWN_SHULKER_BOX), i(Items.BLACK_SHULKER_BOX), i(Items.GRAY_SHULKER_BOX), i(Items.LIGHT_GRAY_SHULKER_BOX),
            i(Items.WHITE_CARPET), i(Items.RED_CARPET), i(Items.ORANGE_CARPET), i(Items.YELLOW_CARPET),
            i(Items.LIME_CARPET), i(Items.GREEN_CARPET), i(Items.BLUE_CARPET), i(Items.CYAN_CARPET),
            i(Items.LIGHT_BLUE_CARPET), i(Items.PINK_CARPET), i(Items.MAGENTA_CARPET), i(Items.PURPLE_CARPET),
            i(Items.BROWN_CARPET), i(Items.BLACK_CARPET), i(Items.GRAY_CARPET), i(Items.LIGHT_GRAY_CARPET),
            i(Items.WHITE_BED), i(Items.RED_BED), i(Items.ORANGE_BED), i(Items.YELLOW_BED),
            i(Items.LIME_BED), i(Items.GREEN_BED), i(Items.BLUE_BED), i(Items.CYAN_BED),
            i(Items.LIGHT_BLUE_BED), i(Items.PINK_BED), i(Items.MAGENTA_BED), i(Items.PURPLE_BED),
            i(Items.BROWN_BED), i(Items.BLACK_BED), i(Items.GRAY_BED), i(Items.LIGHT_GRAY_BED),
            i(Items.WHITE_BANNER), i(Items.RED_BANNER), i(Items.ORANGE_BANNER), i(Items.YELLOW_BANNER),
            i(Items.LIME_BANNER), i(Items.GREEN_BANNER), i(Items.BLUE_BANNER), i(Items.CYAN_BANNER),
            i(Items.LIGHT_BLUE_BANNER), i(Items.PINK_BANNER), i(Items.MAGENTA_BANNER), i(Items.PURPLE_BANNER),
            i(Items.BROWN_BANNER), i(Items.BLACK_BANNER), i(Items.GRAY_BANNER), i(Items.LIGHT_GRAY_BANNER),
            i(Items.SKELETON_SKULL), i(Items.WITHER_SKELETON_SKULL), i(Items.ZOMBIE_HEAD), i(Items.CREEPER_HEAD), i(Items.PLAYER_HEAD), i(Items.DRAGON_HEAD)
    );

    public static final DefaultedList<ItemStack> EQUIPMENT = DefaultedList.copyOf(ItemStack.EMPTY,
            i(Items.WOODEN_SWORD), i(Items.WOODEN_PICKAXE), i(Items.WOODEN_AXE), i(Items.WOODEN_SHOVEL), i(Items.WOODEN_HOE),
            i(Items.LEATHER_HELMET), i(Items.LEATHER_CHESTPLATE), i(Items.LEATHER_LEGGINGS), i(Items.LEATHER_BOOTS), i(Items.LEATHER_HORSE_ARMOR),
            i(Items.FISHING_ROD),
            i(Items.STONE_SWORD), i(Items.STONE_PICKAXE), i(Items.STONE_AXE), i(Items.STONE_SHOVEL), i(Items.STONE_HOE),
            i(Items.CHAINMAIL_HELMET), i(Items.CHAINMAIL_CHESTPLATE), i(Items.CHAINMAIL_LEGGINGS), i(Items.CHAINMAIL_BOOTS),
            i(Items.BOW), i(Items.CROSSBOW),
            i(Items.IRON_SWORD), i(Items.IRON_PICKAXE), i(Items.IRON_AXE), i(Items.IRON_SHOVEL), i(Items.IRON_HOE),
            i(Items.IRON_HELMET), i(Items.IRON_CHESTPLATE), i(Items.IRON_LEGGINGS), i(Items.IRON_BOOTS), i(Items.IRON_HORSE_ARMOR),
            i(Items.SHEARS),
            i(Items.GOLDEN_SWORD), i(Items.GOLDEN_PICKAXE), i(Items.GOLDEN_AXE), i(Items.GOLDEN_SHOVEL), i(Items.GOLDEN_HOE),
            i(Items.GOLDEN_HELMET), i(Items.GOLDEN_CHESTPLATE), i(Items.GOLDEN_LEGGINGS), i(Items.GOLDEN_BOOTS), i(Items.GOLDEN_HORSE_ARMOR),
            i(Items.SHIELD),
            i(Items.DIAMOND_SWORD), i(Items.DIAMOND_PICKAXE), i(Items.DIAMOND_AXE), i(Items.DIAMOND_SHOVEL), i(Items.DIAMOND_HOE),
            i(Items.DIAMOND_HELMET), i(Items.DIAMOND_CHESTPLATE), i(Items.DIAMOND_LEGGINGS), i(Items.DIAMOND_BOOTS), i(Items.DIAMOND_HORSE_ARMOR),
            i(Items.TRIDENT),
            i(Items.NETHERITE_SWORD), i(Items.NETHERITE_PICKAXE), i(Items.NETHERITE_AXE), i(Items.NETHERITE_SHOVEL), i(Items.NETHERITE_HOE),
            i(Items.NETHERITE_HELMET), i(Items.NETHERITE_CHESTPLATE), i(Items.NETHERITE_LEGGINGS), i(Items.NETHERITE_BOOTS),
            i(Items.FLINT_AND_STEEL), i(Items.TOTEM_OF_UNDYING),
            i(Items.TURTLE_HELMET), i(Items.ARROW), i(Items.SPECTRAL_ARROW),
            tA(Potions.STRENGTH), tA(Potions.LONG_STRENGTH), tA(Potions.STRONG_STRENGTH),
            tA(Potions.HEALING), tA(Potions.STRONG_HEALING),
            tA(Potions.REGENERATION), tA(Potions.LONG_REGENERATION), tA(Potions.STRONG_REGENERATION),
            tA(Potions.FIRE_RESISTANCE), tA(Potions.LONG_FIRE_RESISTANCE),
            tA(Potions.LEAPING), tA(Potions.LONG_LEAPING), tA(Potions.STRONG_LEAPING),
            tA(Potions.LUCK),
            tA(Potions.SWIFTNESS), tA(Potions.LONG_SWIFTNESS), tA(Potions.STRONG_SWIFTNESS),
            tA(Potions.INVISIBILITY), tA(Potions.LONG_INVISIBILITY),
            tA(Potions.WATER_BREATHING), tA(Potions.LONG_WATER_BREATHING),
            tA(Potions.NIGHT_VISION), tA(Potions.LONG_NIGHT_VISION),
            tA(Potions.SLOW_FALLING), tA(Potions.LONG_SLOW_FALLING),
            tA(Potions.HARMING), tA(Potions.STRONG_HARMING),
            tA(Potions.POISON), tA(Potions.LONG_POISON), tA(Potions.STRONG_POISON),
            tA(Potions.SLOWNESS), tA(Potions.LONG_SLOWNESS), tA(Potions.STRONG_SLOWNESS),
            tA(Potions.WEAKNESS), tA(Potions.LONG_WEAKNESS),
            tA(Potions.TURTLE_MASTER), tA(Potions.LONG_TURTLE_MASTER), tA(Potions.STRONG_TURTLE_MASTER)
    );

    public static final DefaultedList<ItemStack> ITEMS = DefaultedList.copyOf(ItemStack.EMPTY,
            i(Items.CHARCOAL), i(Items.COAL), i(Items.IRON_INGOT), i(Items.IRON_NUGGET),
            i(Items.GOLD_INGOT), i(Items.GOLD_NUGGET), i(Items.LAPIS_LAZULI), i(Items.EMERALD),
            i(Items.DIAMOND), i(Items.QUARTZ), i(Items.NETHERITE_SCRAP), i(Items.NETHERITE_INGOT),
            i(Items.FLINT), i(Items.CLAY_BALL), i(Items.SNOWBALL), i(Items.SLIME_BALL), i(Items.HONEYCOMB),
            i(Items.WHEAT_SEEDS), i(Items.PUMPKIN_SEEDS), i(Items.MELON_SEEDS), i(Items.BEETROOT_SEEDS), i(Items.COCOA_BEANS),
            i(Items.WHEAT), i(Items.SUGAR), i(Items.STICK), i(Items.STRING), i(Items.GUNPOWDER), i(Items.BONE), i(Items.BONE_MEAL), i(Items.ENDER_PEARL), i(Items.NETHER_WART), i(Items.BLAZE_ROD),
            i(Items.BOWL), i(Items.BUCKET), i(Items.MILK_BUCKET), i(Items.LAVA_BUCKET), i(Items.WATER_BUCKET)
    );
    
    private static ItemStack i(ItemConvertible item) {
        return new ItemStack(item);
    }
    private static ItemStack tA(Potion potion) {
        return PotionUtil.setPotion(i(Items.TIPPED_ARROW), potion);
    }

    //tA(StatusEffects.STRENGTH, 0, 22, 1), tA(StatusEffects.STRENGTH, 1, 0, 1), tA(StatusEffects.STRENGTH, 0, 11, 2),
    //tA(StatusEffects.INSTANT_HEALTH, 0, 1, 1), tA(StatusEffects.INSTANT_HEALTH, 0, 1, 2),
    //tA(StatusEffects.REGENERATION, 0, 5, 1), tA(StatusEffects.REGENERATION, 0, 11, 1), tA(StatusEffects.REGENERATION, 0, 2, 2),
    //tA(StatusEffects.FIRE_RESISTANCE, 0, 22, 1), tA(StatusEffects.FIRE_RESISTANCE, 1, 0, 1),
    //tA(StatusEffects.JUMP_BOOST, 0, 22, 1), tA(StatusEffects.JUMP_BOOST, 1, 0, 1), tA(StatusEffects.JUMP_BOOST, 0, 11, 2),
    //tA(StatusEffects.LUCK, 0, 37, 1),
    //tA(StatusEffects.SPEED, 0, 22, 1), tA(StatusEffects.SPEED, 1, 0, 1), tA(StatusEffects.SPEED, 0, 11, 2),
    //tA(StatusEffects.INVISIBILITY, 0, 22, 1), tA(StatusEffects.INVISIBILITY, 1, 0, 1),
    //tA(StatusEffects.WATER_BREATHING, 0, 22, 1), tA(StatusEffects.WATER_BREATHING, 1, 0, 1),
    //tA(StatusEffects.NIGHT_VISION, 0, 22, 1), tA(StatusEffects.NIGHT_VISION, 1, 0, 1),
    //tA(StatusEffects.SLOW_FALLING, 0, 11, 1), tA(StatusEffects.SLOW_FALLING, 1, 30, 1)
}