package com.mathsena.playlistapi.service;

import com.mathsena.playlistapi.models.Playlist;
import com.mathsena.playlistapi.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {


    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Flux<Playlist> getAllPlaylistNames() {
        return playlistRepository.findAll();
    }

    @Override
    public Mono<Playlist> getPlaylistNameById(String id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Mono<Playlist> createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }
}
