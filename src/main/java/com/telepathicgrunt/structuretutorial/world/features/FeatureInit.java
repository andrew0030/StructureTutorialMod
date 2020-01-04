package com.telepathicgrunt.structuretutorial.world.features;

import java.util.Locale;

import com.telepathicgrunt.structuretutorial.StructureTutorialMain;
import com.telepathicgrunt.structuretutorial.world.features.structures.RunDownHousePieces;
import com.telepathicgrunt.structuretutorial.world.features.structures.RunDownHouseStructure;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;


public class FeatureInit
{
	//Static instance of our structure so we can reference it and add it to biomes easily.
	public static Structure<NoFeatureConfig> RUN_DOWN_HOUSE = new RunDownHouseStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType RDHP;


	/*
	 * Registers the features and structures. Normal Features will be registered here too.
	 */
	@SuppressWarnings("unchecked")
	public static void registerFeatures(Register<Feature<?>> event)
	{
		IForgeRegistry<Feature<?>> registry = event.getRegistry();

		//Registers the structure itself and sets what its path is. In this case,
		//the structure will have the resourcelocation of structure_tutorial:run_down_house .
		//
		//Also, the path string you give will be what the user will see when they do the
		//locate command.
		RUN_DOWN_HOUSE = (Structure<NoFeatureConfig>) StructureTutorialMain.register(registry, RUN_DOWN_HOUSE, "run_down_house");
		RDHP = register(RunDownHousePieces.Piece::new, "RDHP");
	}


	/*
	 * Registers the structures pieces themselves. If you don't do this part, Forge will complain to you in the Console.
	 */
	static IStructurePieceType register(IStructurePieceType p_214750_0_, String key)
	{
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), p_214750_0_);
	}
}
