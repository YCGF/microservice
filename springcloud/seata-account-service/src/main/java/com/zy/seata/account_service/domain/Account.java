package com.zy.seata.account_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private int id;

    private int productId;

    private double total;

    private double used;

    private double residue;
}
