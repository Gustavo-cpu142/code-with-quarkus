package org.acme.repository.proyecto;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.proyecto.Categoria;

@ApplicationScoped
public class CategoriaRepository implements PanacheRepositoryBase<Categoria, Integer> {

}
