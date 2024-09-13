package com.manhcode.controller;

import com.manhcode.model.Order;
import com.manhcode.model.Product;
import com.manhcode.model.Type;
import com.manhcode.model.dto.OrderDTO;
import com.manhcode.service.ReportService;
import com.manhcode.service.order.OrderService;
import com.manhcode.service.product.ProductService;
import com.manhcode.service.type.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

}
