package com.boocrun.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boocrun.dto.HomeDto;
import com.boocrun.response.MarsRoverApiResponse;
import com.boocrun.service.MarsRoverApiService;

import io.micrometer.common.util.StringUtils;

@Controller
public class HomeController {
  
  @Autowired
  private MarsRoverApiService roverService;
  @GetMapping("/")
  public String getHomeView (ModelMap model, HomeDto homeDto) {
    if (StringUtils.isEmpty(homeDto.getMarsApiRoverData())) {
      homeDto.setMarsApiRoverData("opportunity");
    }
    if (homeDto.getMarsSol() == null)
      homeDto.setMarsSol(1);
    MarsRoverApiResponse roverData = roverService.getRoverData(homeDto.getMarsApiRoverData(), homeDto.getMarsSol());  //opportunity
    model.put("roverData", roverData);
    model.put("homeDto", homeDto);
    return "index";
  }
  
//  @PostMapping("/")
//  public String postHomeView (ModelMap model, @RequestParam String marsApiRoverData) {
//    MarsRoverApiResponse roverData = roverService.getRoverData(marsApiRoverData);  //opportunity
//    model.put("roverData", roverData);
//    return "index";
//  }
}
