//package com.lzimul.LawAssistAdventure.client.trigger;
//
//import com.lzimul.LawAssistAdventure.register.TriggerRegister;
//import com.mojang.serialization.Codec;
//import com.mojang.serialization.codecs.RecordCodecBuilder;
//import net.minecraft.advancements.Criterion;
//import net.minecraft.advancements.critereon.ContextAwarePredicate;
//import net.minecraft.advancements.critereon.EntityPredicate;
//import net.minecraft.advancements.critereon.ItemPredicate;
//import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.util.ExtraCodecs;
//import net.minecraft.world.item.ItemStack;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.Optional;
//
//public record DemoTriggers(Optional<ContextAwarePredicate> player, ItemPredicate item) implements SimpleCriterionTrigger.SimpleInstance {
//    public static Criterion<DemoTriggers> instance(ContextAwarePredicate player, ItemPredicate item) {
//        return TriggerRegister.Demo.get().createCriterion(new DemoTriggers(Optional.of(player), item));
//    }
//
//    public boolean matches(ItemStack stack) {
//        return this.item.matches(stack);
//    }
//
//    public void trigger(ServerPlayer player, ItemStack stack) {
//        this.trigger(player, triggerInstance -> triggerInstance.matches(stack));
//    }
//}
//
//public class DemoTrigger extends SimpleCriterionTrigger<DemoTrigger.ExampleTriggerInstance> {
//    @Override
//    public @NotNull Codec<ExampleTriggerInstance> codec() {
//        return ExampleTriggerInstance.CODEC;
//    }
//    // ...
//    public static class ExampleTriggerInstance implements SimpleCriterionTrigger.SimpleInstance {
//        public static final Codec<ExampleTriggerInstance> CODEC = RecordCodecBuilder.create(instance -> instance.group(
//                ExtraCodecs.strictOptionalField(EntityPredicate.ADVANCEMENT_CODEC, "player").forGetter(ExampleTriggerInstance::player),
//                ItemPredicate.CODEC.fieldOf("item").forGetter(ExampleTriggerInstance::item)
//        ).apply(instance, DemoTrigger::new));
//
//        public ExampleTriggerInstance() {
//            super();
//        }
//        private ItemPredicate item() {
//            return null;
//        }
//
//        @Override
//        public @NotNull Optional<ContextAwarePredicate> player() {
//            return Optional.empty();
//        }
//    }
//}