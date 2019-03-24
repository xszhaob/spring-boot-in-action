package per.bo.zhao.springbootinaction.contacts.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import per.bo.zhao.springbootinaction.contacts.domain.Contact;
import per.bo.zhao.springbootinaction.contacts.repository.ContactRepository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ContactController {

    @Resource
    private ContactRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<Contact> contacts = repository.findAll();
        model.put("contacts", contacts);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Contact contact) {
        repository.save(contact);
        return "redirect:/";
    }

}
