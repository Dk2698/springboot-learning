package com.kumar.book.service.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessOPService {
    @Autowired
    private AuditService auditService;

    @Transactional
    public void performBusinessOperation(){
        // do work
        auditService.logAction("Business Operation"); // audit will still be saved, event if the business operations fails
        throw new RuntimeException("Something went wrong"); // only main TX roll back
    }
}
