package co.PruebaTomcat6.controller;

import co.PruebaTomcat6.entity.TiposIngresos;
import co.PruebaTomcat6.facade.TiposIngresosFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "tiposIngresosController")
@ViewScoped
public class TiposIngresosController extends AbstractController<TiposIngresos> {

    public TiposIngresosController() {
        // Inform the Abstract parent controller of the concrete TiposIngresos Entity
        super(TiposIngresos.class);
    }

}
