package biblioteca_app.controladores;

import biblioteca_app.datos.UsuarioDAO;
import biblioteca_app.dominio.Usuario;
import biblioteca_app.presentacion.VentanaPrincipal;
import biblioteca_app.presentacion.paneles.RegistroFields;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PanelController implements ActionListener {
    private UsuarioDAO usuarioDAO;
    private VentanaPrincipal venntana;

    public PanelController(UsuarioDAO usuarioDAO, VentanaPrincipal ventana){
        this.usuarioDAO = usuarioDAO;
        this.venntana = ventana;
    }

    public boolean validaEntrada(){
        String email = venntana.getLoginPanel().getPanelForms().getEmail().getText();
        String password = String.valueOf(venntana.getLoginPanel().getPanelForms().getPassword().getText());

        boolean emailWrited = email.contains("@gmail.com") || email.contains("@hotmail.com");
        boolean passwordLenght = password.length()>8;
        boolean inputNotNull = !(email.isEmpty() && password.isEmpty());

        if(emailWrited && passwordLenght && inputNotNull)
            return usuarioDAO.verificarPassword(email,password);

        return false;
    }

    public boolean validarRegistro(String nombre,String dni,String email,String password){
        if(nombre.isEmpty()){
            System.out.println("nombre vacio");
            return false;
        }
        if(!(dni.length()==8)){
            System.out.println("el dni no es valido");
            return false;
        }
        if(!(email.contains("@gmail.com")||email.contains("@hotmail.com"))){
            System.out.println("email invalido");
            return false;
        }
        if(!(password.length()>=8)){
            System.out.println("la contraseña no tiene 8 caracteres");
            return false;
        }
        return true;
    }

    public void registrar(){
        RegistroFields rf = venntana.getRegistroView().getRegistroFields();

        String nombre = rf.getNombre().getText();
        String dni = rf.getDni().getText();
        String email = rf.getEmail().getText();
        String password = String.valueOf(rf.getPassword().getText());

        if(this.validarRegistro(nombre,dni,email,password)){
            Date fchAct = new Date();
            int year = fchAct.getYear();
            int month = fchAct.getMonth();
            int day = fchAct.getDay();
            Usuario usuario = new Usuario(dni,nombre,email,password,"cliente");
            usuarioDAO.agregarUsuario(usuario);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("enviar")){
            if(this.validaEntrada()) {
                Usuario usuario = usuarioDAO.buscarPorEmail(venntana.getLoginPanel().getPanelForms().getEmail().getText());
                String rol = usuario.getRol();
                System.out.println(usuario);
                venntana.mostrarPanelUsuario();
            }
            else {
                System.out.println("usuario no encontrado");
            }
        }
        if(e.getActionCommand().equals("registrar")){
            this.registrar();
            System.out.println("inicie sesion");
            venntana.mostrarPanelInicio();
        }
        if(e.getActionCommand().equals("registrarse")){venntana.mostarPanelRegistro();}
        if (e.getActionCommand().equals("volver")){venntana.mostrarPanelInicio();}
    }
}
