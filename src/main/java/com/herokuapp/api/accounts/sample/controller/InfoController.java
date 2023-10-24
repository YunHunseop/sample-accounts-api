package com.herokuapp.api.accounts.sample.controller;

import com.herokuapp.api.accounts.sample.controller.dto.BasicResponse;
import com.herokuapp.api.accounts.sample.dto.info.UserAccountInfoResponse;
import com.herokuapp.api.accounts.sample.exceptions.SystemException;
import com.herokuapp.api.accounts.sample.exceptions.ValidationException;
import com.herokuapp.api.accounts.sample.service.InfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<?> getUserInfo(@PathVariable String userId) {
        try {
            var response = infoService.getUserInfo(userId);
            return new ResponseEntity<>(BasicResponse.withAttributes(response), HttpStatus.OK);
        } catch (SystemException | ValidationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("users/{userId}/accounts")
    public List<UserAccountInfoResponse.UserAccountInfo> getUserAccountInfo(@PathVariable String userId) {
        try {
           return infoService.getUserAccountInfo(userId).getUserAccountInfoList();
        } catch (SystemException | ValidationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("accounts/{accountId}")
    public ResponseEntity<?> getAccountInfo(@PathVariable String accountId) {
        try {
            var response = infoService.getAccountInfo(accountId);
            return new ResponseEntity<>(BasicResponse.withAttributes(response), HttpStatus.OK);
        } catch (SystemException | ValidationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
