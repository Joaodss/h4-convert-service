package com.ironhack.convert.proxy;

import com.ironhack.convert.dto.ContactDTO;
import com.ironhack.convert.dto.NewContactDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("contact-service")
@RequestMapping("/contacts")
public interface ContactProxy {

  @PostMapping
  ContactDTO store(@RequestBody NewContactDTO newContactDTO);

}
