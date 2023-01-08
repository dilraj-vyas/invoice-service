package com.frostywhale.invoice.model;

import java.io.Serializable;

import com.frostywhale.invoice.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Event implements Serializable {
    private int id;
    private String type;
    private Order order;


}
