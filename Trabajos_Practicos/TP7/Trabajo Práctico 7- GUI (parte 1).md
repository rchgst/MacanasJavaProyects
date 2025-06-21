
**Ejercicio 1**: Dada  la clase ```VentanaEtiqueta``` y el archivo ```cafe.gif``` modifique el código de modo que el rótulo de la etiqueta sea "CAFÉ" y la imagen se obtenga del archivo mencionado.

Clase VentanaEtiqueta:

```java
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEtiqueta extends JFrame {
  // atributo de instancia
  JLabel etiqueta;

  // Constructor
  public VentanaEtiqueta(String tit) {
    super(tit);
    setSize(400, 300);
    etiqueta = new JLabel();
    etiqueta.setText("Cafe");
    etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
    getContentPane().setBackground(Color.GREEN);
    getContentPane().add(etiqueta);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
```

Clase Main:

```java
public class Main {
  public static void main(String[] args) {
    VentanaEtiqueta ventana = new VentanaEtiqueta("Ejercicio 1");
    ventana.setVisible(true);
  }
}
```

***

**Ejercicio 2**: Implemente una interfaz gráfica ```GUI_Bebida``` que contenga dos botones y una etiqueta. Los botones están rotulados como "Café" y "Jugo", y la funcionalidad de la interfaz es modificar la imagen de la etiqueta según se oprima un botón u otro. Utilice las imágenes provistas en los archivos gif.

Clase GUI_Bebida: 

```java
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Bebida extends JFrame {
  private JButton botonCafe, botonJugo;
  private JLabel etiqueta;

  public GUI_Bebida() {
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.etiqueta = new JLabel();
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    getContentPane().add(this.botonCafe);
    getContentPane().add(this.botonJugo);
    getContentPane().add(this.etiqueta);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 300);
  }

  class OyenteCafe implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
    }
  }

  class OyenteJugo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/Jugo.gif")));
    }
  }
}
```

Clase Main:

```java
public class Main {
  public static void main(String[] args) {
    GUI_Bebida gui = new GUI_Bebida();
    gui.setVisible(true);
  }
}
```

***

**Ejercicio 3**: Modifique la interfaz ```GUI_Bebida``` insertando las tres componentes gráficas sobre un panel.

Clase GUI_Bebida:

```java
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Bebida extends JFrame {
  private JButton botonCafe, botonJugo;
  private JLabel etiqueta;
  private JPanel panel;

  public GUI_Bebida() {
    setLayout(new GridLayout(1, 2));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 300);
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.etiqueta = new JLabel();
    this.panel = new JPanel(new FlowLayout());
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    this.panel.add(this.botonCafe);
    this.panel.add(this.botonJugo);
    this.panel.add(this.etiqueta);
    getContentPane().add(this.panel);
  }

  class OyenteCafe implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
    }
  }

  class OyenteJugo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/Jugo.gif")));
    }
  }
}
```

Clase Main:

```java
public class Main {
  public static void main(String[] args) {
    GUI_Bebida gui = new GUI_Bebida();
    gui.setVisible(true);
  }
}
```

***

**Ejercicio 4**: Analice el código de las clases ```VentanaPanelRojoBlanco``` y ```TestPanelBotones```, complete y observe la aplicación resultante.

La aplicación resultante es una ventana dividida en dos, una que contiene solo los botones y otra que tiene un fondo sin color. Cuando se presiona el botón "Rojo", la sección sin color cambia a Rojo. De forma análoga sucede lo mismo con "Blanco", cambiando a un fondo blanco.

Clase VentanaPanelRojoBlanco:

```java
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPanelRojoBlanco extends JFrame {
  // declaramos los botones y los paneles
  private JButton botonRojo, botonBlanco;
  private JPanel panelColor, panelBotones;

  public VentanaPanelRojoBlanco() {
    setLayout(new GridLayout(1, 2));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400, 120);

    // creamos los botones y los paneles
    botonRojo = new JButton("Rojo");
    botonBlanco = new JButton("Blanco");
    panelColor = new JPanel();
    panelBotones = new JPanel();
    panelBotones.setLayout(new FlowLayout());
    panelColor.setLayout(new FlowLayout());

    // creamos oyentes y los registramos a los botones
    // Completar!!!!
    OyenteBotonB oyenteB = new OyenteBotonB();
    OyenteBotonR oyenteR = new OyenteBotonR();

    botonRojo.addActionListener(oyenteR);
    botonBlanco.addActionListener(oyenteB);

    // insertamos los botones en el panel de botones, y los paneles en el panel de
    // contenido
    // el orden de estas instrucciones influye en la apariencia de la GUI
    panelBotones.add(botonRojo);
    panelBotones.add(botonBlanco);
    getContentPane().add(panelBotones);
    getContentPane().add(panelColor);
  }

  // Definimos clases para establecer el comportamiento de los botones, estas
  // clases son
  // internas a la clase VentanaPanelRojoBlanco por eso tiene acceso sus atributos
  // de instancia como panelColor
  private class OyenteBotonR implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evento) {
      panelColor.setBackground(Color.RED);
    }

  }

  private class OyenteBotonB implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent evento) {
      panelColor.setBackground(Color.WHITE);
    }

  }

}
```

Clase Test:

```java
import javax.swing.*;

public class TestPanelBotones {

  public static void main(String[] args) {
    VentanaPanelRojoBlanco v = new VentanaPanelRojoBlanco();
    v.setVisible(true);
  }

}
```

***

**Ejercicio 5**: Modifique la interfaz ```GUI_Bebida``` insertando los dos botones en un panel en la parte inferior de la interfaz y la etiqueta en un panel ubicado en la parte superior. Cada panel tiene que tener un color diferente de relleno y de borde. Cuando se modifica la imagen de la etiqueta se cambia también el color de relleno.

Clase GUI_Bebida:

```java
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Bebida extends JFrame {
  private JButton botonCafe, botonJugo;
  private JLabel etiqueta;
  private JPanel superior, inferior;

  public GUI_Bebida() {
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.etiqueta = new JLabel();
    this.superior = new JPanel(new FlowLayout());
    this.inferior = new JPanel();
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    this.superior.add(this.etiqueta);
    this.superior.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.inferior.add(this.botonCafe);
    this.inferior.add(this.botonJugo);
    this.inferior.setBorder(BorderFactory.createLineBorder(Color.RED));
    this.inferior.setBackground(Color.GRAY);
    getContentPane().add(BorderLayout.CENTER, this.superior);
    getContentPane().add(BorderLayout.SOUTH, this.inferior);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 300);
  }

  class OyenteCafe implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
      superior.setBackground(Color.YELLOW);
    }
  }

  class OyenteJugo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/Jugo.gif")));
      superior.setBackground(Color.CYAN);
    }
  }
}
```

Clase Main:

```java
public class Main {
  public static void main(String[] args) {
    GUI_Bebida gui = new GUI_Bebida();
    gui.setVisible(true);
  }
}
```

***

**Ejercicio 6**: Implemente una interfaz ```GUI_Dos_Bebidas``` con dos botones sobre un panel inferior y dos etiquetas sobre un panel superior. Según se oprima el botón "Café" o "Jugo" se muestra una imagen en una etiqueta u otra. Cuando se muestra la imagen de "Café", en la otra etiqueta se muestra un circulo blanco. De modo análogo, cuando se muestra la imagen de "Jugo" en la otra etiqueta se muestra un círculo blanco.

Clase GUI_Dos_Bebidas:

```java
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Dos_Bebidas extends JFrame {
  private JButton botonCafe, botonJugo;
  private JPanel inferior, superior;
  private JLabel etiquetaCafe, etiquetaJugo;

  public GUI_Dos_Bebidas() {
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.superior = new JPanel(new GridLayout(1, 2));
    this.inferior = new JPanel(new FlowLayout());
    this.etiquetaCafe = new JLabel();
    this.etiquetaJugo = new JLabel();
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    this.inferior.add(this.botonCafe);
    this.inferior.add(this.botonJugo);
    this.superior.add(this.etiquetaCafe);
    this.superior.add(this.etiquetaJugo);
    this.etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    this.etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    getContentPane().add(BorderLayout.SOUTH, this.inferior);
    getContentPane().add(BorderLayout.CENTER, this.superior);
    setSize(450, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  class OyenteCafe implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
      etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    }
  }

  class OyenteJugo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Jugo.gif")));
      etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    }
  }
}
```

Clase Main:

```java
public class Main {
  public static void main(String[] args) {
    GUI_Dos_Bebidas miFrame = new GUI_Dos_Bebidas();
    miFrame.setVisible(true);
  }
}
```

***

**Ejercicio 7**: Modifique la interfaz ```GUI_Dos_Bebidas``` agregando un panel en el centro que con dos etiquetas, una muestra la cantidad de veces que se oprimió el botón "Café" y otra la cantidad de veces que se oprimió "Jugo".

Clase GUI_Dos_Bebidas:

```java
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Dos_Bebidas extends JFrame {
  private JButton botonCafe, botonJugo;
  private JPanel inferior, superior, centro;
  private JLabel etiquetaCafe, etiquetaJugo, vecesCafeOprimido, vecesJugoOprimido;
  private int contCafe, contJugo;

  public GUI_Dos_Bebidas() {
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.superior = new JPanel(new GridLayout(1, 2));
    this.inferior = new JPanel(new FlowLayout());
    this.centro = new JPanel(new FlowLayout());
    this.etiquetaCafe = new JLabel();
    this.etiquetaJugo = new JLabel();
    this.vecesCafeOprimido = new JLabel();
    this.vecesJugoOprimido = new JLabel();
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    this.inferior.add(this.botonCafe);
    this.inferior.add(this.botonJugo);
    this.superior.add(this.etiquetaCafe);
    this.superior.add(this.etiquetaJugo);
    this.centro.add(this.vecesCafeOprimido);
    this.centro.add(this.vecesJugoOprimido);
    this.etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    this.etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    this.vecesCafeOprimido.setText("Veces que el boton cafe fue presionado: " + this.contCafe);
    this.vecesJugoOprimido.setText("Veces que el boton jugo fue presionado: " + this.contJugo);
    setLayout(new GridLayout(3, 1));
    getContentPane().add(this.superior);
    getContentPane().add(this.centro);
    getContentPane().add(this.inferior);
    setSize(600, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  class OyenteCafe implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
      etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
      ++contCafe;
      vecesCafeOprimido.setText("Veces que el boton cafe fue presionado: " + contCafe);
    }
  }

  class OyenteJugo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Jugo.gif")));
      etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
      ++contJugo;
      vecesJugoOprimido.setText("Veces que el boton jugo fue presionado: " + contJugo);
    }
  }
}
```

Clase Main:

```java
public class Main {
  public static void main(String[] args) {
    GUI_Dos_Bebidas miFrame = new GUI_Dos_Bebidas();
    miFrame.setVisible(true);
  }
}
```

***

**Ejercicio 8**: Analice el código de las clases ```Ventana``` y ```Test```, y observe cómo se comportan los ```JRadioButton```. Luego habilite el código comentado y vuelva a ejecutar la aplicación. ¿Qué ocurre ahora con los ```JRadioButton```?

Los ```JRadioButton```, al principio, no funcionan correctamente porque no pertenecen a un mismo grupo, por lo que puede seleccionarse ambas opciones. Luego de descomentar el código, ambos pertenecen ahora al mismo grupo, lo que hace que se comporten como deberían y ya solo se puede elegir una de las dos opciones.
