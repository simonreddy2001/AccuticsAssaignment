package com.experis.Accutics.Repositories;


import com.experis.Accutics.Models.Campaign;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends PagingAndSortingRepository<Campaign, Long> {
}
