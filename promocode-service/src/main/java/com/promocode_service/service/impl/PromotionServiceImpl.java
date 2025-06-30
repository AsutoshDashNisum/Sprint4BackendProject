package com.promocode_service.service.impl;

import com.promocode_service.model.Promotions;
import com.promocode_service.repository.PromotionsRepository;
import com.promocode_service.service.PromotionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionsRepository repository;

    public PromotionServiceImpl(PromotionsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Promotions> getAllPromotions() {
        return repository.findAll();
    }

    @Override
    public Promotions savePromotion(Promotions promo) {
        return repository.save(promo);
    }

    @Override
    public Promotions updatePromotion(Integer id, Promotions promo) {
        return null;
    }

    @Override
    public void deletePromotion(Integer id) {

    }

    @Override
    public Promotions updatePromotion(String promoCode, Promotions promo) {
        Optional<Promotions> existing = repository.findById(promoCode);
        if (existing.isEmpty()) {
            throw new RuntimeException("Promotion with code " + promoCode + " not found");
        }

        Promotions existingPromo = existing.get();
        existingPromo.setPromoType(promo.getPromoType());
        existingPromo.setDescription(promo.getDescription());
        existingPromo.setPromoAmount(promo.getPromoAmount());

        return repository.save(existingPromo);
    }

    @Override
    public void deletePromotion(String promoCode) {
        if (!repository.existsById(promoCode)) {
            throw new RuntimeException("Promotion with code " + promoCode + " does not exist");
        }
        repository.deleteById(promoCode);
    }
}
