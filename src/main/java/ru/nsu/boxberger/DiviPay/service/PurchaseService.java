package ru.nsu.boxberger.DiviPay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsu.boxberger.DiviPay.model.Purchase;
import ru.nsu.boxberger.DiviPay.repository.PurchaseRepository;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

    public Purchase updatePurchase(Long purchaseID, Purchase purchase) {
        Purchase existingPurchase = purchaseRepository.findById(purchaseID).orElse(null);
        if (existingPurchase != null) {
            existingPurchase.setUserID(purchase.getUserID());
            existingPurchase.setPurchaseID(purchase.getPurchaseID());
            existingPurchase.setPrice(purchase.getPrice());
            existingPurchase.setItemName(purchase.getItemName());
            existingPurchase.setQuantity(purchase.getQuantity());

            return purchaseRepository.save(existingPurchase);
        }
        return null;
    }

    public void deletePurchase(Long id) {
        Purchase purchase = purchaseRepository.findById(id).orElse(null);
        if (purchase != null) {
            purchaseRepository.delete(purchase);
        }
    }

}
