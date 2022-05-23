package Cuenta;

/*
Clase que modela una cuenta corriente. Incluye la forma
correcta de devolver atributos que son objetos para que 
no se produzca aliasing (getUltOp).

También incluye recorridos de arrays de manera circular
en sentido positivo (incrementando el índice) y también
en sentido inverso (decrementando el índice).

 */
import java.util.ArrayList;
import java.util.Arrays;

enum EstadoCuenta {
    OPERATIVA, CERRADA, INMOVILIZADA, NUMEROS_ROJOS;
}

enum TipoCuenta {
    AHORRO, CORRIENTE, NOMINA, VIVIENDA;
}

public class Cuenta {
    // Atributos

    private final Persona titular;
    private double saldo;
    private static TipoCuenta tipo;
    private int codigo;  //No proporcionamos metodos set
    private static int ultimoCodigo = 0;
    private EstadoCuenta estado;

    private ArrayList<Persona> cotitulares;
    private Movimiento[] ultOp;
    private int indiceOp = 0;
    private boolean ultOpLleno = false;
    // Constante
    private static final int NUMERO_ULTIMAS_OPERACIONES = 4;

    // Constructores
    public Cuenta(Persona t) {
        this.titular = t;
        this.codigo = getCodigoCuenta();
        Cuenta.tipo = TipoCuenta.CORRIENTE;//Por defecto
        this.estado = EstadoCuenta.OPERATIVA;
        this.ultOp = new Movimiento[NUMERO_ULTIMAS_OPERACIONES];
        this.cotitulares = new ArrayList<>();
    }

    public Cuenta(Persona titular, double saldoInicial) {
        this(titular);
        this.saldo = saldoInicial;

    }

    public Cuenta(Persona titular, double saldoInicial, Persona... pCotitulares) {
        this(titular, saldoInicial);
        if (pCotitulares.length > 0) {
            for (Persona c : pCotitulares) {
                this.cotitulares.add(c);
            }
        }
    }

    //Métodos set/get
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Persona getTitular() {
        return new Persona(titular.getNombre(), titular.getEdad(), titular.getSexo(), titular.getAltura(), titular.getPeso());
    }

    public static int getCodigoCuenta() {
        return ++ultimoCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public EstadoCuenta getEstado() {
        return estado;
    }

    public void setEstado(EstadoCuenta estado) {
        this.estado = estado;
    }

    public static TipoCuenta getTipo() {
        return tipo;
    }

    public static void setTipo(TipoCuenta tipo) {
        Cuenta.tipo = tipo;
    }

    public ArrayList<Persona> getCotitulares() {
        //return cotitulares; //No evita el aliasing 
        //return new ArrayList<>(cotitulares); //No evita el aliasing porque se copian las referencias a los objetos
        
        //Para evitar el aliasing se debe replicar todo
        ArrayList copia = new ArrayList<Persona>();
        Persona c;
        for(Persona p: cotitulares){
            c = new Persona(p.getNombre(),p.getEdad(),p.getSexo());
            copia.add(c);
        }
        return copia;
    }

    // Getters y Setter
    public void setCotitulares(ArrayList<Persona> cotitulares) {
        this.cotitulares = cotitulares;
    }

    public Movimiento[] getUltOp() {
        //devolvemos una copia del array ultOp con las operaciones
        //para evitar el aliasing
        Movimiento[] copia = new Movimiento[NUMERO_ULTIMAS_OPERACIONES];
        for(int i =0;i<this.ultOp.length;i++){
            copia[i]  =new Movimiento(this.ultOp[i].getCantidad(),this.ultOp[i].getConcepto());
        }
        return copia;
        /*
            Ojo!! Esto no soluciona el aliasing porque se copian las referencias, no los objetos
            Movimiento [] copia = Arrays.copyOf(this.ultOp,NUMERO_ULTIMAS_OPERACIONES);
            return copia;
        */
        /*
        Esto tampoco lo soluciona
        Movimiento[] copia = new Movimiento[NUMERO_ULTIMAS_OPERACIONES];
        for(int i =0;i<this.ultOp.length;i++){
            copia[i] = this.ultOp[i];
        }
        return copia;
        */
    }

    public void setUltOp(Movimiento[] ultOp) {
        this.ultOp = ultOp;
    }

    public void ingreso(double cantidad) {
        this.saldo += cantidad;
        anotaOperacion(cantidad, "Ingreso en cuenta", true);
    }

    public void ingreso(double... cantidad) {
        for (int i = 0; i < cantidad.length; i++) {
            this.saldo += cantidad[i];
            anotaOperacion(cantidad[i], "Ingreso en cuenta", true);
        }
    }

    public void ingreso(double cantidad, String concepto) {
        this.saldo += cantidad;
        anotaOperacion(cantidad, concepto, true);
    }

    public boolean reintegro(double cantidad) {
        if (cantidad > this.saldo) {
            return false;
        } else {
            this.saldo -= cantidad;
            anotaOperacion(cantidad, "Reintegro de cuenta", false);
            return true;
        }
    }

    public void reintegro(double... cantidad) {
        for (int i = 0; i < cantidad.length; i++) {
            if(this.saldo>=cantidad[i]){
                this.saldo -= cantidad[i];
                anotaOperacion(cantidad[i], "Reintegro en cuenta", false);
            }
        }
    }

    public boolean reintegro(double cantidad, String concepto) {
        if (cantidad > this.saldo) {
            return false;
        } else {
            this.saldo -= cantidad;
            anotaOperacion(cantidad, concepto, false);
            return true;
        }
    }

    private void anotaOperacion(double cantidad, String concepto, boolean esIngreso) {
        if (!esIngreso) {
            cantidad = cantidad * (-1);
        }
        Movimiento mov = new Movimiento(cantidad, concepto);

        this.ultOp[this.indiceOp] = mov;
        this.indiceOp++;
        if (this.indiceOp == this.ultOp.length) {
            this.ultOpLleno = true;
        }
        this.indiceOp = this.indiceOp % NUMERO_ULTIMAS_OPERACIONES;
    }

    public void muestraOperaciones() {
        if (!this.ultOpLleno) {
            for (int i = 0; i < this.ultOp.length; i++) {
                if (this.ultOp[i] != null) {
                    System.out.println(this.ultOp[i].getCantidad() + "->" + this.ultOp[i].getConcepto());
                }
            }
        } else {
            int indiceAnt = (this.indiceOp + (this.ultOp.length - 1)) % this.ultOp.length;

            int i = this.indiceOp;
            while (i != indiceAnt) {
                System.out.println(this.ultOp[i].getCantidad() + "->" + this.ultOp[i].getConcepto());
                i = ++i % this.ultOp.length;
            }

            System.out.println(this.ultOp[i].getCantidad() + "->" + this.ultOp[i].getConcepto());

        }
    }

    public void addCotitulares(Persona... pCotitulares) {
        for (Persona c : pCotitulares) {
            this.cotitulares.add(c);
        }
    }
    @Override
    public String toString(){
        String salida = "\nNombre "+this.titular.getNombre() +
                "\nEdad "+this.titular.getEdad() + 
                "\nTipo Cuenta "+ this.tipo + 
                "\nEstado Cuenta "+this.estado + 
                "\nSaldo "+this.saldo + 
                "\n";
         return salida;       
    }

}
