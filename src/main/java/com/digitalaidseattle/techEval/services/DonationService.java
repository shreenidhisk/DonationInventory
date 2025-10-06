package com.digitalaidseattle.techEval.services;

import com.digitalaidseattle.techEval.Repositories.DistributionRepository;
import com.digitalaidseattle.techEval.Repositories.DonationRepository;
import com.digitalaidseattle.techEval.models.Distribution;
import com.digitalaidseattle.techEval.models.Donation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class DonationService {
    private final DonationRepository donationRepo;
    private final DistributionRepository distributionRepo;

    public DonationService(DonationRepository donationRepo, DistributionRepository distributionRepo) {
        this.donationRepo = donationRepo;
        this.distributionRepo = distributionRepo;
    }

    public Donation registerDonation(Donation donation) {
        donation.setDate(LocalDate.now());
        return donationRepo.save(donation);
    }

    public Distribution recordDistribution(Distribution distribution) {
        distribution.setDate(LocalDate.now());
        return distributionRepo.save(distribution);
    }

    public List<Donation> getAllDonations() {
        return donationRepo.findAll();
    }

    public List<Distribution> getAllDistributions() {
        return distributionRepo.findAll();
    }
}