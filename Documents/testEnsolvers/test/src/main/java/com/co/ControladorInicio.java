
package com.co;

import com.co.DAO.ClienteDAO;
import com.co.pojo.Cliente;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ControladorInicio {
    
    @Autowired
    private ClienteDAO clienteDao;
            
    
    @GetMapping("/")
    public String inicio(){
        return "index";
    }
    
    @GetMapping("/login")
    public String iniciosesion(){
        return "iniciosesion";
    }
    
    @GetMapping("/loginadmin")
    public String loginadmin(Model model){
        var clientes = clienteDao.findAll();
        model.addAttribute("notas",clientes);
        return "loginadmin";
    }
    
    @GetMapping("/crear")
    public String crear(){
        return "crear";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cliente clientes){
        clienteDao.save(clientes);
        return "redirect:/loginadmin";
    }
    
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model){
        var clientes= clienteDao.findById(id);
        model.addAttribute("cliente",clientes);
        return "modificar";
    }
    /*
    @GetMapping("/editar/{id}")
public String editar(@PathVariable("id") Integer id, Model model, @ModelAttribute("cliente") Cliente cliente) {
        Optional<Cliente> updatedCliente = clienteDao.findById(id);
    // Update relevant fields of `updatedCliente` based on form data
    model.addAttribute("cliente", updatedCliente);
    return "modificar";
}*/

    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id){
        clienteDao.deleteById(id);
        
        return "redirect:/loginadmin";
    }
    
}
