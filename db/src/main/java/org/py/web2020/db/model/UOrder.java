package org.py.web2020.db.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * u_order
 * @author 
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer uid;
    private String title;
    private BigDecimal price;
    private User user;
}