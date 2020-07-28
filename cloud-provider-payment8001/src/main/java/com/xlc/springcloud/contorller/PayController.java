package com.xlc.springcloud.contorller;



import com.xlc.springcloud.entities.CommonResult;
import com.xlc.springcloud.entities.Payment;
import com.xlc.springcloud.servie.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PayController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/save")
    public CommonResult savePayment(Payment payment){
        int result = paymentService.savePayment(payment);
        //log.info(".....插入结果" + result);
     /*   if(result > 0){
            return new CommonResult(200,"添加成功 serverPort"+serverPort,result);
        }else{
            return new CommonResult(400,"插入失败 ",null);
        }*/
        return null;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentId(@PathVariable("id") Long id){
        Payment payment = paymentService.findByPaymentId(id);
      //  log.info("查询成功" + payment);
       /* if (payment != null){
            return new CommonResult(200,"查询成功 serverPort"+serverPort,payment);
        }else{
            return new CommonResult(400,"没有对应数据 id" + id,null);
        }*/
        return null;
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println("===========element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
          //  log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String payment(){
        return "hi , i am paymentzipkin server fall back, welcome to xlcandlxm home";
    }
}








