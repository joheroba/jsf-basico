package tecsup.com.jsf3;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import trastienda.excepcion.DAOExcepcion;
import trastienda.modelo.Categoria;
import trastienda.modelo.Producto;
import trastienda.negocio.GestionCategorias;
import trastienda.negocio.GestionProductos;

@ManagedBean(name = "categoriaBean")
@RequestScoped
public class CategoriaBean {

    private int idCategoria;
    private String nombre;
    private String descripcion;
    private Collection<Categoria> categorias;
    private Collection<Producto> productos;

    public CategoriaBean() {
        GestionCategorias negocio = new GestionCategorias();
        try {
            categorias = negocio.listar();
            System.out.println("Total de categorías: "
                    + categorias.size());
        } catch (DAOExcepcion e) {
            e.printStackTrace();
        }
    }
