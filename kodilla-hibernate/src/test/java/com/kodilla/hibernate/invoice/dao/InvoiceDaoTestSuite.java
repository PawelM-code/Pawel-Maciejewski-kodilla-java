package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ItemDao itemDao;


    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Banana");
        Product product2 = new Product("Orange");

        Item item1 = new Item(product1, new BigDecimal(10), 2000);
        Item item2 = new Item(product2, new BigDecimal(20.5), 100);
        Item item3 = new Item(product1, new BigDecimal(11), 1000);

        product1.getItemList().add(item1);
        product1.getItemList().add(item3);
        product2.getItemList().add(item2);

        Invoice invoice = new Invoice("1/1/2019");

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        //When
        productDao.save(product1);
        productDao.save(product2);
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        itemDao.save(item1);
        itemDao.save(item2);
        itemDao.save(item3);

        //Then
        Assert.assertNotEquals(0, invoiceId);
    }
}
