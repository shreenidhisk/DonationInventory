package com.digitalaidseattle.techEval.services;

import com.digitalaidseattle.techEval.models.Distribution;
import com.digitalaidseattle.techEval.models.Donation;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    private final DonationService donationService;

    public ReportService(DonationService donationService) {
        this.donationService = donationService;
    }

    public Map<String, Integer> getInventoryReport() {
        Map<String, Integer> inventory = new HashMap<>();

        List<Donation> donations = donationService.getAllDonations();
        List<Distribution> distributions = donationService.getAllDistributions();

        for (Donation d : donations) {
            inventory.put(d.getType(), inventory.getOrDefault(d.getType(), 0) + d.getQuantity());
        }

        for (Distribution dist : distributions) {
            inventory.put(dist.getType(), inventory.getOrDefault(dist.getType(), 0) - dist.getQuantity());
        }

        return inventory;
    }

    public Map<String, Integer> getDonorReport() {
        Map<String, Integer> donorSummary = new HashMap<>();

        List<Donation> donations = donationService.getAllDonations();
        for (Donation d : donations) {
            donorSummary.put(d.getDonor(), donorSummary.getOrDefault(d.getDonor(), 0) + d.getQuantity());
        }

        return donorSummary;
    }
}