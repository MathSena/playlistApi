package com.mathsena.playlistapi.repository;

import com.mathsena.playlistapi.models.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
