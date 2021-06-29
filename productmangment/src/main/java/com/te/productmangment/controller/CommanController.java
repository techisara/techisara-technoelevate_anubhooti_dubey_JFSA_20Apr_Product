package com.te.productmangment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.productmangment.bean.Products;
import com.te.productmangment.services.ProductService;



@Controller
public class CommanController {
	
	
	
	@Autowired
	private ProductService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("init Binder");
		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@GetMapping("/login")
	public String getEmpForm() {
		return "adminLogin";
	}// getEmpForm
	
	
	@PostMapping("/login")
	public String authenticate(int id, String password, HttpServletRequest request, ModelMap map,Products product) {
		if (id == 48&&password.equals("admin123")) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", product );
			map.addAttribute("id", id);
			return "productHome";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "adminLogin";
		}
	}// authenticate
	
	
	@GetMapping("/addPro")
	public String getAddFrom(@SessionAttribute(name = "loggedIn", required = false) Products product,
			ModelMap map) {
		if (product != null) {
			return "insertProduct";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		}

	}//
	
	
	@PostMapping("/add")
	public String addEmployee(Products pro,
			@SessionAttribute(name = "loggedIn", required = false) Products product, ModelMap map) {
		if (product != null) {
			if (service.addProduct(pro)) {
				map.addAttribute("msg", "Successfully Inserted");
			} else {
				map.addAttribute("msg", "Failed to Insert");
			}
			return "insertProduct";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		}

	}// add Employee
	
	
	@GetMapping("/getDeleteForm")
	public String getDeleteForm(@SessionAttribute(name = "loggedIn", required = false) Products product,
			ModelMap map) {
		if (product != null) {
			return "delete";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		}
	}//

	@GetMapping("/delete")
	public String deleteData(int id, @SessionAttribute(name = "loggedIn", required = false) Products product,
			ModelMap map) {
		if (product != null) {
			if (service.deleteProduct(id)) {
				map.addAttribute("msg", "Data Deleted successfully for id : " + id);
			} else {
				map.addAttribute("msg", "Could not find Record for id : " + id);
			}
			return "delete";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		}

	}//
	
	@GetMapping("/searchPage")
	public String getSearchPage(HttpSession session, ModelMap map) {
		Products product = (Products) session.getAttribute("loggedIn");
		System.out.println(product);
		if (product != null) {
			System.out.println("valid");
			return "search";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		}
	}// getSearchPage

	@GetMapping("/search")
	public String getEmployeeData(int id,
			@SessionAttribute(name = "loggedIn", required = false) Products product, ModelMap map) {
		if (product != null) {
			Products pro = service.getProductsinfo(id);
			if (pro != null) {
				map.addAttribute("proData", pro);
			} else {
				map.addAttribute("errMsg", "Data not Found");
			}
			return "search";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap map) {
		session.invalidate();
		map.addAttribute("msg", "logout successfull");
		return "adminLogin";
	}// logout


	@GetMapping("/getAll")
	public String getAllRecords(@SessionAttribute(name = "loggedIn", required = false) Products product,
			ModelMap map) {
		if (product != null) {
			List<Products> pro = service.getAllproducts();
			if (pro != null) {
				
				map.addAttribute("infos", pro);
			}else {
				map.addAttribute("errMsg", "No Records Found");
			}
			
			return "productHome";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		}
	}
	
	@GetMapping("/updateid")
	public String getUpdateId(int id,
			@SessionAttribute(name = "loggedIn", required = false) Products product, ModelMap map) {
		if (product != null) {
			Products pro = service.getProductsinfo(id);
			if (pro != null) {
				map.addAttribute("proData", pro);
			} else {
				map.addAttribute("errMsg", "Data not Found");
			}
			return "update";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		}
	}
	
	@GetMapping("/updateEmployee")
	public String getUpadatePage(@SessionAttribute(name = "loggedIn", required = false) Products product,
			ModelMap map) {

		if (product != null) {
			map.addAttribute("id", product);
			return "update";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";

		}
	}//

	
	
	
	@PostMapping("/update")
	public String updateEmployeeData(@SessionAttribute(name = "loggedIn", required = false) Products product,
			ModelMap map, Products pro) {
		if (product != null) {
			if (service.updateRecord(pro)) {
				map.addAttribute("msg", "Updated Successfully");
				map.addAttribute("id", pro);
			} else {
				map.addAttribute("msg", "Updation Failed");
				map.addAttribute("id", product);
			}
			return "update";
		} else {
			map.addAttribute("errMsg", "Please Login First");
			return "adminLogin";
		}
	}//
	
}
