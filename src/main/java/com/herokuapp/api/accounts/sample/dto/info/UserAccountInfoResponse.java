package com.herokuapp.api.accounts.sample.dto.info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountInfoResponse {
    private List<UserAccountInfo> userAccountInfoList;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserAccountInfo {
        @JsonProperty("attributes")
        private AccountInfoResponse accountInfoResponse;
    }
}
