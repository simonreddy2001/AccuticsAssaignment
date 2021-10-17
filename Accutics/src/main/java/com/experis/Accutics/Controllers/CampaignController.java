package com.experis.Accutics.Controllers;

import com.experis.Accutics.Models.Campaign;
import com.experis.Accutics.Repositories.CampaignRepository;
import com.experis.Accutics.Repositories.InputRepository;
import com.experis.Accutics.Services.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/campaigns")
public class CampaignController {



    @Autowired
    InputService inputService;


}
