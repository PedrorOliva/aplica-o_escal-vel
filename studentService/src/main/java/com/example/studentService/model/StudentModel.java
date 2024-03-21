package com.example.studentService.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tb_student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class StudentModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "O nome é obrigatório!!")
  @Length(min = 3, max = 50, message = "O nome deverá ter no máximo {max} caracteres")
  private String name;

  @NotNull(message = "A idade é obrigatório!!")
  @Min(value = 6, message = "A idade deve ter no mínimo 1 número!")
  @Max(value = 99, message = "A idade deve ter no máximo 2 números!")
  private Integer age;

  @NotBlank(message = "O email é obrigatório!!")
  @Email(message = "Informe um email válido!!")
  private String email;
}
