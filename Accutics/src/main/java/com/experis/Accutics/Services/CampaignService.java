package com.experis.Accutics.Services;

import com.experis.Accutics.Models.Campaign;
import com.experis.Accutics.Models.Input;
import com.experis.Accutics.Models.User;
import com.experis.Accutics.Repositories.CampaignRepository;
import com.experis.Accutics.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.*;

@Service
public class CampaignService {

    @Autowired
    CampaignRepository campaignRepository;
    @Autowired
    UserRepository userRepository;

    public Campaign newCampaign(Long userId) {

        User user = userRepository.getById(userId);
        Campaign campaign = new Campaign();
        campaign.setUser(user);
        campaign.setCreated(new Date().toString());
        return campaignRepository.save(campaign);

    }

    public Campaign giveInputs(Set<Input> inputList, Long campaignId) throws Exception {
        Optional<Campaign> campaignOptional = campaignRepository.findById(campaignId);
        Campaign campaign;
        if (campaignOptional.isPresent()) {
            campaign = campaignOptional.get();
            campaign.setInputList(inputList);
            return campaignRepository.save(campaign);
        } else {
            throw new Exception("error");
        }

    }

}
