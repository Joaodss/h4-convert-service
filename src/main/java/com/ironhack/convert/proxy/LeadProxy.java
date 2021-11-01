package com.ironhack.convert.proxy;

import com.ironhack.convert.dto.LeadDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("lead-service")
@RequestMapping("/leads")
public interface LeadProxy {

  @GetMapping("/{id}")
  LeadDTO getLeadById(@PathVariable long id);

  @DeleteMapping("/{id}")
  LeadDTO deleteLeadById(@PathVariable long id);

}
