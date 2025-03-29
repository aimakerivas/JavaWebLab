package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

//import java.util.*;

//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.*;

@Controller
@RequestMapping("/")
public class SupplierController {
	//List<Coffee> coffees = new ArrayList<>();

	@RequestMapping(value="/supplier" ,method = RequestMethod.GET)
	public String getSupplierView() {
		return "supplierform";
	}
	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST  )
	public ModelAndView addSupplier(@RequestBody Supplier sup, ModelMap modelMap) {	
		
		modelMap.addAttribute("sups", sup);
		return new ModelAndView("showSupplier");

	}
	
	@RequestMapping(value="/home" ,method = RequestMethod.GET)
	public String getFirstView() {
		return "home";
	}
    
	@PostMapping(value="/user")
	public String getUser(@RequestBody User user,Model model) {
		model.addAttribute("person", user);
		return "userview";
	}
	@PostMapping(value="/formuser")
	public String getFormUser(@ModelAttribute("user") User user,Model model) {
		model.addAttribute("person", user);
		return "userview";
	}
}
