package com.careerdevs.covidtrackingapi.models;

import java.util.List;

public class CovidTrackingGlobalData {

    private boolean success;

    private List<data> data ;

    public CovidTrackingGlobalData() {
    }

    public CovidTrackingGlobalData(boolean success, List<CovidTrackingGlobalData.data> data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<data>  getData() {
        return data;
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
