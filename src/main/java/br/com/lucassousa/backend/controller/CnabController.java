package br.com.lucassousa.backend.controller;

import br.com.lucassousa.backend.service.CnabService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cnab")
public class CnabController {
    private final CnabService service;

    public CnabController(CnabService service) {
        this.service = service;
    }

    @CrossOrigin(origins = {"http://localhost:9090"})
    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        service.uploadCnabFile(file);
        return  "Processamento iniciado com sucesso!";
    }
}
