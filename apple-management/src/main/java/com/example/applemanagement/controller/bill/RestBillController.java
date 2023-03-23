package com.example.applemanagement.controller.bill;

import com.example.applemanagement.model.billDetail.Bill;
import com.example.applemanagement.service.bill.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/bill")
public class RestBillController {
    @Autowired
    private IBillService billService;

    @GetMapping("")
    public List<Bill> showList() {
        return billService.showList();
    }
}
