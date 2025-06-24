package biblioteca_app.controladores;

import biblioteca_app.datos.UsuarioDAO;
import biblioteca_app.presentacion.paneles.PanelForms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioController implements ActionListener {
    private UsuarioDAO usuarioDAO;
    private PanelForms panelForms;


    public UsuarioController(UsuarioDAO usuarioDAO,PanelForms panelForms){
        this.usuarioDAO = usuarioDAO;
        this.panelForms = panelForms;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = panelForms.getEmail().getText();
        String password = panelForms.getEmail().getText();

        Boolean validar = usuarioDAO.verificarPassword(email,password);

        if(validar){
            System.out.println("login correcto");
            //aqui cambiamos de frame para entrar a la app
        }
        else{
            System.out.println("error, email o contraseña incorrectos");
            // muestra texto de error de login
        }
    }
}
