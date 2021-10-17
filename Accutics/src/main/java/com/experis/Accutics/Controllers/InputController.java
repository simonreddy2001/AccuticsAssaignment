package com.experis.Accutics.Controllers;


import com.experis.Accutics.Repositories.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class InputController {
    @Autowired
    private InputRepository inputRepository;


}
