package dev.emortal.minestom.holeymoley.map;

import io.github.togar2.pvp.feature.CombatFeatures;
import io.github.togar2.pvp.feature.FeatureType;
import net.kyori.adventure.key.Key;
import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.instance.block.Block;
import net.minestom.server.registry.RegistryKey;
import net.minestom.server.world.DimensionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MapManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapManager.class);

    private static final DimensionType DIMENSION_TYPE = DimensionType.builder()
            .hasSkylight(true)
            .ambientLight(0.3f)
            .build();

    private static RegistryKey<DimensionType> DIMENSION_KEY;

    public MapManager() {
        if (DIMENSION_KEY == null) {
            DIMENSION_KEY = MinecraftServer.getDimensionTypeRegistry().register(Key.key("emortalmc:holeymoley"), DIMENSION_TYPE);
        }
    }

    public static InstanceContainer createMap(int radius) {
        InstanceContainer instance = MinecraftServer.getInstanceManager().createInstanceContainer(DIMENSION_KEY);
        instance.setTime(0);
        instance.setTimeRate(0);
        instance.setTimeSynchronizationTicks(0);
        instance.setExplosionSupplier(CombatFeatures.modernVanilla().get(FeatureType.EXPLOSION).getExplosionSupplier());

        // Generate a big cube of dirt surrounded by bedrock
        instance.setGenerator(unit -> {
            unit.modifier().setAll((x, y, z) -> {
                if (y < -radius || y > radius) return Block.AIR;
                if (x < -radius || x > radius) return Block.AIR;
                if (z < -radius || z > radius) return Block.AIR;

                if (y == -radius || y == radius) return Block.BEDROCK;
                if (x == -radius || x == radius) return Block.BEDROCK;
                if (z == -radius || z == radius) return Block.BEDROCK;

                return Block.DIRT;
            });
        });

        return instance;
    }

}
