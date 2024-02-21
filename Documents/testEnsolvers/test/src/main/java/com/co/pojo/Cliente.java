
package com.co.pojo;

import java.io.Serializable;
import java.security.Timestamp;
import javax.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;


@Data
@Entity
@Table(name="cliente")

public class Cliente implements Serializable{
    
   
   /* @Id
    private Integer idcliente;
    private String nombre;
    private String apellidos;
    private String usuario;
    private String password;
*/
    
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Cambié el nombre de idcliente a id

    private String titulo;  // Cambié nombre a titulo para que coincida con la base de datos
    private String contenido;
    private String categoria;
    private String etiquetas;
    @CreatedDate
    private Timestamp fecha_creacion;
    private Timestamp fecha_actualizacion;
    
}
