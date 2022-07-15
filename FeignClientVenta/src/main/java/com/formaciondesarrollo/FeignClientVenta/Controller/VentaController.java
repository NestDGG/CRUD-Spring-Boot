package com.formaciondesarrollo.FeignClientVenta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondesarrollo.FeignClientVenta.Util.VentaFeingClientUtil;

@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	private VentaFeingClientUtil ventaFeingClientUtil;
	
	@GetMapping("/productosfeing")
	public List<Object> getProductosFeing(){
		return ventaFeingClientUtil.getProductos();
	}
	
}
