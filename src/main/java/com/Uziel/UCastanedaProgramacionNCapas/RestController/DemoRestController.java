package com.Uziel.UCastanedaProgramacionNCapas.RestController;

import com.Uziel.UCastanedaProgramacionNCapas.JPA.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest")
public class DemoRestController {
    
    @GetMapping("saludo")
    public ResponseEntity Saludo(@RequestParam("nombre") String nombre){
        Result result = new Result();
        
        try {
            
            if (nombre.isEmpty() && nombre.isBlank()) {
                result.correct = false;
                result.errorMessage = "No hay nadie a quien salidar Xc";
                result.status = 400;
            } else {
                String Saludar = "Hola " + nombre;
                result.object = Saludar;
                result.correct = true;
                result.status = 200;                
            }
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.status = 500;
        }
        return ResponseEntity.status(result.status).body(result);
    }
    
    @GetMapping("division")
    public ResponseEntity Division(@RequestParam("numero1") int numero1, @RequestParam("numero2") int numero2){
        Result result = new Result();
        
        try {
            
            if (numero2 == 0) {
                result.correct = false;
                result.errorMessage = "No puedes dividire entre 0 Syntax ERROR";
                result.status = 400;
            } else {
                int division = numero1 / numero2;
                result.correct = true;
                result.object = division;
                result.status = 200;
            }
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.status = 500;
        }
        return ResponseEntity.status(result.status).body(result);
    }
    
    @GetMapping("multiplicacion")
    public ResponseEntity Multiplicar(@RequestParam("numero1") int numero1, @RequestParam("numero2") int numero2){
        Result result = new Result();
        
        try {
            int multiplicar = numero1 * numero2;
            result.correct = true;
            result.object = multiplicar;
            result.status = 200;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.status = 500;
        }
        
        return ResponseEntity.status(result.status).body(result);
    }
    
    @GetMapping("sumaLista")
    public ResponseEntity sumaLista(@RequestParam("numeros") int [] numeros){
        Result result = new Result();
        
        try {
            
            if (numeros == null || numeros.length == 0) {
                result.correct = false;
                result.errorMessage = "No hay numeros para sumar";
                result.status = 400;
            } else {
                int suma = 0;
                for (int numero : numeros) {
                    suma = suma + numero;
                }
                result.correct = true;
                result.object = suma;
                result.status = 200;
            }
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.status = 500;
        }
        
        return ResponseEntity.status(result.status).body(result);
    }

}
