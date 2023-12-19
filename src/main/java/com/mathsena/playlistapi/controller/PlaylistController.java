package com.mathsena.playlistapi.controller;

import com.mathsena.playlistapi.models.Playlist;
import com.mathsena.playlistapi.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/playlists")
    public Flux<Playlist> getPlaylistNames() {
        return playlistService.getAllPlaylistNames();
    }

    @GetMapping("/playlists/{id}")
    public Mono<Playlist> getPlaylistNameById(@PathVariable String id) {
        return playlistService.getPlaylistNameById(id);
    }

    @PostMapping("/playlists")
    public Mono<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @GetMapping(value = "/playlists/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistNamesByEvents() {
        Flux<Long> interval = Flux.interval(java.time.Duration.ofSeconds(2));
        Flux<Playlist> events = playlistService.getAllPlaylistNames();
        System.out.println("Here");
        return Flux.zip(interval, events);
    }
}
