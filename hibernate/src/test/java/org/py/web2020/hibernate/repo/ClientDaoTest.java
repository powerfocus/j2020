package org.py.web2020.hibernate.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.hibernate.entity.SubSelectEnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientDaoTest {
    @Autowired
    private ClientDao clientDao;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountTransactionDao accountTransactionDao;

    @Test
    public void testSave() {
        SubSelectEnt.Client client = SubSelectEnt.Client.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .build();
        clientDao.save(client);

        SubSelectEnt.Account account = SubSelectEnt.Account.builder()
                .id(1L)
                .client(client)
                .description("Checking account")
                .build();
        accountDao.save(account);

        SubSelectEnt.AccountTransaction transaction = SubSelectEnt.AccountTransaction.builder()
                .id(1L)
                .account(account)
                .description("Salary")
                .cents(100 * 7000)
                .build();
        accountTransactionDao.save(transaction);
    }

    @Test
    public void testFindSummary() {
        System.out.println(clientDao.findSummary(1L));
        SubSelectEnt.AccountSummary summary = clientDao.findSummary(1L);
        System.out.println(summary);
    }
}