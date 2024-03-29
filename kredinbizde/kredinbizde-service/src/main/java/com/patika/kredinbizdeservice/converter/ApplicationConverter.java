package com.patika.kredinbizdeservice.converter;


import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationStatus;
import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationConverter {

    public Application toApplication(ApplicationRequest request, User user) {
        Application application = new Application();
        application.setUser(user);
        application.setLocalDateTime(LocalDateTime.now());
        application.setApplicationStatus(com.patika.kredinbizdeservice.enums.ApplicationStatus.INITIAL);
        return application;
    }

    public ApplicationResponse toResponse(Application application) {
        return ApplicationResponse.builder()
//                .userId(1L)
                .userId(application.getUser().getUserId())
                .createDate(application.getCreateDate())
                .applicationStatus(ApplicationStatus.INITIAL)
                .build();
    }

    public List<ApplicationResponse> toResponseList(List<Application> applications) {
        List<ApplicationResponse> applicationResponses = new ArrayList<>();

        applications.forEach(application -> {
            applicationResponses.add(toResponse(application));
        });

        return applicationResponses;
    }


}
