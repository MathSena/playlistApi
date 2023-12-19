package com.mathsena.playlistapi.service;

import com.mathsena.playlistapi.models.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;



public class PlaylistHandler {


    PlaylistService playlistService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.getAllPlaylistNames(), Playlist.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.getPlaylistNameById(id), Playlist.class);
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<Playlist> playlist = request.bodyToMono(Playlist.class);
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(playlist.flatMap(playlistService::createPlaylist), Playlist.class);
    }


}
