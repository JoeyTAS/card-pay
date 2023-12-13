package com.card.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.text.DecimalFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class paycard {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	SimpleDateFormat dd = new SimpleDateFormat("hh:mm:ss a");
	DecimalFormat dfl = new DecimalFormat("#,###,##0.00");
	Date Tfa = new Date();
	@GetMapping("/")
	public String welcome() {
		return "Hola realicemos el pago continuemos en /pay";
	}
	@GetMapping("/pay")
	public String payC(@RequestParam Optional<String> dev,Integer type,
			@RequestParam(name = "price")double pay,
			Integer amount,
			@RequestParam(name = "currency") Integer exchange) {
		double total = pay*amount;
		double dolar = 3.79;
		return dev.orElseGet(()->"Developer Joel Anthony ")
				+"\nSe realizo el pago - info"
				+"\nTipo de tarjeta "
				+(type == 1? "Visa ":"Mastercard ")
				+"\nPrecio Producto: "+pay
				+"\nCantidad: "+amount
				+"\nTotal de pago en "+(exchange == 1? "Soles: S/"+total:"Dolares: $"+(dfl.format(total/dolar))+"\nValor Dolar: S/"+dolar)
				+"\nFecha y Hora: "+ sdf.format(Tfa) +" - "+dd.format(Tfa);
	}
    //127.0.0.1:8080/pay?type=1&price=10&amount=2&currency=2 
}
