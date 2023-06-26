package com.cg.mediaplayer;

import com.cg.mediaplayer.entites.Media;
import com.cg.mediaplayer.exception.IdNotFoundException;
import com.cg.mediaplayer.repository.MediaRepository;
import com.cg.mediaplayer.service.MediaService;
import com.cg.mediaplayer.serviceimpl.MediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MediaPlayerApplicationTests {
    @Mock
    private MediaRepository mediaRepository;

    @InjectMocks
    private MediaService mediaService = new MediaServiceImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddLike() {
        Media media = new Media();
        media.setLikes(0);

        mediaService.addLike(media);

        assertEquals(1, media.getLikes());
        verify(mediaRepository, times(1)).save(media);
    }

    @Test
    void testAddDislike() {
        Media media = new Media();
        media.setDislikes(0);

        mediaService.addDislike(media);

        assertEquals(1, media.getDislikes());
        verify(mediaRepository, times(1)).save(media);
    }

    @Test
    void testGetTotalLikes_WithExistingVideoId() {
        int videoId = 1;

        List<Media> mediaList = new ArrayList<>();
        Media media1 = new Media();
        media1.setLikes(5);
        mediaList.add(media1);
        Media media2 = new Media();
        media2.setLikes(3);
        mediaList.add(media2);

        when(mediaRepository.findByVideoId(videoId)).thenReturn(mediaList);

        int totalLikes = mediaService.getTotalLikes(videoId);

        assertEquals(8, totalLikes);
        verify(mediaRepository, times(1)).findByVideoId(videoId);
    }

    @Test
    void testGetTotalLikes_WithNonExistingVideoId() {
        int videoId = 1;

        when(mediaRepository.findByVideoId(videoId)).thenReturn(new ArrayList<>());

        assertThrows(IdNotFoundException.class, () -> mediaService.getTotalLikes(videoId));
        verify(mediaRepository, times(1)).findByVideoId(videoId);
    }

    @Test
    void testGetTotalDislikes_WithExistingVideoId() {
        int videoId = 1;

        List<Media> mediaList = new ArrayList<>();
        Media media1 = new Media();
        media1.setDislikes(2);
        mediaList.add(media1);
        Media media2 = new Media();
        media2.setDislikes(4);
        mediaList.add(media2);

        when(mediaRepository.findByVideoId(videoId)).thenReturn(mediaList);

        int totalDislikes = mediaService.getTotalDislikes(videoId);

        assertEquals(6, totalDislikes);
        verify(mediaRepository, times(1)).findByVideoId(videoId);
    }

    @Test
    void testGetTotalDislikes_WithNonExistingVideoId() {
        int videoId = 1;

        when(mediaRepository.findByVideoId(videoId)).thenReturn(new ArrayList<>());

        assertThrows(IdNotFoundException.class, () -> mediaService.getTotalDislikes(videoId));
        verify(mediaRepository, times(1)).findByVideoId(videoId);
    }
    
    @Test
    void testRemoveLike_WithExistingVideoIdAndLikesGreaterThanZero() {
        int videoId = 1;

        List<Media> mediaList = new ArrayList<>();
        Media media = new Media();
        media.setLikes(5);
        mediaList.add(media);

        when(mediaRepository.findByVideoId(videoId)).thenReturn(mediaList);

        mediaService.removeLike(videoId);

        assertEquals(4, media.getLikes());
        verify(mediaRepository, times(1)).findByVideoId(videoId);
        verify(mediaRepository, times(1)).save(media);
    }


}
