package com.ibm.microservices.masterdataservice.inventory;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InventoryMasterController {

    Logger logger= LoggerFactory.getLogger(InventoryMasterController.class);
    @Autowired
    InventoryService inventoryService;

    @Autowired
    Environment environment;

    @GetMapping("/inventory")
    @Retry(name="default")
    public List<InventoryMasterPojo> getInventory(){
        logger.info("sample api call receive");
        return inventoryService.getInventory().stream().map(e->{e.setEnvironment(
                (environment.getProperty("local.server.port")));
        return e;}).collect(Collectors.toList());
    }

    @GetMapping("/inventory/{id}")
    public InventoryMasterPojo getInventoryBySkuId(@PathVariable("skuId") String skuId){
        return inventoryService.getInventoryBySkuId(skuId);
    }

}
