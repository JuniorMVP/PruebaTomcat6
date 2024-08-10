package co.PruebaTomcat6.controller;

import co.PruebaTomcat6.entity.TiposDeducciones;
import co.PruebaTomcat6.facade.TiposDeduccionesFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tiposDeduccionesController")
@ViewScoped
public class TiposDeduccionesController extends AbstractController<TiposDeducciones> {

    public TiposDeduccionesController() {
        // Inform the Abstract parent controller of the concrete TiposDeducciones Entity
        super(TiposDeducciones.class);
    }

}
