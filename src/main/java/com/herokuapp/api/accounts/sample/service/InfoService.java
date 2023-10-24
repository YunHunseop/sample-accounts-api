package com.herokuapp.api.accounts.sample.service;

import com.herokuapp.api.accounts.sample.config.Constants;
import com.herokuapp.api.accounts.sample.dto.info.AccountInfoResponse;
import com.herokuapp.api.accounts.sample.dto.info.UserAccountInfoResponse;
import com.herokuapp.api.accounts.sample.dto.info.UserInfoResponse;
import com.herokuapp.api.accounts.sample.exceptions.SystemException;
import com.herokuapp.api.accounts.sample.exceptions.ValidationException;
import com.herokuapp.api.accounts.sample.repository.InfoRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
    public UserInfoResponse getUserInfo(String userId) {
        ValidNumericStringValue(userId);
        try {
            return InfoRepository.getUserInfo(userId);
        } catch (Exception ex) {
            throw new SystemException(Constants.EXTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public UserAccountInfoResponse getUserAccountInfo(String userId) {
        ValidNumericStringValue(userId);
        try {
            return InfoRepository.getUserAccountInfo(userId);
        } catch (Exception ex) {
            throw new SystemException(Constants.EXTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public AccountInfoResponse getAccountInfo(String accountId) {
        ValidNumericStringValue(accountId);
        try {
            return InfoRepository.getAccountInfo(accountId);
        } catch (Exception ex) {
            throw new SystemException(Constants.EXTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void ValidNumericStringValue(String stringValue) {
        if (StringUtils.isBlank(stringValue) || !isInteger(stringValue)) {
            throw new ValidationException(Constants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        }
    }

    private boolean isInteger(String stringValue) {
        try {
            Integer.parseInt(stringValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
