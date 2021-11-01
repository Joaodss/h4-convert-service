package com.ironhack.convert.proxy;

import com.ironhack.convert.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("account-service")
@RequestMapping("/accounts")
public interface AccountProxy {

  @GetMapping("/{id}")
  AccountDTO findById(@PathVariable(name = "id") Long id);

  @PostMapping
  AccountDTO create(@RequestBody AccountDTO accountDTO);

  @DeleteMapping("/{id}")
  void remove(@PathVariable("id") Long id);

}
