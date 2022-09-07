package com.careerdevs.covidtrackingapi.models;

import java.util.List;

public class CovidTrackingRegionalDataByCountry<data> {

    private boolean success;

    private String data;

    public CovidTrackingRegionalDataByCountry() {
    }

    public CovidTrackingRegionalDataByCountry( String countryName ,boolean success, List<data> data) {
        this.success = success;
        this.data = String.valueOf(data);
        this.data = countryName;
    }

    private  static class data {

        private String regionName;
        private int caseCount;
        private int recoveredCount ;
        private int deceasedCount ;
        private  String regionFlagUrl;

        public data(String regionName, int caseCount, int recoveredCount, int deceasedCount, String regionFlagUrl) {
            this.regionName = regionName;
            this.caseCount = caseCount;
            this.recoveredCount = recoveredCount;
            this.deceasedCount = deceasedCount;
            this.regionFlagUrl = regionFlagUrl;
        }

        public String getRegionName() {
            return regionName;
        }

        public int getCaseCount() {
            return caseCount;
        }

        public int getRecoveredCount() {
            return recoveredCount;
        }

        public int getDeceasedCount() {
            return deceasedCount;
        }

        public String getRegionFlagUrl() {
            return regionFlagUrl;
        }

        public  data() {

        }
    }


}
