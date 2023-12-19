package com.mathsena.playlistapi;

import com.mathsena.playlistapi.models.Playlist;
import com.mathsena.playlistapi.repository.PlaylistRepository;
import org.springframework.boot.CommandLineRunner;
import reactor.core.publisher.Flux;

import java.util.UUID;

public class DummyData implements CommandLineRunner {

    private final PlaylistRepository playlistRepository;

    public DummyData(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        playlistRepository.deleteAll()
                .thenMany(
                        Flux.just("Beatles Favorites", "Rolling Stones Classics", "Led Zeppelin Rocks", "Queen's Greatest Hits", "AC/DC Anthems")
                                .map(name -> new Playlist(UUID.randomUUID()
                                        .toString(), name))
                                .flatMap(playlistRepository::save))
                .subscribe(System.out::println);


    }
}
