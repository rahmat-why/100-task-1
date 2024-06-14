package id.co.astratech.tugas1_agit_rahmatwahyu;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String routingKey = "rahmatQeueu";

    private static final String exchange = "rahmatExternalExchange";

    @RequestMapping(value = "/kirimPesan", method = RequestMethod.POST)
    public DtoResponse kirimPesan(@RequestBody String pesan){
        rabbitTemplate.convertAndSend(exchange, routingKey, pesan);
        return new DtoResponse(200, "Pesan yang anda kirim ke RabbitMQ: " + pesan,"Suskes");
    }

}
