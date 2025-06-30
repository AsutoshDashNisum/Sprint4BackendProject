package com.promocode_service.controller;

import com.promocode_service.model.Promotions;
import com.promocode_service.service.PromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService service;

    public PromotionController(PromotionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Promotions>> getAll() {
        return ResponseEntity.ok(service.getAllPromotions());
    }

    @PostMapping
    public ResponseEntity<Promotions> addPromo(@RequestBody Promotions promo) {
        return ResponseEntity.ok(service.savePromotion(promo));
    }

    @PutMapping("/{promoCode}")
    public ResponseEntity<Promotions> updatePromo(@PathVariable String promoCode, @RequestBody Promotions promo) {
        Promotions updated = service.updatePromotion(promoCode, promo);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{promoCode}")
    public ResponseEntity<Void> deletePromo(@PathVariable String promoCode) {
        service.deletePromotion(promoCode);
        return ResponseEntity.noContent().build();
    }

}
