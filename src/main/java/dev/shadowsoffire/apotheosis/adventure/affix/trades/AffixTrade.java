package dev.shadowsoffire.apotheosis.adventure.affix.trades;

import javax.annotation.Nullable;

import dev.shadowsoffire.apotheosis.adventure.affix.AffixHelper;
import dev.shadowsoffire.apotheosis.adventure.loot.LootController;
import dev.shadowsoffire.apotheosis.adventure.loot.LootRarity;
import dev.shadowsoffire.apotheosis.village.wanderer.JsonTrade;
import dev.shadowsoffire.placebo.json.ItemAdapter;
import dev.shadowsoffire.placebo.json.PSerializer;
import dev.shadowsoffire.placebo.reload.DynamicHolder;
import dev.shadowsoffire.placebo.reload.TypeKeyed.TypeKeyedBase;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

public class AffixTrade extends TypeKeyedBase<JsonTrade> implements JsonTrade {

    public static final PSerializer<AffixTrade> SERIALIZER = PSerializer.basic("Affix Trade", obj -> ItemAdapter.ITEM_READER.fromJson(obj, AffixTrade.class));

    protected final boolean rare;

    public AffixTrade(int rarityOffset, boolean rare) {
        this.rare = rare;
    }

    @Override
    @Nullable
    public MerchantOffer getOffer(Entity pTrader, RandomSource pRand) {
        if (!(pTrader.level() instanceof ServerLevel)) return null;
        Player nearest = pTrader.level().getNearestPlayer(pTrader, -1);
        if (nearest == null) return null;
        ItemStack affixItem = LootController.createRandomLootItem(pRand, null, nearest, (ServerLevel) pTrader.level());
        if (affixItem.isEmpty()) return null;
        affixItem.getTag().putBoolean("apoth_merchant", true);
        ItemStack stdItem = affixItem.copy();
        stdItem.setTag(null);
        DynamicHolder<LootRarity> rarity = AffixHelper.getRarity(affixItem);
        if (!rarity.isBound()) return null;
        int ordinal = rarity.get().ordinal();
        ItemStack emeralds = new ItemStack(Items.EMERALD, 8 + ordinal * 8);
        if (ordinal >= 4) {
            emeralds = new ItemStack(Items.EMERALD_BLOCK, 20 + (ordinal - 4) * 10);
        }
        return new MerchantOffer(stdItem, emeralds, affixItem, 1, 100, 1);
    }

    @Override
    public boolean isRare() {
        return this.rare;
    }

    @Override
    public PSerializer<? extends JsonTrade> getSerializer() {
        return SERIALIZER;
    }

}