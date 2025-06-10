package dev.emortal.minestom.holeymoley.entity;

import net.minestom.server.entity.Entity;
import net.minestom.server.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public final class NoPhysicsEntity extends Entity {

    public NoPhysicsEntity(@NotNull EntityType type) {
        super(type);

        super.setNoGravity(true);
        super.hasPhysics = false;
    }
}
