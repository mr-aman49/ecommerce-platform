package src.main.java.com.order_service.order_service.service;

import com.order_service.order_service.model.Order;
import com.order_service.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order placeOrder(Order order) {
        return repository.save(order);
    }
}