package biblioteca_app.presentacion.paneles.panelesUsuario.libroPanels;

import javax.swing.*;

public class InfoPanel extends JPanel {
    private JLabel titulo;
    private JLabel autor;
    private JLabel isbn;
    private JLabel emision;
    private JLabel categoria;

    private JLabel resultTitulo,resultAutor,resultIsbn,resultEmision,resultCategoria;

    public InfoPanel(){
        titulo = new JLabel("titulo");
        autor = new JLabel("autor");
        isbn = new JLabel("isbn");
        emision = new JLabel("emision");
        categoria = new JLabel("categoria");

        resultTitulo = new JLabel("");
        resultAutor = new JLabel("");
        resultIsbn = new JLabel("");
        resultEmision = new JLabel("");
        resultCategoria = new JLabel("");

        add(titulo);
        add(resultTitulo);
        add(autor);
        add(resultAutor);
        add(isbn);
        add(resultIsbn);
        add(emision);
        add(resultEmision);
        add(categoria);
        add(resultCategoria);
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    public JLabel getResultTitulo() {
        return resultTitulo;
    }

    public void setResultTitulo(JLabel resultTitulo) {
        this.resultTitulo = resultTitulo;
    }

    public JLabel getResultAutor() {
        return resultAutor;
    }

    public void setResultAutor(JLabel resultAutor) {
        this.resultAutor = resultAutor;
    }

    public JLabel getResultIsbn() {
        return resultIsbn;
    }

    public void setResultIsbn(JLabel resultIsbn) {
        this.resultIsbn = resultIsbn;
    }

    public JLabel getResultEmision() {
        return resultEmision;
    }

    public void setResultEmision(JLabel resultEmision) {
        this.resultEmision = resultEmision;
    }

    public JLabel getResultCategoria() {
        return resultCategoria;
    }

    public void setResultCategoria(JLabel resultCategoria) {
        this.resultCategoria = resultCategoria;
    }
}
