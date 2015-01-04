/*
 * Copyright (C) 2015 Codelanx, All Rights Reserved
 *
 * This work is licensed under a Creative Commons
 * Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 *
 * This program is protected software: You are free to distrubute your
 * own use of this software under the terms of the Creative Commons BY-NC-ND
 * license as published by Creative Commons in the year 2015 or as published
 * by a later date. You may not provide the source files or provide a means
 * of running the software outside of those licensed to use it.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the Creative Commons BY-NC-ND license
 * long with this program. If not, see <https://creativecommons.org/licenses/>.
 */
package com.codelanx.minigamelib.game;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class description for {@link GameManager}
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 * 
 * @param <G> The subtype of the Game to be used for this Manager
 */
public class GameManager<G extends Game> {

    private final Map<?, G> games = new HashMap<>();

    public List<? extends Game> query(Predicate<? super Game> filter) {
        return this.games.values().stream().filter(filter).collect(Collectors.toList());
    }

    public Game find(Predicate<? super Game> filter) {
        Optional<? extends Game> opt = this.games.values().stream().filter(filter).findFirst();
        return opt.isPresent() ? opt.get() : null;
    }

    public Collection<? extends Game> getGames() {
        return Collections.unmodifiableCollection(this.games.values());
    }
}
