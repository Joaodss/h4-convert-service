package com.ironhack.convert.proxy;

import com.ironhack.convert.dto.NewOpportunityDTO;
import com.ironhack.convert.dto.OpportunityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient("opportunity-service")
@RequestMapping("/opps")
public interface OpportunityProxy {

  @GetMapping("/{id}")
  OpportunityDTO getById(@PathVariable Long id);

  @PutMapping("/{id}/{status}")
  OpportunityDTO changeStatus(@PathVariable Long id, @PathVariable String status);

  @PostMapping
  OpportunityDTO createOpp(@RequestBody NewOpportunityDTO newOpportunityDTO);

}
