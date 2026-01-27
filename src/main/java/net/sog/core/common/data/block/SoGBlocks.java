package net.sog.core.common.data.block;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.machine.multiblock.IBatteryData;
import com.gregtechceu.gtceu.common.block.BatteryBlock;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Blocks;

import static net.sog.core.common.registry.SoGRegistration.REGISTRATE;

public class SoGBlocks {
    private static BlockEntry<BatteryBlock> createAddonBatteryBlock(IBatteryData batteryData) {
        var batteryBlock = REGISTRATE.block("%s_battery".formatted(batteryData.getBatteryName()),
                        p -> new BatteryBlock(p, batteryData))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, entityType) -> false))
                .blockstate(GTModels.createBatteryBlockModel(batteryData))
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .item(BlockItem::new)
                .build()
                .register();

        GTCEuAPI.PSS_BATTERIES.put(batteryData, batteryBlock);
        return batteryBlock;
    }
    public static final BlockEntry<BatteryBlock> BATTERY_ULTIMATE_UXV = createAddonBatteryBlock(
            SoGBatteryBlock.BatteryPartType.UXV_ULTIMATE);
}
