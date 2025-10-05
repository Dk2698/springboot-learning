package com.kumar.book.service.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    public void triggerSave(){
        saveData(); // NOT transactional
    }

    //not work
    // split the method into another bean(@Component)
    @Transactional
    private void saveData() {
        // transactional
    }
}
