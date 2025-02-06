package org.example.sortingvisualizerbackend.controller;

import org.example.sortingvisualizerbackend.model.*;
import org.example.sortingvisualizerbackend.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SortingController {
    @PostMapping("/sortSteps")
    public List<SortStep> sortSteps(@RequestBody SortRequest request) {
        return SortingFactory.getAlgorithm(request.getAlgorithm()).sort(request.getArray());
    }

}
