package org.py.web2020.db.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user
 * @author 
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User implements Serializable {
    private Integer id;
    private String userName;
    private String userPassword;
    private List<UOrder> orders;
}