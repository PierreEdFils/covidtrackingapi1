package com.careerdevs.covidtrackingapi.controllers;


import com.careerdevs.covidtrackingapi.models.CovidTracking;
import com.careerdevs.covidtrackingapi.models.CovidTrackingGlobalData;
import com.careerdevs.covidtrackingapi.models.CovidTrackingRegionalDataByCountry;
import com.careerdevs.covidtrackingapi.models.CovidTrackingReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/api/covid")
public class CovidTrackingController {


//    private Environment env;

    private final String BASE_URL ="https://www.cyberpurge.com/api/covid/";
    @Value("${CV_API_KEY}")
    private String apiKey;


//  Get country name for its equivalent ISO Alpha-2 code
//  GET/api/covid/countryNameByCode/:code


    @GetMapping("/country/{countryName}")
    public ResponseEntity<?> getCovidTrackingByCountries (RestTemplate restTemplate, @PathVariable String countryName) {

//        System.out.println(countryName);
        try{
//            String apiKey = env.getProperty("CV_API_KEY");
//            countryName = "QA";
            String queryString =  "countryNameByCode/" + countryName;
            String covidTrackingURL = BASE_URL + queryString;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
                final HttpHeaders headers = new HttpHeaders();
                 headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
                final HttpEntity<String> entity = new HttpEntity<String>(headers);

                //Execute the method writing your HttpEntity to the request
                ResponseEntity<CovidTracking> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity,CovidTracking.class);

//                CovidTrackingReport report = new CovidTrackingReport()

            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }

//    Get the list of countries with Name & ISO Alpha-2
//    GET/api/covid/countries
//
//      @GetMapping ("/countries")
//      public List<Countries> getAllCountries () {
//        return  countryService.getAllCountries();
//      }
    @GetMapping("/countries")

    public ResponseEntity<?> getCovidTrackingListAllCountries (RestTemplate restTemplate) {

        try{
//            String apiKey = env.getProperty("CV_API_KEY");



            String covidTrackingURL = BASE_URL + "/countries" ;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }



    }

//    Get case counts categorized under Total, Recovered,
//    and Deceased for a country by its ISO Alpha-2 Code
//    GET/api/covid/dailyTotals/:code


    @GetMapping("/dailyTotals/{countryName}")
    public ResponseEntity<?> getCovidTrackingByDailyTotals (RestTemplate restTemplate, @PathVariable String countryName) {

        try{
//            String apiKey = env.getProperty("CV_API_KEY");

            String queryString =  "/dailyTotals/" + countryName ;
            String covidTrackingURL = BASE_URL + queryString ;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }

//   # Get global case counts only
//   GET /api/covid/globalCases



    @GetMapping("/globalCases")
    public ResponseEntity<?> getCovidTrackingByDailyTotalsGlobal (RestTemplate restTemplate) {

        try{
//            String apiKey = env.getProperty("CV_API_KEY");


            String covidTrackingURL = BASE_URL + "/globalCases";
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }

//    # Get global case counts categorized under Total, Recovered, and Deceased
//    GET /api/covid/globalData

    @GetMapping("/globalData")
    public ResponseEntity<?> getCovidTrackingByDailyTotalsGlobalData (RestTemplate restTemplate) {

        try{
//            String apiKey = env.getProperty("CV_API_KEY");


            String covidTrackingURL = BASE_URL + "/globalData";
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<CovidTrackingGlobalData> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, CovidTrackingGlobalData.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }
//    Get Total case counts for the last 7 days for a country by its ISO Alpha-2 Code
//    GET/api/covid/weeklyRegionalTotalCases/:code


    @GetMapping("/weeklyRegionalTotalCases/{countryName}")
    public ResponseEntity<?> getCovidTrackingByWeeklyRegionalTotalCases (RestTemplate restTemplate, @PathVariable String countryName) {

        try{
//            String apiKey = env.getProperty("CV_API_KEY");

            String queryString =  "weeklyRegionalTotalCases/" + countryName;
            String covidTrackingURL = BASE_URL + queryString;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }


    public ResponseEntity<?> getCovidTrackingGlobalCases(RestTemplate restTemplate) {

        try{
//            String apiKey = env.getProperty("CV_API_KEY");



            String covidTrackingURL = BASE_URL + "/countries" ;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }



    }

//    Get Recovered case counts for the last 7 days for a country by its ISO Alpha-2 Code
//    GET/api/covid/weeklyRegionalRecoverdCases/:code


    @GetMapping("/weeklyRegionalRecoverdCases/{countryName}")
    public ResponseEntity<?> getCovidTrackingByWeeklyRegionalRecoverdCases (RestTemplate restTemplate, @PathVariable String countryName) {

        try{
//            String apiKey = env.getProperty("CV_API_KEY");

            String queryString =  "weeklyRegionalRecoverdCases/" + countryName;
            String covidTrackingURL = BASE_URL + queryString;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }

//    Get Deceased case counts for the last 7 days for a country by its ISO Alpha-2 Code
//    GET/api/covid/weeklyRegionalDeceasedCases/:code



    @GetMapping("/weeklyRegionalDeceasedCases/{countryName}")
    public ResponseEntity<?> getCovidTrackingByWeeklyRegionalDeceasedCases (RestTemplate restTemplate, @PathVariable String countryName) {

        try{

            String queryString =  "weeklyRegionalDeceasedCases/" + countryName;
            String covidTrackingURL = BASE_URL + queryString;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<String> response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, String.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }

//    Get regional case counts categorized under Total, Recovered,
//    and Deceased for a country its ISO Alpha-2 Code
//    GET/api/covid/regionalDataByCountry/:code


    @GetMapping("/regionalDataByCountry/{countryName}")
    public ResponseEntity<?> getCovidTrackingByRegionalDataByCountry (RestTemplate restTemplate, @PathVariable String countryName) {

        try{
//            String apiKey = env.getProperty("CV_API_KEY");

            String queryString =  "regionalDataByCountry/" + countryName;
            String covidTrackingURL = BASE_URL + queryString;
            System.out.println(covidTrackingURL);

            //Set the headers you need send
            final HttpHeaders headers = new HttpHeaders();
            headers.set("X-Authorization", apiKey);

            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(headers);

            //Execute the method writing your HttpEntity to the request
            ResponseEntity<CovidTrackingRegionalDataByCountry>  response = restTemplate.exchange(covidTrackingURL, HttpMethod.GET, entity, CovidTrackingRegionalDataByCountry.class);


            return ResponseEntity.ok(response.getBody());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }


    }

}
