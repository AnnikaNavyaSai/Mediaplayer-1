package com.cg.MediaPlayerApplication.service;

import java.util.List;
import com.cg.MediaPlayerApplication.entity.Description;

public interface DescriptionService {
    String addNewDescriptionService(Description d, int videoId);
    Description updateDescriptionService(Description d, int desId);
    List<Description> searchDescriptionBytitle(String title);
    List<Description> getlistAllDescriptionsService();
    Description getByVideoId(int videoId);
    List<Description> searchDescriptionBylanguage(String language);
}