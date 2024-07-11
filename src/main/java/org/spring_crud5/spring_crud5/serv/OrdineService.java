package org.spring_crud5.spring_crud5.serv;

import java.util.List;

import org.spring_crud5.spring_crud5.pojo.Ordine;
import org.spring_crud5.spring_crud5.repo.OrdineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrdineService {

    @Autowired
    private OrdineRepo ordineRepository;

    public List<Ordine> getAllOrdini() {
        return ordineRepository.findAll();
    }

    public Ordine getOrdineById(int id) {
        return ordineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ordine not found with id " + id));
    }

    public void saveOrdine(Ordine ordine) {
        ordineRepository.save(ordine);
    }

    public void deleteOrdine(int id) {
        ordineRepository.deleteById(id);
    }

    public int calculateOrdineTotalPrice(Ordine ordine, boolean includeVat) {
        return ordine.getFullPrice(includeVat);
    }
}
