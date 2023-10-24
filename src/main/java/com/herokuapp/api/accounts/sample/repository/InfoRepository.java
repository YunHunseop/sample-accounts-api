package com.herokuapp.api.accounts.sample.repository;

import com.herokuapp.api.accounts.sample.dto.info.AccountInfoResponse;
import com.herokuapp.api.accounts.sample.dto.info.UserAccountInfoResponse;
import com.herokuapp.api.accounts.sample.dto.info.UserInfoResponse;

import java.util.List;

public class InfoRepository {
    public static UserInfoResponse getUserInfo(String userId) {
        if (userId.equalsIgnoreCase("1")) {
            return createUserInfoResponse();
        } else {
            return new UserInfoResponse();
        }
    }

    private static UserInfoResponse createUserInfoResponse() {
        return UserInfoResponse.builder()
                .id(1)
                .name("Alice")
                .account_ids(List.of(1, 3, 5))
                .build();
    }

    public static UserAccountInfoResponse getUserAccountInfo(String userId) {
        if (userId.equalsIgnoreCase("1")) {
            return createUserAccountInfoResponse();
        } else {
            return new UserAccountInfoResponse();
        }
    }

    private static UserAccountInfoResponse createUserAccountInfoResponse() {
        return UserAccountInfoResponse.builder()
                .userAccountInfoList(List.of(createUserAccountInfo1(), createUserAccountInfo2(), createUserAccountInfo3()))
                .build();

    }

    private static UserAccountInfoResponse.UserAccountInfo createUserAccountInfo1() {
        return UserAccountInfoResponse.UserAccountInfo.builder()
                .accountInfoResponse(createAccountInfoResponseForUserAccountInfo1())
                .build();
    }

    private static AccountInfoResponse createAccountInfoResponseForUserAccountInfo1() {
        return AccountInfoResponse.builder()
                .id(1)
                .user_id(1)
                .name("A銀行")
                .balance(20000)
                .build();
    }

    private static UserAccountInfoResponse.UserAccountInfo createUserAccountInfo2() {
        return UserAccountInfoResponse.UserAccountInfo.builder()
                .accountInfoResponse(createAccountInfoResponseForUserAccountInfo2())
                .build();
    }

    private static AccountInfoResponse createAccountInfoResponseForUserAccountInfo2() {
        return AccountInfoResponse.builder()
                .id(3)
                .user_id(1)
                .name("C信用金庫")
                .balance(120000)
                .build();
    }

    private static UserAccountInfoResponse.UserAccountInfo createUserAccountInfo3() {
        return UserAccountInfoResponse.UserAccountInfo.builder()
                .accountInfoResponse(createAccountInfoResponseForUserAccountInfo3())
                .build();
    }

    private static AccountInfoResponse createAccountInfoResponseForUserAccountInfo3() {
        return AccountInfoResponse.builder()
                .id(5)
                .user_id(1)
                .name("E銀行")
                .balance(5000)
                .build();
    }

    public static AccountInfoResponse getAccountInfo(String accountId) {
        if (accountId.equalsIgnoreCase("2")) {
            return createAccountInfoResponse();
        } else {
            return new AccountInfoResponse();
        }
    }

    private static AccountInfoResponse createAccountInfoResponse() {
        return AccountInfoResponse.builder()
                .id(2)
                .user_id(2)
                .name("Bカード")
                .balance(200)
                .build();
    }
}
