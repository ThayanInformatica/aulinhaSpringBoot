package com.aulinha.aulinha.Domain;


import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "usuarioseqGen", sequenceName = "seq_usuario", allocationSize = 1)
@Table(name = "tb_usuario")

public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioseqGen")
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "ds_cpf", nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(name = "ds_nome", nullable = false)
    private String nome;

    @Column(name = "ds_email", nullable = false)
    private String email;
}
