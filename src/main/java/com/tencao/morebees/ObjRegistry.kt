package com.tencao.morebees

import com.tencao.morebees.bees.BeeSpecies
import com.tencao.morebees.blocks.BlockHive
import com.tencao.morebees.events.GameRegistry
import com.tencao.morebees.hives.HiveDescription
import com.tencao.morebees.hives.HiveTypes
import com.tencao.morebees.items.BasicItem
import com.tencao.morebees.items.ItemFrame
import forestry.api.apiculture.EnumBeeChromosome
import forestry.api.apiculture.FlowerManager
import forestry.api.apiculture.IAlleleBeeEffect
import forestry.api.core.Tabs
import forestry.api.genetics.AlleleManager
import forestry.api.genetics.IAlleleFlowers
import forestry.apiculture.ModuleApiculture
import forestry.apiculture.flowers.FlowerRegistry
import forestry.apiculture.genetics.BeeDefinition
import forestry.apiculture.genetics.HiveDrop
import forestry.apiculture.genetics.alleles.AlleleEffectPotion
import forestry.apiculture.items.EnumHoneyComb
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.init.MobEffects
import net.minecraft.item.ItemStack
import net.minecraftforge.oredict.OreDictionary

object ObjRegistry {
    val FlowerOre = "Ore"
    val FlowerRedstone = "Redstone"
    val FlowerUranium = "Uranium"
    val FlowerWater = "Water"
    val FlowerTNT = "TNT"
    val FlowerType = "flowers"
    val FlowerSlime = "Slime"
    val FlowerDiamond = "Diamond"
    val FlowerEmerald = "Emerald"
    lateinit var effectWither: IAlleleBeeEffect
    lateinit var effectRadiation: IAlleleBeeEffect
    lateinit var effectSlimy: IAlleleBeeEffect
    lateinit var FlowerTypeOre: IAlleleFlowers

    lateinit var FlowerTypeRedstone: IAlleleFlowers
    lateinit var FlowerTypeDiamond: IAlleleFlowers
    lateinit var FlowerTypeEmerald: IAlleleFlowers
    lateinit var FlowerTypeUranium: IAlleleFlowers
    lateinit var FlowerTypeWater: IAlleleFlowers
    lateinit var FlowerTypeTNT: IAlleleFlowers
    lateinit var FlowerTypeSlime: IAlleleFlowers
    val hive: BlockHive = BlockHive("hive")

    val CombRock: BasicItem = BasicItem("CombRock").setCreativeTab(Tabs.tabApiculture)
    val CombDirt: BasicItem = BasicItem("CombDirt").setCreativeTab(Tabs.tabApiculture)
    val CombWither: BasicItem = BasicItem("CombWither").setCreativeTab(Tabs.tabApiculture)
    val CombSlime: BasicItem = BasicItem("CombSlime").setCreativeTab(Tabs.tabApiculture)
    val CombMetallic: BasicItem = BasicItem("CombMetallic").setCreativeTab(Tabs.tabApiculture)
    val CombCrystal: BasicItem = BasicItem("CombCrystal").setCreativeTab(Tabs.tabApiculture)
    val DiamondFrag: BasicItem = BasicItem("diamondFragment").setCreativeTab(Tabs.tabApiculture)
    val EmeraldFrag: BasicItem = BasicItem("emeraldFragment").setCreativeTab(Tabs.tabApiculture)
    val NetherFrag: BasicItem = BasicItem("nether_starFragment").setCreativeTab(Tabs.tabApiculture).setEffect(true) as BasicItem
    val PropolisMetallic: BasicItem = BasicItem("propolisMetallic").setCreativeTab(Tabs.tabApiculture)
    val PropolisCrystal: BasicItem = BasicItem("propolisCrystal").setCreativeTab(Tabs.tabApiculture)
    val GrainsMetallic: BasicItem = BasicItem("grainMetallic").setCreativeTab(Tabs.tabApiculture)
    val GrainsCrystal: BasicItem = BasicItem("grainCrystal").setCreativeTab(Tabs.tabApiculture)

    //ore dic items
    val DustIron: BasicItem = BasicItem("dustIron").setCreativeTab(CreativeTabs.MATERIALS)
    val DustCopper: BasicItem = BasicItem("dustCopper").setCreativeTab(CreativeTabs.MATERIALS)
    val DustTin: BasicItem = BasicItem("dustTin").setCreativeTab(CreativeTabs.MATERIALS)
    val DustGold: BasicItem = BasicItem("dustGold").setCreativeTab(CreativeTabs.MATERIALS)
    val DustSilver: BasicItem = BasicItem("dustSilver").setCreativeTab(CreativeTabs.MATERIALS)
    val DustLead: BasicItem = BasicItem("dustLead").setCreativeTab(CreativeTabs.MATERIALS)
    val DustAluminium: BasicItem = BasicItem("dustAluminium").setCreativeTab(CreativeTabs.MATERIALS)
    val DustNickel: BasicItem = BasicItem("dustNickel").setCreativeTab(CreativeTabs.MATERIALS)
    val DustPlatinum: BasicItem = BasicItem("dustPlatinum").setCreativeTab(CreativeTabs.MATERIALS)
    val DustIridium: BasicItem = BasicItem("dustIridium").setCreativeTab(CreativeTabs.MATERIALS)

    var MBISilver = false
    var MBILead = false
    var MBIAluminium = false
    var MBINickel = false
    var MBIPlatinum = false
    var MBIIridium = false

    //frames
    val frameSweet: ItemFrame = ItemFrame(120, 1.1f, 2.5f, 1.0f, 0.5f, "frameSweet")
    val frameCooled: ItemFrame = ItemFrame(300, 2.0f, 3.5f, 0.8f, 0.25f, "frameCooled")
    val frameMutating: ItemFrame = ItemFrame(240, 1.5f, 0.9f, 1.0f, 3.0f, "frameMutating")

    fun registerAll(){
        registerItems()
        registerGenes()
        registerFlowers()
    }

    fun registerBlocks() {
        GameRegistry.registerBlock(hive)
    }

    fun registerItems() {

        if (Config.general.enableFrames) {
            GameRegistry.register(frameSweet)
            GameRegistry.register(frameCooled)
            GameRegistry.register(frameMutating)
        }
        GameRegistry.registerOreItem(CombRock, "beeComb")
        GameRegistry.registerOreItem(CombDirt, "beeComb")
        GameRegistry.registerOreItem(CombWither, "beeComb")
        GameRegistry.registerOreItem(CombSlime, "beeComb")
        GameRegistry.registerOreItem(CombMetallic, "beeComb")
        GameRegistry.registerOreItem(CombCrystal, "beeComb")

        GameRegistry.registerOreItem(DiamondFrag, "nuggetDiamond")
        GameRegistry.registerOreItem(EmeraldFrag, "nuggetEmerald")
        GameRegistry.register(NetherFrag)

        GameRegistry.register(PropolisMetallic)
        GameRegistry.register(PropolisCrystal)
        GameRegistry.register(GrainsMetallic)
        GameRegistry.register(GrainsCrystal)

        GameRegistry.registerOreItem(DustIron, "dustIron")
        GameRegistry.registerOreItem(DustCopper, "dustCopper")
        GameRegistry.registerOreItem(DustTin, "dustTin")
        GameRegistry.registerOreItem(DustGold, "dustGold")
        //addon ore dic items
        if (OreDictionary.getOres("dustLead").isNotEmpty()) {
            GameRegistry.registerOreItem(DustLead, "dustLead")
            MBILead = true
        }
        if (OreDictionary.getOres("dustSilver").isNotEmpty()) {
            GameRegistry.registerOreItem(DustSilver, "dustSilver")
            MBISilver = true
        }
        if (OreDictionary.getOres("dustAluminum").isNotEmpty()) {
            GameRegistry.registerOreItem(DustAluminium, "dustAluminum")
            MBIAluminium = true
        }
        if (OreDictionary.getOres("dustNickel").isNotEmpty()) {
            GameRegistry.registerOreItem(DustNickel, "dustNickel")
            MBINickel = true
        }
        if (OreDictionary.getOres("dustPlatinum").isNotEmpty()) {
             GameRegistry.registerOreItem(DustPlatinum, "dustPlatinum")
            MBIPlatinum = true
        }
        if (OreDictionary.getOres("dustIridium").isNotEmpty()) {
            GameRegistry.registerOreItem(DustIridium, "dustIridium")
            MBIIridium = true
        }

    }

    fun registerFlowers() {
        val flowerRegistry = FlowerManager.flowerRegistry as FlowerRegistry
        flowerRegistry.registerAcceptableFlower(Blocks.COAL_ORE, FlowerOre)
        flowerRegistry.registerAcceptableFlower(Blocks.IRON_ORE, FlowerOre)
        flowerRegistry.registerAcceptableFlower(Blocks.REDSTONE_ORE, FlowerRedstone)
        flowerRegistry.registerAcceptableFlower(Blocks.REDSTONE_BLOCK, FlowerRedstone)
        flowerRegistry.registerAcceptableFlower(Blocks.DIAMOND_ORE, FlowerDiamond)
        flowerRegistry.registerAcceptableFlower(Blocks.DIAMOND_BLOCK, FlowerDiamond)
        flowerRegistry.registerAcceptableFlower(Blocks.EMERALD_ORE, FlowerEmerald)
        flowerRegistry.registerAcceptableFlower(Blocks.EMERALD_BLOCK, FlowerEmerald)
        flowerRegistry.registerAcceptableFlower(Blocks.WATERLILY, FlowerWater)
        flowerRegistry.registerAcceptableFlower(Blocks.TNT, FlowerTNT)
        flowerRegistry.registerAcceptableFlower(Blocks.SLIME_BLOCK, FlowerSlime)
        OreDictionary.getOres("oreCopper").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerOre) }
        OreDictionary.getOres("oreTin").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerOre) }
        OreDictionary.getOres("blockSlime").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerSlime) }
        OreDictionary.getOres("oreUranium").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerUranium) }
        OreDictionary.getOres("oreResonating").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerUranium) }
        OreDictionary.getOres("oreYellorite").forEach { flowerRegistry.registerAcceptableFlower(Block.getBlockFromItem(it.item), FlowerUranium) }
        flowerRegistry.registerAcceptableFlower(Blocks.CHORUS_FLOWER, FlowerManager.FlowerTypeEnd)
    }

    fun registerGenes() {
        FlowerTypeOre = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerOre, Flowers.ORE.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeRedstone = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerRedstone, Flowers.REDSTONE.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeDiamond = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerDiamond, Flowers.DIAMOND.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeEmerald = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerEmerald, Flowers.EMERALD.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeWater = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerWater, Flowers.WATER.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeTNT = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerTNT, Flowers.TNT.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeUranium = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerUranium, Flowers.URANIUM.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        FlowerTypeSlime = AlleleManager.alleleFactory.createFlowers(MBCore.MODID, FlowerType, FlowerSlime, Flowers.SLIME.value, true, EnumBeeChromosome.FLOWER_PROVIDER)
        effectWither = AlleleEffectPotion("Wither", true, MobEffects.WITHER, 400)
        AlleleManager.alleleRegistry.registerAllele(effectWither, EnumBeeChromosome.EFFECT)
        effectRadiation = AlleleEffectPotion("Radiation", true, MobEffects.HUNGER, 400)
        AlleleManager.alleleRegistry.registerAllele(effectRadiation, EnumBeeChromosome.EFFECT)
        effectSlimy = AlleleEffectPotion("Slimy", true, MobEffects.JUMP_BOOST, 400)
        AlleleManager.alleleRegistry.registerAllele(effectSlimy, EnumBeeChromosome.EFFECT)
    }

    fun registerHives() {
        if (Config.worldGen.genHives) {
            ModuleApiculture.getHiveRegistry().registerHive(HiveTypes.ROCK.hiveUid, HiveDescription.ROCK)
            val honeyComb = ModuleApiculture.getItems().beeComb.get(EnumHoneyComb.HONEY, 1)
            val rockComb = ItemStack(CombRock)
            ModuleApiculture.getHiveRegistry().addDrops(HiveTypes.ROCK.hiveUid, HiveDrop(0.8, BeeSpecies.ROCK, rockComb).setIgnobleShare(0.7),
                    HiveDrop(0.03, BeeDefinition.VALIANT, honeyComb))
        }

    }
}