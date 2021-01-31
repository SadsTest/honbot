package ru.hon.honbot.listener;

import discord4j.core.event.domain.Event;
import reactor.core.publisher.Mono;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public interface EventListener<T extends Event> {

    Class<T> getEventType();
    Mono<Void> execute(T event);

    default Mono<Void> handleError(Throwable error) {
        return Mono.empty();
    }
}
