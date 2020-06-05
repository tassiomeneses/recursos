package br.com.recursos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDTO {

    private Long id;
    private String first_name;
    private String last_name;
    private String career;
    private String departament;

}