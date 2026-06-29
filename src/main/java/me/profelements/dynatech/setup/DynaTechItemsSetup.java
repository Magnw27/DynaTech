// ... (bagian atas file sama) ...

    private static void registerMineralizedApiaries(MaterialHive hive, SlimefunAddon plugin) {
        for (String id : hive.slimefunItemsAccepted.getValue()) {
            SlimefunItem item = SlimefunItem.getById(id);

            if (item != null) {

                TypedKey<ItemWrapper> APIARY_KEY = TypedKey.create("dynatech",
                        id.replace("_INGOT", "").toLowerCase() + "mineralized_apiary");
                ItemWrapper APIARY = ItemWrapper.create(APIARY_KEY, new SlimefunItemStack(
                        APIARY_KEY.asSlimefunId(),
                        Material.BEEHIVE,
                        "&f" + item.getItemName().replace("锭", "") + "&f Mineralized Apiary",
                        "",
                        "&fLet the bees help you",
                        "&fproduce materials",
                        "",
                        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
                        LoreBuilder.powerBuffer(16384),
                        LoreBuilderDynamic.powerPerTick(1024)));

                Recipe APIARY_RECIPE = Recipe.init()
                        .setKey(APIARY_KEY.key())
                        .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                        .setInput(new ItemStack[] {
                                SlimefunItems.LARGE_CAPACITOR, item.getItem(), SlimefunItems.LARGE_CAPACITOR,
                                item.getItem(), Items.MATERIAL_HIVE.stack(), item.getItem(),
                                Items.MACHINE_SCRAP.stack(), Items.VEX_GEM.stack(), Items.MACHINE_SCRAP.stack(),
                        })
                        .setOutput(APIARY.stack())
                        .register();

                new MineralizedApiary(ItemGroups.HIVES, APIARY.stack(), APIARY_RECIPE.getRecipeType(),
                        APIARY_RECIPE.getInput(), item.getItem())
                        .setCapacity(16384)
                        .setConsumption(1024)
                        .setProcessingSpeed(1)
                        .register(plugin);
            }
        }

        for (String name : hive.vanillaItemsAccepted.getValue()) {
            ItemStack item = new ItemStack(Material.matchMaterial(name));
            TypedKey<ItemWrapper> APIARY_KEY = TypedKey.create("dynatech",
                    name.replace("_INGOT", "").toLowerCase() + "mineralized_apiary");

            ItemWrapper APIARY = ItemWrapper.create(APIARY_KEY, new SlimefunItemStack(APIARY_KEY.asSlimefunId(),
                    Material.BEEHIVE,
                    "&f" + ItemStackHelper.getName(item).replace("锭", "") + "&f Mineralized Apiary",
                    "",
                    "&fLet the bees help you",
                    "&fproduce materials",
                    "",
                    LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
                    LoreBuilder.powerBuffer(16384),
                    LoreBuilderDynamic.powerPerTick(1024)));

            Recipe APIARY_RECIPE = Recipe.init()
                    .setKey(APIARY_KEY.key())
                    .setRecipeType(RecipeType.ENHANCED_CRAFTING_TABLE)
                    .setInput(new ItemStack[] {
                            SlimefunItems.LARGE_CAPACITOR, item, SlimefunItems.LARGE_CAPACITOR,
                            item, Items.MATERIAL_HIVE.stack(), item,
                            Items.MACHINE_SCRAP.stack(), Items.VEX_GEM.stack(), Items.MACHINE_SCRAP.stack(),
                    })
                    .setOutput(APIARY.stack())
                    .register();

            new MineralizedApiary(ItemGroups.HIVES, APIARY.stack(), APIARY_RECIPE.getRecipeType(),
                    APIARY_RECIPE.getInput(), item)
                    .setCapacity(16384)
                    .setConsumption(1024)
                    .setProcessingSpeed(1)
                    .register(plugin);
        }

    }
}
