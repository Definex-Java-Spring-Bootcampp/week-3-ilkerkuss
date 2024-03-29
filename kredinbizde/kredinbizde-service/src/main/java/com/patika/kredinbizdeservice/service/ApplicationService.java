package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.client.AkbankServiceClient;
import com.patika.kredinbizdeservice.client.GarantiServiceClient;
import com.patika.kredinbizdeservice.client.dto.request.AkbankApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.request.GarantiApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.converter.ApplicationConverter;
import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {

    private ApplicationRepository applicationRepository = new ApplicationRepository();
    private final ApplicationConverter applicationConverter;
    private final UserService userService;
    private final AkbankServiceClient akbankServiceClient;

    private final GarantiServiceClient garantiServiceClient;


    public Application createApplication(ApplicationRequest request) {

        User user = userService.getByEmail(request.getEmail());
//        User user = userService.getById(request.getUserId());
        log.info("User Sistemde Bulundu.");

        Application application = applicationConverter.toApplication(request, user);

        Application savedApplication = applicationRepository.save(application);

        if (request.getBankName().equals("Akbank")) {

            ApplicationResponse akbankApplicationResponse = akbankServiceClient.createApplication(prepareAkbankApplicationRequest(user));
            log.info("Kayıt için Akbank Servisine Yönlendiriliyor...");

        } else if (request.getBankName().equals("Garanti")) {

            ApplicationResponse garantiApplicationResponse = garantiServiceClient.createApplication(prepareGarantiApplicationRequest(user));
            log.info("Kayıt için Akbank Servisine Yönlendiriliyor...");

        } else {

            System.out.println("BANKA SERVİSLERİNE APPLICATION GÖNDERİLMEDİ.");
        }

        return savedApplication;
    }

    private AkbankApplicationRequest prepareAkbankApplicationRequest(User user) {
        AkbankApplicationRequest applicationRequest = new AkbankApplicationRequest();
        log.info("Akbank için Application Requesti Hazırlanıyor...");

        applicationRequest.setUserId(user.getUserId());
//        applicationRequest.setUserId(1L);

        return applicationRequest;
    }

    private GarantiApplicationRequest prepareGarantiApplicationRequest(User user) {
        GarantiApplicationRequest applicationRequest = new GarantiApplicationRequest();
        log.info("Garanti için Application Requesti Hazırlanıyor...");

        applicationRequest.setUserId(user.getUserId());
//        applicationRequest.setUserId(1L);

        return applicationRequest;
    }

    public List<ApplicationResponse> getAll() {
        List<Application> applications = applicationRepository.getAll();

        return applicationConverter.toResponseList(applications);
    }


    public List<ApplicationResponse> getAllByUserId(Long userId) {
        List<Application> applicationsById = applicationRepository.getAllByUserId(userId);

        return applicationConverter.toResponseList(applicationsById);
    }
}
