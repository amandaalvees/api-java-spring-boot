package model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity

public class cliente {
    private Long id;
    private String nome;
    private String endereco;
    private String status;
}

