public class Tabla {
  private int[][] tabla;

  public Tabla() {
    this.tabla = new int[22][2];
    cargarTabla();
  }

  private void cargarTabla() {
    this.tabla[0][0] = 100000;
    this.tabla[0][1] = 98700;
    this.tabla[1][0] = 98660;
    this.tabla[1][1] = 395000;
    this.tabla[2][0] = 98430;
    this.tabla[2][1] = 491500;
    this.tabla[3][0] = 98304;
    this.tabla[3][1] = 491000;
    this.tabla[4][0] = 98153;
    this.tabla[4][1] = 489500;
    this.tabla[5][0] = 97713;
    this.tabla[5][1] = 487000;
    this.tabla[6][0] = 97090;
    this.tabla[6][1] = 484000;
    this.tabla[7][0] = 96354;
    this.tabla[7][1] = 479000;
    this.tabla[8][0] = 95482;
    this.tabla[8][1] = 475000;
    this.tabla[9][0] = 94428;
    this.tabla[9][1] = 469000;
    this.tabla[10][0] = 93164;
    this.tabla[10][1] = 461000;
    this.tabla[11][0] = 91374;
    this.tabla[11][1] = 450000;
    this.tabla[12][0] = 88737;
    this.tabla[12][1] = 433000;
    this.tabla[13][0] = 84833;
    this.tabla[13][1] = 410000;
    this.tabla[14][0] = 79152;
    this.tabla[14][1] = 376000;
    this.tabla[15][0] = 71439;
    this.tabla[15][1] = 330000;
    this.tabla[16][0] = 60710;
    this.tabla[16][1] = 270000;
    this.tabla[17][0] = 47119;
    this.tabla[17][1] = 198000;
    this.tabla[18][0] = 32208;
    this.tabla[18][1] = 125000;
    this.tabla[19][0] = 17889;
    this.tabla[19][1] = 58500;
    this.tabla[20][0] = 7562;
    this.tabla[20][1] = 19000;
    this.tabla[21][0] = 2243;
    this.tabla[21][1] = 5000;
  }

  public double calcularEsperanzaDeVida(int edadActual) {
    double esperanzaDeVida = 0;
    int pos = posEdadTabla(edadActual);
    if (pos < 21) {
      int sumatoria = 0;
      for (int i = pos; i < this.tabla.length; i++) {
        sumatoria += this.tabla[i][1];
      }
      esperanzaDeVida = (double) sumatoria / this.tabla[pos][0];
    } else {
      esperanzaDeVida = (double) this.tabla[pos][1] / this.tabla[pos][0];
    }
    return esperanzaDeVida;
  }

  private int posEdadTabla(int edad) {
    int pos;
    switch (edad) {
      case 1:
      case 2:
      case 3:
      case 4:
        pos = 1;
        break;
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
        pos = 2;
        break;
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
        pos = 3;
        break;
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
        pos = 4;
        break;
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
        pos = 5;
        break;
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
        pos = 6;
        break;
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
        pos = 7;
        break;
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
        pos = 8;
        break;
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
        pos = 9;
        break;
      case 45:
      case 46:
      case 47:
      case 48:
      case 49:
        pos = 10;
        break;
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
        pos = 11;
        break;
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
        pos = 12;
        break;
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
        pos = 13;
        break;
      case 65:
      case 66:
      case 67:
      case 68:
      case 69:
        pos = 14;
        break;
      case 70:
      case 71:
      case 72:
      case 73:
      case 74:
        pos = 15;
        break;
      case 75:
      case 76:
      case 77:
      case 78:
      case 79:
        pos = 16;
        break;
      case 80:
      case 81:
      case 82:
      case 83:
      case 84:
        pos = 17;
        break;
      case 85:
      case 86:
      case 87:
      case 88:
      case 89:
        pos = 18;
        break;
      case 90:
      case 91:
      case 92:
      case 93:
      case 94:
        pos = 19;
        break;
      case 95:
      case 96:
      case 97:
      case 98:
      case 99:
        pos = 20;
        break;
      default:
        pos = 21;
        break;
    }
    if (edad < 1) {
      pos = 0;
    }
    return pos;
  }
}
