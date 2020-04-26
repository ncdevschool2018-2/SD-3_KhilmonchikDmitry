package by.training.nc.sd3.controller;

import by.training.nc.sd3.entity.ProductOffering;
import by.training.nc.sd3.service.ProductOfferingService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/subscriptions")
public class SubscriptionController {

    private ProductOfferingService productOfferingService;

    public SubscriptionController(ProductOfferingService productOfferingService) {
        this.productOfferingService = productOfferingService;
    }

    @RequestMapping(value = "")
    public Iterable<ProductOffering> getAllSubscriptions() {
        return productOfferingService.getSubscriptions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ProductOffering> getSubscriptionById(@PathVariable(name = "id") Long id) {
        return productOfferingService.getSubscriptionById(id);
    }

    @RequestMapping(value = "/by-category", method = RequestMethod.GET)
    public Iterable<ProductOffering> getSubscriptionsByCategory(@RequestParam Long category) {
        return productOfferingService.getSubscriptionsByCategory(category);
    }

    @RequestMapping(value = "/by-name", method = RequestMethod.GET)
    public ProductOffering getSubscriptionsByName(@RequestParam String name) {
        return productOfferingService.getSubscriptionsByName(name);
    }

    @PostMapping(value = "/save")
    public ProductOffering save(@RequestBody ProductOffering productOffering) {
        return productOfferingService.save(productOffering);
    }

    @PostMapping(value = "/ban")
    public ProductOffering ban(@RequestBody Long id) {
        return productOfferingService.ban(id);
    }

    @PostMapping(value = "/unban")
    public ProductOffering unBan(@RequestBody Long id) {
        return productOfferingService.unBan(id);
    }
}
