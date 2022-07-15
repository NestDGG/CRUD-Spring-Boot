package com.formaciondesarrollo.FeignClientVenta.Util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "ventaDemo", url = "http://BLDA13552DESOP:8002")
public interface VentaFeingClientUtil {
	
	@GetMapping("/productos")
	List<Object> getProductos();
	

}
