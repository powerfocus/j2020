package org.py.web2020.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

import javax.persistence.*;

/**
 * 官方文档
 * 2.5.8. Mapping the entity to a SQL query
 * */
public class SubSelectEnt {
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    @Entity
    @Table(name = "client")
    public static class Client {
        @Id
        private Long id;
        private String firstName;
        private String lastName;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    @Entity
    @Table(name = "account")
    public static class Account {
        @Id
        private Long id;

        @ManyToOne
        private Client client;
        private String description;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    @Entity
    @Table(name = "account_transaction")
    public static class AccountTransaction {
        @Id
        private Long id;

        @ManyToOne
        private Account account;
        private Integer cents;
        private String description;
    }

    @Data
    @Entity(name = "AccountSummary")
    @Subselect(
            "select " +
                    "	a.id as id, " +
                    "	concat(concat(c.first_name, ' '), c.last_name) as client_name, " +
                    "	sum(atr.cents) as balance " +
                    "from account a " +
                    "join client c on c.id = a.client_id " +
                    "join account_transaction atr on a.id = atr.account_id " +
                    "group by a.id, concat(concat(c.first_name, ' '), c.last_name)"
    )
    @Synchronize({"client", "account", "account_transaction"})
    public static class AccountSummary {
        @Id
        private Long id;

        private String clientName;

        private int balance;
    }
}
