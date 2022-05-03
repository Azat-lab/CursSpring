package azat.example.cursdemo.controllers;

import azat.example.cursdemo.models.Client;

import azat.example.cursdemo.services.serviceImpl.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
public class ClientsController {

        private final ClientsService clientsService;
    @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping("/clients")
        public String findAll(Model model){
            List<Client> clients = clientsService.findAllClients();
            model.addAttribute("clients", clients);
            return "client-list";
        }
        @GetMapping("/clients-add")
        public String createClientForm(Client client){
            return "client-add";
        }
        @PostMapping("/client-add")
        public String createClient(Client client){
            clientsService.saveClient(client);
            return "redirect:/clients";
        }
        @GetMapping("/client-delete/{id}")
        public  String deleteClient(@PathVariable("id") Integer id){
            clientsService.deleteById(id);
            return "redirect:/clients";
        }
        @GetMapping("/client-update/{id}")
        public String updateClientForm(@PathVariable("id") Integer id, Model model){
            Optional<Client> client = clientsService.findById(id);
            model.addAttribute("client", client);
            return  "/client-update";
        }
        @PostMapping("/client-update")
        public String updateClient(Client client){
            clientsService.saveClient(client);
            return "redirect:/clients";
        }

}

