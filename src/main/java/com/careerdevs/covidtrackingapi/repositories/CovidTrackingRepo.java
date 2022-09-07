package com.careerdevs.covidtrackingapi.repositories;

import com.careerdevs.covidtrackingapi.models.CovidTrackingReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CovidTrackingRepo  extends JpaRepository<CovidTrackingReport,Long> {
}
