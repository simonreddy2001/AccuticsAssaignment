package com.experis.Accutics.Services;

import com.experis.Accutics.Models.Input;
import com.experis.Accutics.Repositories.CampaignRepository;
import com.experis.Accutics.Repositories.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;

    @Autowired
    CampaignRepository campaignRepository;

    public void addInputs(Set<Input> inputs, Long campaignId){
        for (Input input: inputs){
            input.setCampaign(campaignRepository.findById(campaignId).get());
            inputRepository.save(input);
        }
    }

}
