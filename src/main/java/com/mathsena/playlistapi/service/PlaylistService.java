package com.mathsena.playlistapi.service;

import com.mathsena.playlistapi.models.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<Playlist> getAllPlaylistNames();

    Mono<Playlist> getPlaylistNameById(String id);

    Mono<Playlist> createPlaylist(Playlist playlist);

}
