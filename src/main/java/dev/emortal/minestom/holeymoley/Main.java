package dev.emortal.minestom.holeymoley;

import dev.emortal.minestom.gamesdk.MinestomGameServer;
import dev.emortal.minestom.gamesdk.config.GameSdkConfig;
import dev.emortal.minestom.holeymoley.game.HoleyMoleyGame;
import dev.emortal.minestom.holeymoley.map.MapManager;
import io.github.togar2.pvp.MinestomPvP;
import net.minestom.server.MinecraftServer;

public final class Main {
    private static final int MIN_PLAYERS = 2;

    public static void main(String[] args) {
        MinestomGameServer.create((a) -> {
            MinestomPvP.init();
            MinecraftServer.getConnectionManager().setPlayerProvider(PermissionCustomPlayer::new);

            MapManager mapManager = new MapManager();

            return GameSdkConfig.builder()
                    .minPlayers(MIN_PLAYERS)
                    .gameCreator(info -> new HoleyMoleyGame(info))
                    .build();
        });
    }
}