package com.ibm.microservices.masterdataservice.inventory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService{
@Autowired
InventoryMasterRepo inventoryMasterRepo;

    @Override
    @Transactional
    public List<InventoryMasterPojo> getInventory() {
    return this.inventoryMasterRepo.findAll().stream().map(e->entityToBean(e)).collect(Collectors.toList());
    }


    @Override
    @Transactional
    public InventoryMasterPojo getInventoryBySkuId(String skuId) {
        return this.inventoryMasterRepo.findBySkuId(skuId);
    }

    public InventoryMasterPojo entityToBean(SndInventoryMaster sndInventoryMaster){
        InventoryMasterPojo inventoryMasterPojo=new InventoryMasterPojo();
        BeanUtils.copyProperties(sndInventoryMaster,inventoryMasterPojo);
        return inventoryMasterPojo;
    }

}
