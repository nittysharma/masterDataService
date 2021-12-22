package com.ibm.microservices.masterdataservice.inventory;

import org.springframework.stereotype.Service;

import java.util.List;

public interface InventoryService {
    public List<InventoryMasterPojo>  getInventory();

    InventoryMasterPojo getInventoryBySkuId(String skuId);
}