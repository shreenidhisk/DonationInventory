package com.digitalaidseattle.techEval.Repositories;

import com.digitalaidseattle.techEval.models.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonationRepository extends MongoRepository<Donation, String> {
}
