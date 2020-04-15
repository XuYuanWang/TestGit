package com.xujun.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author :Jun-Xu
 * @Date: 2020/03/16/ 21:14
 * @Description : 测试类
 */
public class ReportExcelTest extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用成功");
    }
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = new ArrayList<Product>();
 
        for (int i = 0 ; i<60000 ; i++) {
            //组装测试数据
            Product product = new Product();
            product.setName("爱奇艺会员"+i);
            product.setPrice(9.99);
            product.setDate(new Date());
            list.add(product);
        }
        ReportExcel reportExcel = new ReportExcel();
        reportExcel.excelExport(list,"测试",Product.class,1,resp,req);
    }
}