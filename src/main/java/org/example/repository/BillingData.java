package org.example.repository;

import org.example.model.BillingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingData extends JpaRepository<BillingModel,Integer>
{
}
