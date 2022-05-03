package azat.example.cursdemo.controllers;

import azat.example.cursdemo.models.Clients;
import azat.example.cursdemo.repository.ClientsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;


@Controller
public class ClientsController {
        @Autowired
        private ClientsRepository clientsRepository;

        @GetMapping("/")
        public String clientsMain(Model model){
        Iterable<Clients> clients= clientsRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients-main";
    }
    @GetMapping("clients/add")
    public String clientsAdd(Model model){
            return "clients_add";
    }

    @PostMapping("/clients/add")
    public String clientsDataAdd(@RequestParam String address, @RequestParam Integer month_inc, @RequestParam String name, @RequestParam String surname,
                                 @RequestParam String sec_surname, @RequestParam String passport_ser, @RequestParam String passport_num,
                                 @RequestParam String by_who, @RequestParam String ident_num, @RequestParam String birth_place,
                                 @RequestParam String city, @RequestParam Integer city_id, @RequestParam String tel,
                                 @RequestParam String email, @RequestParam String work_place, @RequestParam String position,
                                 @RequestParam String fam_status, @RequestParam Integer fs_id, @RequestParam String residence,
                                 @RequestParam Integer residence_id, @RequestParam String disability, @RequestParam Integer disability_id,
                                 @RequestParam boolean pensioner, @RequestParam boolean duty_bound, @RequestParam LocalDate birth_date,
                                 @RequestParam LocalDate issue_date) {

            Clients clients = new Clients(address, month_inc, name, surname, sec_surname, passport_ser,
                    passport_num, by_who, ident_num, birth_place, city, city_id, tel, email, work_place,
                    position, fam_status, fs_id, residence,residence_id, disability, disability_id, pensioner,
                    duty_bound, birth_date, issue_date);
        clientsRepository.save(clients);
        return "redirect:/clients";
    }
    @GetMapping("clients/{id}")
    public String clientsDetails(@PathVariable(value = "id") Integer id, Model model){
        if (!clientsRepository.existsById(id)) {
            return "redirect:/clients";
        }
            Optional<Clients> clients = clientsRepository.findById(id);
        ArrayList<Clients> res = new ArrayList<>();
        clients.ifPresent(res::add);
        model.addAttribute("clients", res);
        return "clients_details";
    }
    @GetMapping("clients/{id}/edit")
    public String clientsEdit(@PathVariable(value = "id") Integer id, Model model){
        if (!clientsRepository.existsById(id)) {
            return "redirect:/clients";
        }
        Optional<Clients> clients = clientsRepository.findById(id);
        ArrayList<Clients> res = new ArrayList<>();
        clients.ifPresent(res::add);
        model.addAttribute("clients", res);
        return "clients_edit";
    }
    @PostMapping("/clients/{id}/edit")
    public String clientsDataUpdate(@PathVariable(value = "id") Integer id, @RequestParam String address, @RequestParam Integer month_inc, @RequestParam String name, @RequestParam String surname,
                                 @RequestParam String sec_surname, @RequestParam String passport_ser, @RequestParam String passport_num,
                                 @RequestParam String by_who, @RequestParam String ident_num, @RequestParam String birth_place,
                                 @RequestParam String city, @RequestParam Integer city_id, @RequestParam String tel,
                                 @RequestParam String email, @RequestParam String work_place, @RequestParam String position,
                                 @RequestParam String fam_status, @RequestParam Integer fs_id, @RequestParam String residence,
                                 @RequestParam Integer residence_id, @RequestParam String disability, @RequestParam Integer disability_id,
                                 @RequestParam boolean pensioner, @RequestParam boolean duty_bound, @RequestParam LocalDate birth_date,
                                 @RequestParam LocalDate issue_date, Model model) {

            Clients clients = clientsRepository.findById(id).orElseThrow();
            clients.setName(name);
            clients.setSurname(surname);
            clients.setAddress(address);
            clients.setMonth_inc(month_inc);
            clients.setSec_surname(sec_surname);
            clients.setPassport_ser(passport_ser);
            clients.setPassport_num(passport_num);
            clients.setBy_who(by_who);
            clients.setIdent_num(ident_num);
            clients.setBirth_place(birth_place);
            clients.setCity(city);
            clients.setCity_id(city_id);
            clients.setTel(tel);
            clients.setEmail(email);
            clients.setWork_place(work_place);
            clients.setPosition(position);
            clients.setFam_status(fam_status);
            clients.setFs_id(fs_id);
            clients.setResidence(residence);
            clients.setResidence_id(residence_id);
            clients.setDisability(disability);
            clients.setDisability_id(disability_id);
            clients.setPensioner(pensioner);
            clients.setDuty_bound(duty_bound);
            clients.setBirth_date(birth_date);
            clients.setIssue_date(issue_date);
        clientsRepository.save(clients);
        return "redirect:/clients";
    }

    @PostMapping("/clients/{id}/remove")
    public String clientsDataDelete(@PathVariable(value = "id") Integer id, Model model) {
        Clients clients = clientsRepository.findById(id).orElseThrow();
        clientsRepository.delete(clients);
        return "redirect:/clients";
    }

}

//        Clients clients = new Clients(address, month_inc, name, surname, sec_surname, passport_ser,
//                passport_num, by_who, ident_num, birth_place, city, city_id, tel, email, work_place,
//                position, fam_status, fs_id, residence,residence_id, disability, disability_id, pensioner,
//                duty_bound, birth_date, issue_date);










//    @GetMapping("/clients")
//    public ResponseEntity<List<Clients>> getAllClients(@RequestParam(required = false) Integer id){
//        try{
//            List<Clients> clients = new ArrayList<Clients>();
//            if(id == null)
//                clientsService.getAllClients().forEach(clients::add);
//            if(clients.isEmpty()){
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(clients, HttpStatus.OK);
//        }catch(Exception e){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Clients> getClientById(@PathVariable Integer id) {
//        return clientsService.getClientsById(id);
//    }
//
//    @PostMapping("/clients/add")
//    public ResponseEntity<Clients> addClients(@RequestBody Clients clients) {
//        try {
//            boolean clients_ = clientsService
//                    .addClients(new Clients(clients.getId(),
//                            clients.getAddress(),
//                            clients.getMonth_inc(),
//                            clients.getName(),
//                            clients.getSurname(),
//                            clients.getSec_surname(),
//                            clients.getPassport_ser(),
//                            clients.getPassport_num(),
//                            clients.getBy_who(),
//                            clients.getIdent_num(),
//                            clients.getBirth_place(),
//                            clients.getCity(),
//                            clients.getCity_id(),
//                            clients.getTel(),
//                            clients.getEmail(),
//                            clients.getWork_place(),
//                            clients.getPosition(),
//                            clients.getFam_status(),
//                            clients.getFs_id(),
//                            clients.getResidence(),
//                            clients.getResidence_id(),
//                            clients.getDisability(),
//                            clients.getDisability_id(),
//                            clients.isPensioner(),
//                            clients.isDuty_bound(),
//                            clients.getBirth_date(),
//                            clients.getIssue_date()));
//            return new ResponseEntity<>(clients, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @DeleteMapping("/clients/{id}")
//    public ResponseEntity<HttpStatus> deleteClientById(@PathVariable("id") Integer id) {
//        try {
//            clientsService.deleteClientById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @GetMapping("/clients/name")
//    public ResponseEntity<List<Clients>> findAllByNameAndSurname() {
//        try {
//            List<Clients> tutorials = (List<Clients>) clientsService.findByNameAndSurname(findAllByNameAndSurname().toString(), toString());
//            if (tutorials.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(tutorials, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//}