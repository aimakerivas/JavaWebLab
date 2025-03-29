package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HelloWorldController {
 
    @RequestMapping(value="/hello",method=RequestMethod.GET)
    public String hello(Model model) {         
        model.addAttribute("greeting", "Hello Spring MVC @RequestMapping ");         
        return "helloworld";         
    }
    @GetMapping(value="/hello2")
    public String hello2(Model model) {         
        model.addAttribute("greeting", "Hello Spring MVC @GetMapping");         
        return "helloworld";  // prefix(/WEB-INF/views/)+helloworld+suffix(.jsp)  
    }
    @GetMapping(value="/hello3")
    public String hello3(Model model) {         
        model.addAttribute("greeting", "Hello Spring MVC @GetMapping-supplierform");         
        return "supplierform";  // prefix(/WEB-INF/views/)+helloworld+suffix(.jsp)  
    }
}
