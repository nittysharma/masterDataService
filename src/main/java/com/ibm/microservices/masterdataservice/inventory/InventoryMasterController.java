package com.ibm.microservices.masterdataservice.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryMasterController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping("/inventory")
    public List<InventoryMasterPojo> getInventory(){
        return inventoryService.getInventory();
    }

    @GetMapping("/inventory/{id}")
    public InventoryMasterPojo getInventoryBySkuId(@PathVariable("skuId") String skuId){
        return inventoryService.getInventoryBySkuId(skuId);
    }

}
