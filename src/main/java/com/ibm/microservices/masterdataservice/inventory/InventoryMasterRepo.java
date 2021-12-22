package com.ibm.microservices.masterdataservice.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryMasterRepo extends JpaRepository<SndInventoryMaster,Integer> {
    InventoryMasterPojo findBySkuId(String skuId);
}
