package com.manhcode.controller;

import com.manhcode.model.Order;
import com.manhcode.model.Product;
import com.manhcode.model.dto.OrderDTO;
import com.manhcode.service.ReportService;
import com.manhcode.service.order.OrderService;
import com.manhcode.service.product.ProductService;
import com.manhcode.service.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private TypeService typeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ReportService reportService;

    @GetMapping("/report")
    public ModelAndView listTypes( @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<OrderDTO> orders = reportService.getReport(pageable);

        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping("/updateOrder/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") Long orderId) {
        Order order = orderService.getOrderById(orderId);
        List<Product> products = productService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("order", order);
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @PostMapping("/updateOrder")
    public String updateOrder(@RequestParam("id") Long orderId,
                              @RequestParam("productId") Long productId,
                              @RequestParam("purchaseDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date purchaseDate,
                              @RequestParam("quantity") int quantity) {
        orderService.updateOrder(orderId, productId, purchaseDate, quantity);
        return "redirect:/report";
    }

    @GetMapping("/top-orders")
    public ModelAndView showTopOrders() {
        List<Order> topOrders = orderService.getTop5HighestTotalOrders();
        ModelAndView modelAndView = new ModelAndView("top-orders");
        modelAndView.addObject("topOrders", topOrders);
        return modelAndView;
    }

}
