package com.TCU.service;

import com.TCU.domain.Beneficiado;
import java.time.LocalDate;
import java.util.List;

public interface BeneficiadoService {

    public List<Beneficiado> getBeneficiados(LocalDate date);

    public Beneficiado getBeneficiado(Beneficiado beneficiado);

    public void save(Beneficiado beneficiado);

    public void delete(Beneficiado beneficiado);

    public List<Beneficiado> getTodos();

    public List<Beneficiado> findAllBeneficiadosWithoutPensionInMonth();

    public List<Beneficiado> findAllBeneficiadosWithoutAyudaInMonth();

    public void updateAllBeneficiadosFecha(LocalDate newDate);
    
     public List<Beneficiado> getBeneficiadosOrdenado(LocalDate date);

}
