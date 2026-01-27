package net.sog.core.common.data.block;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.multiblock.IBatteryData;

import java.util.Locale;

    public enum SoGGBatteryData implements IBatteryData {
        UXV_ULTIMATE(GTValues.UXV, Long.MAX_VALUE);

        private final int tier;
        private final long capacity;

        SoGGBatteryData(int tier, long capacity) {
            this.tier = tier;
            this.capacity = capacity;
        }

        @Override
        public int getTier() {
            return tier;
        }

        @Override
        public long getCapacity() {
            return capacity;
        }

        @Override
        public String getBatteryName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
