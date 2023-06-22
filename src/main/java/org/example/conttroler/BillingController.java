package org.example.conttroler;

import org.example.model.BillingModel;
import org.example.repository.BillingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class BillingController
{
    @Autowired
    private BillingData billingData;

    @GetMapping("/bill")
    @CrossOrigin(origins = "http://localhost")
    public List<BillingModel> getAll()
    {
        System.out.println("+++++"+billingData.findAll());
        return billingData.findAll();
    }
    @PostMapping("/addbill")
    @CrossOrigin(origins = "http://localhost")
    public void add(@RequestBody BillingModel billingModel)
    {

        billingData.save(billingModel);
        System.out.println(billingModel.toString());
    }

    @PutMapping("/bill/{id}")
    @CrossOrigin(origins = "http://localhost")
    public void update(@PathVariable int id, @RequestBody BillingModel userDto)
    {
        Optional<BillingModel> optionalUser = billingData.findById(id);
        if (optionalUser.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find specified user!");

        BillingModel user = optionalUser.get();
        user.setName(userDto.getName());
        user.setPrize(userDto.getPrize());
        billingData.save(user);
    }
    @DeleteMapping("/bill/{id}")
    @CrossOrigin(origins = "http://localhost")
    public void delete(@PathVariable int id)
    {
        if (!billingData.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find specified user!");

        billingData.deleteById(id);
    }
}
