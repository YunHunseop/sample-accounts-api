package com.herokuapp.api.accounts.sample.dto.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfoResponse {
    private Integer id;
    private Integer user_id;
    private String name;
    private Integer balance;
}
