package com.javamigos.orderservice;

import com.javamigos.orderservice.entity.Order;
import com.javamigos.orderservice.service.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Service;

@Service
public class OrderModelListener extends AbstractMongoEventListener<Order> {

    @Autowired
    SequenceGenerator sequenceGenerator;
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Order> event) {
        if (event.getSource().getOrderId() < 1) {
            event.getSource().setOrderId(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
        }
    }
}
