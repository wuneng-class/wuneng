package edu.nf.wuneng.user.web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import edu.nf.wuneng.CreateNo;
import edu.nf.wuneng.conf.AlipayConfig;
import edu.nf.wuneng.user.entity.Orders;
import edu.nf.wuneng.user.entity.Users;
import edu.nf.wuneng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author YXD
 * @date 2020/4/6
 */
@Controller
public class AlipayController {

    @Autowired
    private UserService userService;

    @RequestMapping("/alipay")
    public void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        response.setContentType("text/html;charset=utf-8");
        Users user=(Users) session.getAttribute("user");
        //付款金额
//        String total_amount=request.getParameter("WIDtotal_amount");
        String total_amount=request.getParameter("price");
        BigDecimal price=new BigDecimal(total_amount);
        Integer id=Integer.valueOf(request.getParameter("id"));
        //生成订单编号
        String out_trade_no= CreateNo.createTradeNo();
        Orders orders=new Orders();
        orders.setId(out_trade_no);
        orders.setUid(user.getUserId());
        orders.setTotal(price);
        session.setAttribute("payingOrders",orders);
        userService.addOrders(orders);
        //订单名称
        String subject="悟能课堂";
        //商品描述
        String body="课程购买";

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //输出
        response.getWriter().println(result);
    }

}