package com.digitalaidseattle.techEval.controller;

import com.digitalaidseattle.techEval.models.Distribution;
import com.digitalaidseattle.techEval.models.Donation;
import com.digitalaidseattle.techEval.services.DonationService;
import com.digitalaidseattle.techEval.services.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/donations")
public class DonationController {
    private final DonationService donationService;
    private final ReportService reportService;

    public DonationController(DonationService donationService, ReportService reportService) {
        this.donationService = donationService;
        this.reportService = reportService;
    }

    @PostMapping("/register")
    public Donation registerDonation(@RequestBody Donation donation) {
        return donationService.registerDonation(donation);
    }

    @PostMapping("/distribute")
    public Distribution distribute(@RequestBody Distribution distribution) {
        return donationService.recordDistribution(distribution);
    }

    @GetMapping("/reports/inventory")
    public Map<String, Integer> getInventoryReport() {
        return reportService.getInventoryReport();
    }

    @GetMapping("/reports/donors")
    public Map<String, Integer> getDonorReport() {
        return reportService.getDonorReport();
    }

    @GetMapping("/all")
    public List<Donation> getAllDonations() {
        return donationService.getAllDonations();
    }
}
