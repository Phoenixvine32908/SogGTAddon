package net.sog.core.mixin.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.sog.core.utils.CompactCount;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(GuiGraphics.class)
public class GuiGraphicsCountSuffixMixin {

    @ModifyVariable(
                    method = "drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;IIIZ)I",
                    at = @At("HEAD"),
                    argsOnly = true)
    private String sog$compact_drawString_int(String s) {
        return CompactCount.compactIfNumeric(s);
    }

    @ModifyVariable(
                    method = "drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;IIIZ)I",
                    at = @At("HEAD"),
                    argsOnly = true,
                    require = 0)
    private String sog$compactDrawStringInt(String s) {
        return CompactCount.compactIfNumeric(s);
    }

    @ModifyVariable(
                    method = "drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;III)I",
                    at = @At("HEAD"),
                    argsOnly = true,
                    require = 0)
    private String sog$compact_drawString_simple(String s) {
        return CompactCount.compactIfNumeric(s);
    }

    @ModifyVariable(
                    method = "drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;IIIZ)I",
                    at = @At("HEAD"),
                    argsOnly = true,
                    require = 0)
    private Component sog$compact_component(Component c) {
        if (c == null) return null;
        String s = c.getString();
        String out = CompactCount.compactIfNumeric(s);
        return out.equals(s) ? c : Component.literal(out);
    }
}
