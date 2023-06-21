package com.boocrun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boocrun.response.MarsRoverApiResponse;
import com.boocrun.service.MarsRoverApiService;

import io.micrometer.common.util.StringUtils;

@Controller
public class HomeController {
  
  @Autowired
  private MarsRoverApiService roverService;
  @GetMapping("/")
  public String getHomeView (ModelMap model, @RequestParam(required=false) 
                              String marsApiRoverData, @RequestParam(required=false)
                              Integer marsSol) {
    if (StringUtils.isEmpty(marsApiRoverData)) {
      marsApiRoverData = "opportunity";
    }
    if (marsSol == null)
      marsSol = 1;
    MarsRoverApiResponse roverData = roverService.getRoverData(marsApiRoverData, marsSol);  //opportunity
    model.put("roverData", roverData);
    return "index";
  }
  
//  @PostMapping("/")
//  public String postHomeView (ModelMap model, @RequestParam String marsApiRoverData) {
//    MarsRoverApiResponse roverData = roverService.getRoverData(marsApiRoverData);  //opportunity
//    model.put("roverData", roverData);
//    return "index";
//  }
}
