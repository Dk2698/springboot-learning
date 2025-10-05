package com.kumar.book.service.transaction;

import com.kumar.book.exception.CustomCheckException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Transactional(propagation = Propagation.REQUIRED)
    public void  mainTransaction(){ // commit
        saveMain();

        try {
            nestedTransaction(); // will commit or rollback independently
        }catch (Exception e){
            System.out.println("Nested failed, continuing..");
        }
    }

    private void saveMain() {
        System.out.println("save some data in main");
    }

    // rolls back
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void nestedTransaction(){
        savedNested();
        throw new RuntimeException("Forcing rollback");
    }

    private void savedNested() {
        System.out.println("save some data in nested");
    }


    // customRollback for checked Exception
    @Transactional(rollbackFor = CustomCheckException.class)
    public void processPayment() throws CustomCheckException{
        // save to DB;
        throw new CustomCheckException("Failed");
    }
}
