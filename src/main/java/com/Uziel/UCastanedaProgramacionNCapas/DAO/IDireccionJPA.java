package com.Uziel.UCastanedaProgramacionNCapas.DAO;

import com.Uziel.UCastanedaProgramacionNCapas.ML.Direccion;
import com.Uziel.UCastanedaProgramacionNCapas.ML.Result;

public interface IDireccionJPA {

    Result DireccionGetByIdJPA(int IdDireccion);
    
    Result DireccionAddJPA(Direccion direccion, int IdUsuario);
    
    Result DireccionUpdateJPA(Direccion direccion);
    
    Result DireccionDeleteJPA(int IdDireccion);
    
}
