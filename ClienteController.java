package tiendaTelefonica.example.insside;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tiendaTelefonica.example.insside.service.IClientesService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private IClientesService serviceCliente;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Cliente> lista = serviceCliente.buscarTodas();
		model.addAttribute("clientes", lista);
		return "clientes/listaClientes";
	}
	
	//Para evitar hacer un metodo largo usando la anotacion @RequestParam, utilice Data Binding.
	@GetMapping("/nuevoCliente")
	public String nuevoCliente() {
	
		return "clientes/formCliente";
	}
	
	@PostMapping("/save")
	public String guardar(Cliente cliente, Model model, RedirectAttributes atributo) {
		
		System.out.println("Cliente" + cliente);
		 
		
		model.addAttribute("msg", "Orden guardada");
		serviceCliente.guardar(cliente);
		atributo.addFlashAttribute("msg", "Orden Guardada");
		return "redirect:/clientes/index";
	}
	
	//Esto es para el formato Date -> String
	@InitBinder
	public void initBinde(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}




	
