package com.fastcharging.csmsdbapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fastcharging.csmsdbapi.client.UserClient;
import com.fastcharging.csmsdbapi.model.MdbCustomer;
import com.fastcharging.csmsdbapi.model.OcppTag;
import com.fastcharging.csmsdbapi.repository.MdbCustomerRepository;
import com.fastcharging.csmsdbapi.repository.OcppTagRepository;
import com.fastcharging.csmsdbapi.dto.UserRestConsumer;

@RestController
@RequestMapping("api/backend/csms")
@CrossOrigin
public class CustomerController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private MdbCustomerRepository mdbCustomerRepository;

    @Autowired
    private OcppTagRepository ocppTagRepository;

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmUser(
            @RequestHeader HttpHeaders headers)
            throws Exception {

        String bearerToken = headers.getFirst(HttpHeaders.AUTHORIZATION);
        String token = bearerToken.substring(7);

        UserRestConsumer user = userClient.getUserDetail(headers);
        if (!user.getStatus().toString().equalsIgnoreCase("success")) {
            throw new Exception("Data pengguna tidak ditemukan.");
        }

        String idTag = user.getData().getTag_id();

        MdbCustomer mdbCustomer = new MdbCustomer();

        mdbCustomer.setAddress(user.getData().getAddress());
        mdbCustomer.setEmail(user.getData().getEmail());
        mdbCustomer.setName(user.getData().getFull_name());
        mdbCustomer.setIdTag(idTag);
        mdbCustomer.setPhoneNumber(user.getData().getPhone_number());
        mdbCustomer.setSaldo(0);

        mdbCustomerRepository.save(mdbCustomer);

        OcppTag ocppTag = new OcppTag();

        ocppTag.setIdTag(idTag);

        ocppTagRepository.save(ocppTag);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(mdbCustomer);
    }
}
