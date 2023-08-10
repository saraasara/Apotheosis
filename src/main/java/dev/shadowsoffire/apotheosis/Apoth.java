package dev.shadowsoffire.apotheosis;

import dev.shadowsoffire.apotheosis.adventure.affix.AffixRegistry;
import dev.shadowsoffire.apotheosis.adventure.affix.effect.DurableAffix;
import dev.shadowsoffire.apotheosis.adventure.affix.effect.FestiveAffix;
import dev.shadowsoffire.apotheosis.adventure.affix.effect.MagicalArrowAffix;
import dev.shadowsoffire.apotheosis.adventure.affix.effect.OmneticAffix;
import dev.shadowsoffire.apotheosis.adventure.affix.effect.RadialAffix;
import dev.shadowsoffire.apotheosis.adventure.affix.effect.TelepathicAffix;
import dev.shadowsoffire.apotheosis.adventure.affix.reforging.ReforgingMenu;
import dev.shadowsoffire.apotheosis.adventure.affix.reforging.ReforgingTableBlock;
import dev.shadowsoffire.apotheosis.adventure.affix.reforging.ReforgingTableTile;
import dev.shadowsoffire.apotheosis.adventure.affix.salvaging.SalvagingMenu;
import dev.shadowsoffire.apotheosis.adventure.affix.salvaging.SalvagingRecipe;
import dev.shadowsoffire.apotheosis.adventure.affix.salvaging.SalvagingTableBlock;
import dev.shadowsoffire.apotheosis.adventure.affix.salvaging.SalvagingTableTile;
import dev.shadowsoffire.apotheosis.adventure.affix.socket.SocketAffix;
import dev.shadowsoffire.apotheosis.adventure.affix.socket.gem.cutting.GemCuttingBlock;
import dev.shadowsoffire.apotheosis.adventure.affix.socket.gem.cutting.GemCuttingMenu;
import dev.shadowsoffire.apotheosis.adventure.boss.BossSpawnerBlock;
import dev.shadowsoffire.apotheosis.adventure.boss.BossSpawnerBlock.BossSpawnerTile;
import dev.shadowsoffire.apotheosis.adventure.loot.LootRarity;
import dev.shadowsoffire.apotheosis.adventure.loot.RarityRegistry;
import dev.shadowsoffire.apotheosis.ench.anvil.AnvilTile;
import dev.shadowsoffire.apotheosis.ench.anvil.ObliterationEnchant;
import dev.shadowsoffire.apotheosis.ench.anvil.SplittingEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.ChromaticEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.InertEnchantment;
import dev.shadowsoffire.apotheosis.ench.enchantments.NaturesBlessingEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.ReflectiveEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.SpearfishingEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.StableFootingEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.TemptingEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.corrupted.BerserkersFuryEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.corrupted.LifeMendingEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.masterwork.ChainsawEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.masterwork.CrescendoEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.masterwork.EarthsBoonEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.masterwork.EndlessQuiverEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.masterwork.GrowthSerumEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.masterwork.KnowledgeEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.masterwork.ScavengerEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.twisted.ExploitationEnchant;
import dev.shadowsoffire.apotheosis.ench.enchantments.twisted.MinersFervorEnchant;
import dev.shadowsoffire.apotheosis.ench.library.EnchLibraryBlock;
import dev.shadowsoffire.apotheosis.ench.library.EnchLibraryContainer;
import dev.shadowsoffire.apotheosis.ench.library.EnchLibraryTile;
import dev.shadowsoffire.apotheosis.ench.table.ApothEnchantContainer;
import dev.shadowsoffire.apotheosis.ench.table.EnchantingRecipe;
import dev.shadowsoffire.apotheosis.garden.EnderLeadItem;
import dev.shadowsoffire.apotheosis.potion.PotionCharmItem;
import dev.shadowsoffire.apotheosis.spawn.enchantment.CapturingEnchant;
import dev.shadowsoffire.apotheosis.spawn.modifiers.SpawnerModifier;
import dev.shadowsoffire.apotheosis.village.fletching.FletchingContainer;
import dev.shadowsoffire.apotheosis.village.fletching.FletchingRecipe;
import dev.shadowsoffire.apotheosis.village.fletching.arrows.BroadheadArrowEntity;
import dev.shadowsoffire.apotheosis.village.fletching.arrows.BroadheadArrowItem;
import dev.shadowsoffire.apotheosis.village.fletching.arrows.ExplosiveArrowEntity;
import dev.shadowsoffire.apotheosis.village.fletching.arrows.ExplosiveArrowItem;
import dev.shadowsoffire.apotheosis.village.fletching.arrows.MiningArrowEntity;
import dev.shadowsoffire.apotheosis.village.fletching.arrows.MiningArrowItem;
import dev.shadowsoffire.apotheosis.village.fletching.arrows.ObsidianArrowEntity;
import dev.shadowsoffire.apotheosis.village.fletching.arrows.ObsidianArrowItem;
import dev.shadowsoffire.placebo.registry.RegObjHelper;
import dev.shadowsoffire.placebo.reload.DynamicHolder;
import dev.shadowsoffire.placebo.util.PlaceboUtil;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Object Holder Class. For the main mod class, see {@link Apotheosis}
 */
public class Apoth {

    public static final RegObjHelper R = new RegObjHelper(Apotheosis.MODID);

    public static final class Blocks {
        public static final RegistryObject<EnchLibraryBlock> LIBRARY = R.block("LIBRARY");
        public static final RegistryObject<Block> HELLSHELF = R.block("HELLSHELF");
        public static final RegistryObject<Block> INFUSED_HELLSHELF = R.block("INFUSED_HELLSHELF");
        public static final RegistryObject<Block> BLAZING_HELLSHELF = R.block("BLAZING_HELLSHELF");
        public static final RegistryObject<Block> GLOWING_HELLSHELF = R.block("GLOWING_HELLSHELF");
        public static final RegistryObject<Block> SEASHELF = R.block("SEASHELF");
        public static final RegistryObject<Block> INFUSED_SEASHELF = R.block("INFUSED_SEASHELF");
        public static final RegistryObject<Block> CRYSTAL_SEASHELF = R.block("CRYSTAL_SEASHELF");
        public static final RegistryObject<Block> HEART_SEASHELF = R.block("HEART_SEASHELF");
        public static final RegistryObject<Block> DORMANT_DEEPSHELF = R.block("DORMANT_DEEPSHELF");
        public static final RegistryObject<Block> DEEPSHELF = R.block("DEEPSHELF");
        public static final RegistryObject<Block> ECHOING_DEEPSHELF = R.block("ECHOING_DEEPSHELF");
        public static final RegistryObject<Block> SOUL_TOUCHED_DEEPSHELF = R.block("SOUL_TOUCHED_DEEPSHELF");
        public static final RegistryObject<Block> ECHOING_SCULKSHELF = R.block("ECHOING_SCULKSHELF");
        public static final RegistryObject<Block> SOUL_TOUCHED_SCULKSHELF = R.block("SOUL_TOUCHED_SCULKSHELF");
        public static final RegistryObject<Block> ENDSHELF = R.block("ENDSHELF");
        public static final RegistryObject<Block> PEARL_ENDSHELF = R.block("PEARL_ENDSHELF");
        public static final RegistryObject<Block> DRACONIC_ENDSHELF = R.block("DRACONIC_ENDSHELF");
        public static final RegistryObject<Block> BEESHELF = R.block("BEESHELF");
        public static final RegistryObject<Block> MELONSHELF = R.block("MELONSHELF");
        public static final RegistryObject<Block> STONESHELF = R.block("STONESHELF");
        public static final RegistryObject<Block> RECTIFIER = R.block("RECTIFIER");
        public static final RegistryObject<Block> RECTIFIER_T2 = R.block("RECTIFIER_T2");
        public static final RegistryObject<Block> RECTIFIER_T3 = R.block("RECTIFIER_T3");
        public static final RegistryObject<Block> SIGHTSHELF = R.block("SIGHTSHELF");
        public static final RegistryObject<Block> SIGHTSHELF_T2 = R.block("SIGHTSHELF_T2");
        public static final RegistryObject<EnchLibraryBlock> ENDER_LIBRARY = R.block("ENDER_LIBRARY");
        public static final RegistryObject<BossSpawnerBlock> BOSS_SPAWNER = R.block("BOSS_SPAWNER");
        public static final RegistryObject<ReforgingTableBlock> SIMPLE_REFORGING_TABLE = R.block("SIMPLE_REFORGING_TABLE");
        public static final RegistryObject<ReforgingTableBlock> REFORGING_TABLE = R.block("REFORGING_TABLE");
        public static final RegistryObject<SalvagingTableBlock> SALVAGING_TABLE = R.block("SALVAGING_TABLE");
        public static final RegistryObject<GemCuttingBlock> GEM_CUTTING_TABLE = R.block("gem_cutting_table");
    }

    public static final class Items {
        public static final RegistryObject<PotionCharmItem> POTION_CHARM = R.item("POTION_CHARM");
        public static final RegistryObject<Item> LUCKY_FOOT = R.item("LUCKY_FOOT");
        public static final RegistryObject<ObsidianArrowItem> OBSIDIAN_ARROW = R.item("OBSIDIAN_ARROW");
        public static final RegistryObject<BroadheadArrowItem> BROADHEAD_ARROW = R.item("BROADHEAD_ARROW");
        public static final RegistryObject<ExplosiveArrowItem> EXPLOSIVE_ARROW = R.item("EXPLOSIVE_ARROW");
        public static final RegistryObject<MiningArrowItem> IRON_MINING_ARROW = R.item("IRON_MINING_ARROW");
        public static final RegistryObject<MiningArrowItem> DIAMOND_MINING_ARROW = R.item("DIAMOND_MINING_ARROW");
        public static final RegistryObject<EnderLeadItem> ENDER_LEAD = R.item("ENDER_LEAD");
        public static final RegistryObject<Item> PRISMATIC_WEB = R.item("PRISMATIC_WEB");
        public static final RegistryObject<Item> SCRAP_TOME = R.item("SCRAP_TOME");
        public static final RegistryObject<Item> OTHER_TOME = R.item("OTHER_TOME");
        public static final RegistryObject<Item> HELMET_TOME = R.item("HELMET_TOME");
        public static final RegistryObject<Item> CHESTPLATE_TOME = R.item("CHESTPLATE_TOME");
        public static final RegistryObject<Item> LEGGINGS_TOME = R.item("LEGGINGS_TOME");
        public static final RegistryObject<Item> BOOTS_TOME = R.item("BOOTS_TOME");
        public static final RegistryObject<Item> WEAPON_TOME = R.item("WEAPON_TOME");
        public static final RegistryObject<Item> PICKAXE_TOME = R.item("PICKAXE_TOME");
        public static final RegistryObject<Item> FISHING_TOME = R.item("FISHING_TOME");
        public static final RegistryObject<Item> BOW_TOME = R.item("BOW_TOME");
        public static final RegistryObject<Item> GEM = R.item("GEM");
        public static final RegistryObject<Item> GEM_DUST = R.item("GEM_DUST");
        public static final RegistryObject<Item> VIAL_OF_EXPULSION = R.item("VIAL_OF_EXPULSION");
        public static final RegistryObject<Item> VIAL_OF_EXTRACTION = R.item("VIAL_OF_EXTRACTION");
        public static final RegistryObject<Item> VIAL_OF_UNNAMING = R.item("VIAL_OF_UNNAMING");
        public static final RegistryObject<Item> WARDEN_TENDRIL = R.item("WARDEN_TENDRIL");

        public static final RegistryObject<Item> SKULL_FRAGMENT = RegistryObject.create(new ResourceLocation("wstweaks", "fragment"), ForgeRegistries.ITEMS);
    }

    public static final class Enchantments {
        public static final RegistryObject<EndlessQuiverEnchant> ENDLESS_QUIVER = R.enchant("ENDLESS_QUIVER");
        public static final RegistryObject<CapturingEnchant> CAPTURING = R.enchant("CAPTURING");
        public static final RegistryObject<BerserkersFuryEnchant> BERSERKERS_FURY = R.enchant("BERSERKERS_FURY");
        public static final RegistryObject<CrescendoEnchant> CRESCENDO = R.enchant("CRESCENDO");
        public static final RegistryObject<KnowledgeEnchant> KNOWLEDGE = R.enchant("KNOWLEDGE");
        public static final RegistryObject<LifeMendingEnchant> LIFE_MENDING = R.enchant("LIFE_MENDING");
        public static final RegistryObject<MinersFervorEnchant> MINERS_FERVOR = R.enchant("MINERS_FERVOR");
        public static final RegistryObject<NaturesBlessingEnchant> NATURES_BLESSING = R.enchant("NATURES_BLESSING");
        public static final RegistryObject<ReflectiveEnchant> REFLECTIVE = R.enchant("REFLECTIVE");
        public static final RegistryObject<ScavengerEnchant> SCAVENGER = R.enchant("SCAVENGER");
        public static final RegistryObject<StableFootingEnchant> STABLE_FOOTING = R.enchant("STABLE_FOOTING");
        public static final RegistryObject<TemptingEnchant> TEMPTING = R.enchant("TEMPTING");
        public static final RegistryObject<ObliterationEnchant> OBLITERATION = R.enchant("OBLITERATION");
        public static final RegistryObject<SplittingEnchant> SPLITTING = R.enchant("SPLITTING");
        public static final RegistryObject<InertEnchantment> INFUSION = R.enchant("INFUSION");
        public static final RegistryObject<ChromaticEnchant> CHROMATIC = R.enchant("CHROMATIC");
        public static final RegistryObject<ExploitationEnchant> EXPLOITATION = R.enchant("EXPLOITATION");
        public static final RegistryObject<GrowthSerumEnchant> GROWTH_SERUM = R.enchant("GROWTH_SERUM");
        public static final RegistryObject<EarthsBoonEnchant> EARTHS_BOON = R.enchant("EARTHS_BOON");
        public static final RegistryObject<ChainsawEnchant> CHAINSAW = R.enchant("CHAINSAW");
        public static final RegistryObject<SpearfishingEnchant> SPEARFISHING = R.enchant("SPEARFISHING");
    }

    public static final class Potions {
        public static final RegistryObject<Potion> RESISTANCE = R.potion("RESISTANCE");
        public static final RegistryObject<Potion> LONG_RESISTANCE = R.potion("LONG_RESISTANCE");
        public static final RegistryObject<Potion> STRONG_RESISTANCE = R.potion("STRONG_RESISTANCE");
        public static final RegistryObject<Potion> ABSORPTION = R.potion("ABSORPTION");
        public static final RegistryObject<Potion> LONG_ABSORPTION = R.potion("LONG_ABSORPTION");
        public static final RegistryObject<Potion> STRONG_ABSORPTION = R.potion("STRONG_ABSORPTION");
        public static final RegistryObject<Potion> HASTE = R.potion("HASTE");
        public static final RegistryObject<Potion> LONG_HASTE = R.potion("LONG_HASTE");
        public static final RegistryObject<Potion> STRONG_HASTE = R.potion("STRONG_HASTE");
        public static final RegistryObject<Potion> FATIGUE = R.potion("FATIGUE");
        public static final RegistryObject<Potion> LONG_FATIGUE = R.potion("LONG_FATIGUE");
        public static final RegistryObject<Potion> STRONG_FATIGUE = R.potion("STRONG_FATIGUE");
        public static final RegistryObject<Potion> SUNDERING = R.potion("SUNDERING");
        public static final RegistryObject<Potion> LONG_SUNDERING = R.potion("LONG_SUNDERING");
        public static final RegistryObject<Potion> STRONG_SUNDERING = R.potion("STRONG_SUNDERING");
        public static final RegistryObject<Potion> KNOWLEDGE = R.potion("KNOWLEDGE");
        public static final RegistryObject<Potion> LONG_KNOWLEDGE = R.potion("LONG_KNOWLEDGE");
        public static final RegistryObject<Potion> STRONG_KNOWLEDGE = R.potion("STRONG_KNOWLEDGE");
        public static final RegistryObject<Potion> WITHER = R.potion("WITHER");
        public static final RegistryObject<Potion> LONG_WITHER = R.potion("LONG_WITHER");
        public static final RegistryObject<Potion> STRONG_WITHER = R.potion("STRONG_WITHER");
        public static final RegistryObject<Potion> VITALITY = R.potion("VITALITY");
        public static final RegistryObject<Potion> LONG_VITALITY = R.potion("LONG_VITALITY");
        public static final RegistryObject<Potion> STRONG_VITALITY = R.potion("STRONG_VITALITY");
        public static final RegistryObject<Potion> GRIEVOUS = R.potion("GRIEVOUS");
        public static final RegistryObject<Potion> LONG_GRIEVOUS = R.potion("LONG_GRIEVOUS");
        public static final RegistryObject<Potion> STRONG_GRIEVOUS = R.potion("STRONG_GRIEVOUS");
    }

    public static final class Entities {
        public static final RegistryObject<EntityType<ObsidianArrowEntity>> OBSIDIAN_ARROW = R.entity("OBSIDIAN_ARROW");
        public static final RegistryObject<EntityType<BroadheadArrowEntity>> BROADHEAD_ARROW = R.entity("BROADHEAD_ARROW");
        public static final RegistryObject<EntityType<ExplosiveArrowEntity>> EXPLOSIVE_ARROW = R.entity("EXPLOSIVE_ARROW");
        public static final RegistryObject<EntityType<MiningArrowEntity>> MINING_ARROW = R.entity("MINING_ARROW");
    }

    public static final class Menus {
        public static final RegistryObject<MenuType<FletchingContainer>> FLETCHING = R.menu("fletching");
        public static final RegistryObject<MenuType<EnchLibraryContainer>> LIBRARY = R.menu("library");
        public static final RegistryObject<MenuType<ApothEnchantContainer>> ENCHANTING_TABLE = R.menu("enchanting_table");
        public static final RegistryObject<MenuType<ReforgingMenu>> REFORGING = R.menu("reforging");
        public static final RegistryObject<MenuType<SalvagingMenu>> SALVAGE = R.menu("salvage");
        public static final RegistryObject<MenuType<GemCuttingMenu>> GEM_CUTTING = R.menu("gem_cutting");
    }

    public static final class Tiles {
        public static final RegistryObject<BlockEntityType<EnchLibraryTile>> LIBRARY = R.blockEntity("LIBRARY");
        public static final RegistryObject<BlockEntityType<AnvilTile>> ANVIL = R.blockEntity("ANVIL");
        public static final RegistryObject<BlockEntityType<EnchLibraryTile>> ENDER_LIBRARY = R.blockEntity("ENDER_LIBRARY");
        public static final RegistryObject<BlockEntityType<BossSpawnerTile>> BOSS_SPAWNER = R.blockEntity("BOSS_SPAWNER");
        public static final RegistryObject<BlockEntityType<ReforgingTableTile>> REFORGING_TABLE = R.blockEntity("REFORGING_TABLE");
        public static final RegistryObject<BlockEntityType<SalvagingTableTile>> SALVAGING_TABLE = R.blockEntity("SALVAGING_TABLE");
    }

    public static final class Affixes {
        // Implicit affixes
        public static final DynamicHolder<SocketAffix> SOCKET = AffixRegistry.INSTANCE.holder(Apotheosis.loc("socket"));
        public static final DynamicHolder<DurableAffix> DURABLE = AffixRegistry.INSTANCE.holder(Apotheosis.loc("durable"));
        // Real affixes
        public static final DynamicHolder<MagicalArrowAffix> MAGICAL = AffixRegistry.INSTANCE.holder(Apotheosis.loc("ranged/special/magical"));
        public static final DynamicHolder<FestiveAffix> FESTIVE = AffixRegistry.INSTANCE.holder(Apotheosis.loc("sword/special/festive"));
        public static final DynamicHolder<TelepathicAffix> TELEPATHIC = AffixRegistry.INSTANCE.holder(Apotheosis.loc("telepathic"));
        public static final DynamicHolder<OmneticAffix> OMNETIC = AffixRegistry.INSTANCE.holder(Apotheosis.loc("breaker/special/omnetic"));
        public static final DynamicHolder<RadialAffix> RADIAL = AffixRegistry.INSTANCE.holder(Apotheosis.loc("breaker/special/radial"));
    }

    @Deprecated
    public static final class Rarities {
        public static final DynamicHolder<LootRarity> COMMON = RarityRegistry.INSTANCE.holder(Apotheosis.loc("common"));
        public static final DynamicHolder<LootRarity> UNCOMMON = RarityRegistry.INSTANCE.holder(Apotheosis.loc("uncommon"));
        public static final DynamicHolder<LootRarity> RARE = RarityRegistry.INSTANCE.holder(Apotheosis.loc("rare"));
        public static final DynamicHolder<LootRarity> EPIC = RarityRegistry.INSTANCE.holder(Apotheosis.loc("epic"));
        public static final DynamicHolder<LootRarity> MYTHIC = RarityRegistry.INSTANCE.holder(Apotheosis.loc("mythic"));
        public static final DynamicHolder<LootRarity> ANCIENT = RarityRegistry.INSTANCE.holder(Apotheosis.loc("ancient"));
    }

    public static final class Tags {
        public static final TagKey<Item> BOON_DROPS = ItemTags.create(new ResourceLocation(Apotheosis.MODID, "boon_drops"));
        public static final TagKey<Item> SPEARFISHING_DROPS = ItemTags.create(new ResourceLocation(Apotheosis.MODID, "spearfishing_drops"));
    }

    public static final class RecipeTypes {
        public static final RecipeType<FletchingRecipe> FLETCHING = PlaceboUtil.makeRecipeType("apotheosis:fletching");
        public static final RecipeType<EnchantingRecipe> INFUSION = PlaceboUtil.makeRecipeType("apotheosis:enchanting");
        public static final RecipeType<SpawnerModifier> MODIFIER = PlaceboUtil.makeRecipeType("apotheosis:spawner_modifier");
        public static final RecipeType<SalvagingRecipe> SALVAGING = PlaceboUtil.makeRecipeType("apotheosis:salvaging");
    }

    public static final class LootTables {
        public static final ResourceLocation CHEST_VALUABLE = Apotheosis.loc("chests/chest_valuable");
        public static final ResourceLocation SPAWNER_BRUTAL_ROTATE = Apotheosis.loc("chests/spawner_brutal_rotate");
        public static final ResourceLocation SPAWNER_BRUTAL = Apotheosis.loc("chests/spawner_brutal");
        public static final ResourceLocation SPAWNER_SWARM = Apotheosis.loc("chests/spawner_swarm");
        public static final ResourceLocation TOME_TOWER = Apotheosis.loc("chests/tome_tower");
    }

    public static final class Particles {
        public static final RegistryObject<SimpleParticleType> ENCHANT_FIRE = R.particle("enchant_fire");
        public static final RegistryObject<SimpleParticleType> ENCHANT_WATER = R.particle("enchant_water");
        public static final RegistryObject<SimpleParticleType> ENCHANT_SCULK = R.particle("enchant_sculk");
        public static final RegistryObject<SimpleParticleType> ENCHANT_END = R.particle("enchant_end");
    }

    public static final class DamageTypes {
        public static final ResourceKey<DamageType> EXECUTE = ResourceKey.create(Registries.DAMAGE_TYPE, Apotheosis.loc("execute"));
        public static final ResourceKey<DamageType> PSYCHIC = ResourceKey.create(Registries.DAMAGE_TYPE, Apotheosis.loc("psychic"));
        public static final ResourceKey<DamageType> CORRUPTED = ResourceKey.create(Registries.DAMAGE_TYPE, Apotheosis.loc("corrupted"));
    }

}