package com.ironhack.convert.proxy;

import com.ironhack.convert.dto.SalesRepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("salesrep-service")
@RequestMapping("/salesrep")
public interface SalesRepProxy {

  @GetMapping("/{id}")
  SalesRepDTO findById(@PathVariable("id") Long id);

}
