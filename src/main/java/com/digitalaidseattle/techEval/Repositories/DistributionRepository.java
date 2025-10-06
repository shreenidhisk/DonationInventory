package com.digitalaidseattle.techEval.Repositories;

import com.digitalaidseattle.techEval.models.Distribution;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DistributionRepository extends MongoRepository<Distribution, String> {
}
