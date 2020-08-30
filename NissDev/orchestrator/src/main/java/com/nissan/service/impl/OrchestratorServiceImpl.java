package com.nissan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nissan.constants.OrchestratorConstants;
import com.nissan.core.util.RestConfig;
import com.nissan.service.OrchestratorService;

@Service
@PropertySource("classpath:orchestrator.properties")
public class OrchestratorServiceImpl implements OrchestratorService {

    @Autowired
    private RestConfig restConfig;

    private static String access_token;

    @Value("${tenancy.name}")
    private String TENANCY_NAME;

    @Value("${username}")
    private String USERNAME;

    @Value("${password}")
    private String PASSWORD;

    @Override
    public String getSessionToken() {
//        JSONObject body = new JSONObject();
//        body.put(OrchestratorConstants.TENANCY_NAME.getValue(), "default");
//        body.put(OrchestratorConstants.USER_NAME.getValue(), "admin@defaulttenant.com");
//        body.put(OrchestratorConstants.PASSWORD.getValue(), "Admin@123");
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(OrchestratorConstants.CONTENT_TYPE_KEY.getValue(),OrchestratorConstants.CONTENT_TYPE_VALUE.getValue());
//        HttpEntity<?> entity = new HttpEntity<String>(body.toString(), headers);
//        ResponseEntity<String> res = restConfig.getRestTemplate().exchange(OrchestratorConstants.SESSION_API_URL.getValue(), HttpMethod.POST, entity,
//                String.class);
//        JSONObject jsonObj = new JSONObject(res.getBody());
//        access_token = (String) jsonObj.get(OrchestratorConstants.RESULT_NODE.getValue());
//        return access_token;
    	return null;
    }

    @Override
    public String getAvailableBots() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(OrchestratorConstants.AUTHORIZATION_KEY.getValue(), "Bearer "+ getSessionToken());

        HttpEntity<?> entity = new HttpEntity<>(headers);
        //RestConfig config = new RestConfig();
        ResponseEntity<String> res = restConfig.getRestTemplate().exchange(
                OrchestratorConstants.AVAILABLE_BOTS_URL.getValue(), HttpMethod.GET, entity,
                String.class);
        return res.getBody();
    }

}
