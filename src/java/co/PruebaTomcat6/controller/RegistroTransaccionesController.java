package co.PruebaTomcat6.controller;

import co.PruebaTomcat6.entity.RegistroTransacciones;
import co.PruebaTomcat6.facade.RegistroTransaccionesFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "registroTransaccionesController")
@ViewScoped
public class RegistroTransaccionesController extends AbstractController<RegistroTransacciones> {

    @Inject
    private EmpleadosController idEmpleadoController;

    public RegistroTransaccionesController() {
        // Inform the Abstract parent controller of the concrete RegistroTransacciones Entity
        super(RegistroTransacciones.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idEmpleadoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Empleados controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdEmpleado(ActionEvent event) {
        RegistroTransacciones selected = this.getSelected();
        if (selected != null && idEmpleadoController.getSelected() == null) {
            idEmpleadoController.setSelected(selected.getIdEmpleado());
        }
    }

}
