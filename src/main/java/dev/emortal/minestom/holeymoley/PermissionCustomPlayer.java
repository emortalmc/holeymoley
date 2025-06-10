package dev.emortal.minestom.holeymoley;

import dev.emortal.minestom.core.module.core.playerprovider.EmortalPlayer;
import dev.emortal.minestom.core.module.permissions.Permission;
import io.github.togar2.pvp.player.CombatPlayerImpl;
import net.minestom.server.network.player.GameProfile;
import net.minestom.server.network.player.PlayerConnection;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Fixes issues with MinestomPVP
 */
public final class PermissionCustomPlayer extends CombatPlayerImpl implements EmortalPlayer {
    private final @NotNull Set<Permission> permissions = new CopyOnWriteArraySet<>();

    public PermissionCustomPlayer(@NotNull PlayerConnection connection, @NotNull GameProfile gameProfile) {
        super(connection, gameProfile);
    }

    @Override
    public @NotNull Set<Permission> getPermissions() {
        return permissions;
    }
}
